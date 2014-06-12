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
//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.06.12 at 05:23:16 PM CEST 
//


package org.everit.osgi.dev.lqmg.internal.schema.xml;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.everit.osgi.dev.lqmg.internal.schema.xml package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _Lqmg_QNAME = new QName("http://everit.org/lqmg", "lqmg");
    private final static QName _PropertyMappingsTypeColumn_QNAME = new QName("http://everit.org/lqmg", "column");
    private final static QName _PropertyMappingsTypePrimaryKey_QNAME = new QName("http://everit.org/lqmg", "primaryKey");
    private final static QName _PropertyMappingsTypeForeignKey_QNAME = new QName("http://everit.org/lqmg", "foreignKey");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.everit.osgi.dev.lqmg.internal.schema.xml
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link LQMGType }
     * 
     */
    public LQMGType createLQMGType() {
        return new LQMGType();
    }

    /**
     * Create an instance of {@link ClassNameRuleType }
     * 
     */
    public ClassNameRuleType createClassNameRuleType() {
        return new ClassNameRuleType();
    }

    /**
     * Create an instance of {@link RegexRuleType }
     * 
     */
    public RegexRuleType createRegexRuleType() {
        return new RegexRuleType();
    }

    /**
     * Create an instance of {@link PropertyMappingsType }
     * 
     */
    public PropertyMappingsType createPropertyMappingsType() {
        return new PropertyMappingsType();
    }

    /**
     * Create an instance of {@link PropertyMappingType }
     * 
     */
    public PropertyMappingType createPropertyMappingType() {
        return new PropertyMappingType();
    }

    /**
     * Create an instance of {@link ColumnMappingType }
     * 
     */
    public ColumnMappingType createColumnMappingType() {
        return new ColumnMappingType();
    }

    /**
     * Create an instance of {@link NamingRulesType }
     * 
     */
    public NamingRulesType createNamingRulesType() {
        return new NamingRulesType();
    }

    /**
     * Create an instance of {@link AbstractNamingRuleType }
     * 
     */
    public AbstractNamingRuleType createAbstractNamingRuleType() {
        return new AbstractNamingRuleType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LQMGType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://everit.org/lqmg", name = "lqmg")
    public JAXBElement<LQMGType> createLqmg(LQMGType value) {
        return new JAXBElement<LQMGType>(_Lqmg_QNAME, LQMGType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PropertyMappingType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://everit.org/lqmg", name = "column", scope = PropertyMappingsType.class)
    public JAXBElement<PropertyMappingType> createPropertyMappingsTypeColumn(PropertyMappingType value) {
        return new JAXBElement<PropertyMappingType>(_PropertyMappingsTypeColumn_QNAME, PropertyMappingType.class, PropertyMappingsType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PropertyMappingType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://everit.org/lqmg", name = "primaryKey", scope = PropertyMappingsType.class)
    public JAXBElement<PropertyMappingType> createPropertyMappingsTypePrimaryKey(PropertyMappingType value) {
        return new JAXBElement<PropertyMappingType>(_PropertyMappingsTypePrimaryKey_QNAME, PropertyMappingType.class, PropertyMappingsType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PropertyMappingType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://everit.org/lqmg", name = "foreignKey", scope = PropertyMappingsType.class)
    public JAXBElement<PropertyMappingType> createPropertyMappingsTypeForeignKey(PropertyMappingType value) {
        return new JAXBElement<PropertyMappingType>(_PropertyMappingsTypeForeignKey_QNAME, PropertyMappingType.class, PropertyMappingsType.class, value);
    }

}
