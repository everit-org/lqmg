/**
 * This file is part of Everit - Liquibase-QueryDSL Model Generator.
 *
 * Everit - Liquibase-QueryDSL Model Generator is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Everit - Liquibase-QueryDSL Model Generator is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with Everit - Liquibase-QueryDSL Model Generator.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.everit.osgi.dev.lqmg;

import org.apache.commons.cli.BasicParser;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

public class LQMGMain {

    public static final String ARG_BUNDLES = "bundles";
    public static final String ARG_LQMG_CONFIG_XML = "configurationXML";
    public static final String ARG_OUTPUT_FOLDER = "outputFolder";
    public static final String ARG_PACKAGES = "packages";
    public static final String ARG_CAPABILITY = "capability";
    public static final String ARG_HACK_WIRES = "hackWires";
    public static final String ARG_INNER_CLASSES_FOR_KEYS = "innerClassesForKeys";
    public static final String ARG_DEFAULT_SCHEMA = "defaultSchema";

    private static String evaluateMandatoryOptionValue(final String key, final CommandLine commandLine,
            final Options options) {
        String result = commandLine.getOptionValue(key);
        if (result == null) {
            LQMGMain.printHelp(options);
            IllegalArgumentException e = new IllegalArgumentException("Missing mandatory argument: " + key);
            e.setStackTrace(new StackTraceElement[0]);
            throw e;
        }
        return result;
    }

    /**
     * The command line processor.
     *
     * @param args
     *            the arguments.
     */
    public static void main(final String[] args) {
        Options options = new Options();
        options.addOption("b", ARG_BUNDLES, true, "Location to the bundles separated by semicolon");
        options.addOption("p", ARG_PACKAGES, true, "Package names separated by comma that should be generated."
                + " If not defined, all packages will be generated.");
        options.addOption("cp", ARG_CAPABILITY, true, "Expression that is used to select the first schema based on the"
                + " capabilities that are provided by the bundles.");
        options.addOption("o", ARG_OUTPUT_FOLDER, true, "Path of the folder where the classes should be"
                + " generated");
        options.addOption("c", ARG_LQMG_CONFIG_XML, true, "Path of an optional configuration XML that can override"
                + " configurations coming from the capabilities");
        options.addOption("h", ARG_HACK_WIRES, true, "Whether to try redeploy bundles with unsatisfied constraintsin"
                + " the way that their requirements are changed to be optional. Default: true");
        options.addOption("h", ARG_INNER_CLASSES_FOR_KEYS, true,
                "Whether to generate inner classes for constraints. Default: true");
        options.addOption("ds", ARG_DEFAULT_SCHEMA, true,
                "Default schema where tables will be generated. This schema will be passed in the constructor of"
                + " the generated metadata classes where the liquibase changelog file does not contain"
                + " schema information. It is recommended to define a unique value and use the runtime schema"
                + " renaming functionality of QueryDSL.");

        CommandLineParser commandLineParser = new BasicParser();
        CommandLine commandLine;
        try {
            commandLine = commandLineParser.parse(options, args, true);
        } catch (ParseException e) {
            LQMGMain.printHelp(options);
            RuntimeException returnE = new RuntimeException(e);
            returnE.setStackTrace(new StackTraceElement[0]);
            throw returnE;
        }

        String outputFolder = LQMGMain.evaluateMandatoryOptionValue(ARG_OUTPUT_FOLDER, commandLine, options);
        String bundles = LQMGMain.evaluateMandatoryOptionValue(ARG_BUNDLES, commandLine, options);
        String changelog = LQMGMain.evaluateMandatoryOptionValue(ARG_CAPABILITY, commandLine, options);
        String packages = commandLine.getOptionValue(ARG_PACKAGES);
        String configurationXMLPath = commandLine.getOptionValue(ARG_LQMG_CONFIG_XML);
        String hackWires = commandLine.getOptionValue(ARG_HACK_WIRES);
        String innerClassesForKeys = commandLine.getOptionValue(ARG_INNER_CLASSES_FOR_KEYS);
        String defaultSchema = commandLine.getOptionValue(ARG_DEFAULT_SCHEMA);

        GenerationProperties generationProps = new GenerationProperties(changelog, bundles.split("\\;"), outputFolder);

        generationProps.setConfigurationPath(configurationXMLPath);
        generationProps.setDefaultSchema(defaultSchema);

        if (packages != null) {
            generationProps.setPackages(packages.split("\\,"));
        }

        if (hackWires != null) {
            generationProps.setHackWires(Boolean.valueOf(hackWires));
        }
        
        if (innerClassesForKeys != null) {
            generationProps.setHackWires(Boolean.valueOf(innerClassesForKeys));
        }

        LQMG.generate(generationProps);
    }

    private static void printHelp(final Options options) {
        HelpFormatter helperFormatter = new HelpFormatter();
        helperFormatter.printHelp("java -jar lqmg.jar", options);
    }
}
