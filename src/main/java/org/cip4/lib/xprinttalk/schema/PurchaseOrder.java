
package org.cip4.lib.xprinttalk.schema;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import org.cip4.lib.xjdf.schema.XJDF;


/**
 * <p>Java class for PurchaseOrder complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PurchaseOrder">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.printtalk.org/schema_2_0}BusinessObject">
 *       &lt;sequence>
 *         &lt;element ref="{http://www.CIP4.org/JDFSchema_2_0}XJDF"/>
 *         &lt;element name="Pricing" type="{http://www.printtalk.org/schema_2_0}Pricing" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="Currency" type="{http://www.CIP4.org/JDFSchema_2_0}NMTOKEN" />
 *       &lt;attribute name="Expires" use="required" type="{http://www.CIP4.org/JDFSchema_2_0}dateTime" />
 *       &lt;attribute name="QuoteID" type="{http://www.CIP4.org/JDFSchema_2_0}NMTOKEN" />
 *       &lt;attribute name="ReorderID" type="{http://www.CIP4.org/JDFSchema_2_0}NMTOKENS" />
 *       &lt;attribute name="ReplaceID" type="{http://www.CIP4.org/JDFSchema_2_0}NMTOKEN" />
 *       &lt;attribute name="ReturnJDF" type="{http://www.CIP4.org/JDFSchema_2_0}boolean" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PurchaseOrder", propOrder = {
    "xjdf",
    "pricing"
})
public class PurchaseOrder
    extends BusinessObject
    implements Serializable
{

    @XmlElement(name = "XJDF", namespace = "http://www.CIP4.org/JDFSchema_2_0", required = true)
    protected XJDF xjdf;
    @XmlElement(name = "Pricing")
    protected Pricing pricing;
    @XmlAttribute(name = "Currency")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String currency;
    @XmlAttribute(name = "Expires", required = true)
    @XmlJavaTypeAdapter(org.cip4.lib.xjdf.type.DateTime.class)
    protected org.cip4.lib.xjdf.type.DateTime expires;
    @XmlAttribute(name = "QuoteID")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String quoteID;
    @XmlAttribute(name = "ReorderID")
    protected List<String> reorderID;
    @XmlAttribute(name = "ReplaceID")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String replaceID;
    @XmlAttribute(name = "ReturnJDF")
    protected Boolean returnJDF;

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
    public org.cip4.lib.xjdf.type.DateTime getExpires() {
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
    public void setExpires(org.cip4.lib.xjdf.type.DateTime value) {
        this.expires = value;
    }

    /**
     * Gets the value of the quoteID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getQuoteID() {
        return quoteID;
    }

    /**
     * Sets the value of the quoteID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setQuoteID(String value) {
        this.quoteID = value;
    }

    /**
     * Gets the value of the reorderID property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the reorderID property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getReorderID().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getReorderID() {
        if (reorderID == null) {
            reorderID = new ArrayList<String>();
        }
        return this.reorderID;
    }

    /**
     * Gets the value of the replaceID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReplaceID() {
        return replaceID;
    }

    /**
     * Sets the value of the replaceID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReplaceID(String value) {
        this.replaceID = value;
    }

    /**
     * Gets the value of the returnJDF property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isReturnJDF() {
        return returnJDF;
    }

    /**
     * Sets the value of the returnJDF property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setReturnJDF(Boolean value) {
        this.returnJDF = value;
    }

}
