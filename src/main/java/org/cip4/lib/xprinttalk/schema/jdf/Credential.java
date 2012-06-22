
package org.cip4.lib.xprinttalk.schema.jdf;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import org.cip4.lib.xjdf.schema.jdf.Telem;


/**
 * 
 * 				A Credential identifies and authenticates the various parties involved in a transaction.
 * 			
 * 
 * <p>Java class for Credential complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Credential">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Identity" type="{http://www.CIP4.org/JDFSchema_2_0}telem"/>
 *         &lt;element name="SharedSecret" type="{http://www.printtalk.org/schema_2_0}cXML-SharedSecret" minOccurs="0"/>
 *         &lt;element name="CredentialMac" type="{http://www.printtalk.org/schema_2_0}cXML-CredentialMac" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="domain" use="required" type="{http://www.CIP4.org/JDFSchema_2_0}string" />
 *       &lt;attribute name="type" type="{http://www.CIP4.org/JDFSchema_2_0}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Credential", propOrder = {
    "identity",
    "sharedSecret",
    "credentialMac"
})
public class Credential
    implements Serializable
{

    @XmlElement(name = "Identity", required = true)
    protected Telem identity;
    @XmlElement(name = "SharedSecret")
    protected CXMLSharedSecret sharedSecret;
    @XmlElement(name = "CredentialMac")
    protected CXMLCredentialMac credentialMac;
    @XmlAttribute(name = "domain", required = true)
    protected String domain;
    @XmlAttribute(name = "type")
    protected String type;

    /**
     * Gets the value of the identity property.
     * 
     * @return
     *     possible object is
     *     {@link Telem }
     *     
     */
    public Telem getIdentity() {
        return identity;
    }

    /**
     * Sets the value of the identity property.
     * 
     * @param value
     *     allowed object is
     *     {@link Telem }
     *     
     */
    public void setIdentity(Telem value) {
        this.identity = value;
    }

    /**
     * Gets the value of the sharedSecret property.
     * 
     * @return
     *     possible object is
     *     {@link CXMLSharedSecret }
     *     
     */
    public CXMLSharedSecret getSharedSecret() {
        return sharedSecret;
    }

    /**
     * Sets the value of the sharedSecret property.
     * 
     * @param value
     *     allowed object is
     *     {@link CXMLSharedSecret }
     *     
     */
    public void setSharedSecret(CXMLSharedSecret value) {
        this.sharedSecret = value;
    }

    /**
     * Gets the value of the credentialMac property.
     * 
     * @return
     *     possible object is
     *     {@link CXMLCredentialMac }
     *     
     */
    public CXMLCredentialMac getCredentialMac() {
        return credentialMac;
    }

    /**
     * Sets the value of the credentialMac property.
     * 
     * @param value
     *     allowed object is
     *     {@link CXMLCredentialMac }
     *     
     */
    public void setCredentialMac(CXMLCredentialMac value) {
        this.credentialMac = value;
    }

    /**
     * Gets the value of the domain property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDomain() {
        return domain;
    }

    /**
     * Sets the value of the domain property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDomain(String value) {
        this.domain = value;
    }

    /**
     * Gets the value of the type property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setType(String value) {
        this.type = value;
    }

}
