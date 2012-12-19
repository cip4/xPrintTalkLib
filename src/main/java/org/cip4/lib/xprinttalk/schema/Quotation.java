
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


/**
 * <p>Java class for Quotation complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Quotation">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.printtalk.org/schema_2_0}BusinessObject">
 *       &lt;sequence>
 *         &lt;element name="Quote" type="{http://www.printtalk.org/schema_2_0}QuoteType" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *       &lt;attribute name="Currency" use="required" type="{http://www.CIP4.org/JDFSchema_2_0}NMTOKEN" />
 *       &lt;attribute name="Estimate" use="required" type="{http://www.CIP4.org/JDFSchema_2_0}boolean" />
 *       &lt;attribute name="Expires" use="required" type="{http://www.CIP4.org/JDFSchema_2_0}dateTime" />
 *       &lt;attribute name="ReorderID" type="{http://www.CIP4.org/JDFSchema_2_0}NMTOKENS" />
 *       &lt;attribute name="ReplaceID" type="{http://www.CIP4.org/JDFSchema_2_0}NMTOKEN" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Quotation", propOrder = {
    "quote"
})
public class Quotation
    extends BusinessObject
    implements Serializable
{

    @XmlElement(name = "Quote", required = true)
    protected List<QuoteType> quote;
    @XmlAttribute(name = "Currency", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String currency;
    @XmlAttribute(name = "Estimate", required = true)
    protected boolean estimate;
    @XmlAttribute(name = "Expires", required = true)
    protected String expires;
    @XmlAttribute(name = "ReorderID")
    protected List<String> reorderID;
    @XmlAttribute(name = "ReplaceID")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String replaceID;

    /**
     * Gets the value of the quote property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the quote property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getQuote().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link QuoteType }
     * 
     * 
     */
    public List<QuoteType> getQuote() {
        if (quote == null) {
            quote = new ArrayList<QuoteType>();
        }
        return this.quote;
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
     * Gets the value of the estimate property.
     * 
     */
    public boolean isEstimate() {
        return estimate;
    }

    /**
     * Sets the value of the estimate property.
     * 
     */
    public void setEstimate(boolean value) {
        this.estimate = value;
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

}
