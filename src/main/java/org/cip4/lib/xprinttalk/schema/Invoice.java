
package org.cip4.lib.xprinttalk.schema;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import org.cip4.lib.xjdf.schema.XJDF;


/**
 * <p>Java class for Invoice complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Invoice">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.printtalk.org/schema_2_0}BusinessObject">
 *       &lt;sequence>
 *         &lt;element ref="{http://www.CIP4.org/JDFSchema_2_0}XJDF" minOccurs="0"/>
 *         &lt;element name="Pricing" type="{http://www.printtalk.org/schema_2_0}Pricing"/>
 *       &lt;/sequence>
 *       &lt;attribute name="Currency" use="required" type="{http://www.CIP4.org/JDFSchema_2_0}NMTOKEN" />
 *       &lt;attribute name="Expires" use="required" type="{http://www.CIP4.org/JDFSchema_2_0}dateTime" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Invoice", propOrder = {
    "xjdf",
    "pricing"
})
public class Invoice
    extends BusinessObject
    implements Serializable
{

    @XmlElement(name = "XJDF", namespace = "http://www.CIP4.org/JDFSchema_2_0")
    protected XJDF xjdf;
    @XmlElement(name = "Pricing", required = true)
    protected Pricing pricing;
    @XmlAttribute(name = "Currency", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String currency;
    @XmlAttribute(name = "Expires", required = true)
    protected String expires;

    /**
     * Gets the value of the xjdf property.
     * 
     * @return
     *     possible object is
     *     {@link XJDF }
     *     
     */
    public XJDF getXJDF() {
        return xjdf;
    }

    /**
     * Sets the value of the xjdf property.
     * 
     * @param value
     *     allowed object is
     *     {@link XJDF }
     *     
     */
    public void setXJDF(XJDF value) {
        this.xjdf = value;
    }

    /**
     * Gets the value of the pricing property.
     * 
     * @return
     *     possible object is
     *     {@link Pricing }
     *     
     */
    public Pricing getPricing() {
        return pricing;
    }

    /**
     * Sets the value of the pricing property.
     * 
     * @param value
     *     allowed object is
     *     {@link Pricing }
     *     
     */
    public void setPricing(Pricing value) {
        this.pricing = value;
    }

    /**
     * Gets the value of the currency property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCurrency() {
        return currency;
    }

    /**
     * Sets the value of the currency property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCurrency(String value) {
        this.currency = value;
    }

    /**
     * Gets the value of the expires property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExpires() {
        return expires;
    }

    /**
     * Sets the value of the expires property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExpires(String value) {
        this.expires = value;
    }

}
