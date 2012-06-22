
package org.cip4.lib.xprinttalk.schema.jdf;

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
import org.cip4.lib.xjdf.schema.jdf.XJDF;


/**
 * <p>Java class for QuoteType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="QuoteType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.printtalk.org/schema_2_0}Abstract_pt">
 *       &lt;sequence minOccurs="0">
 *         &lt;element ref="{http://www.CIP4.org/JDFSchema_2_0}XJDF"/>
 *         &lt;element name="Pricing" type="{http://www.printtalk.org/schema_2_0}Pricing"/>
 *       &lt;/sequence>
 *       &lt;attribute name="Currency" type="{http://www.CIP4.org/JDFSchema_2_0}NMTOKEN" />
 *       &lt;attribute name="Estimate" type="{http://www.CIP4.org/JDFSchema_2_0}boolean" />
 *       &lt;attribute name="Expires" type="{http://www.CIP4.org/JDFSchema_2_0}dateTime" />
 *       &lt;attribute name="QuoteID" use="required" type="{http://www.CIP4.org/JDFSchema_2_0}NMTOKEN" />
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
@XmlType(name = "QuoteType", propOrder = {
    "xjdf",
    "pricing"
})
public class QuoteType
    extends AbstractPt
    implements Serializable
{

    @XmlElement(name = "XJDF", namespace = "http://www.CIP4.org/JDFSchema_2_0")
    protected XJDF xjdf;
    @XmlElement(name = "Pricing")
    protected Pricing pricing;
    @XmlAttribute(name = "Currency")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String currency;
    @XmlAttribute(name = "Estimate")
    protected Boolean estimate;
    @XmlAttribute(name = "Expires")
    protected String expires;
    @XmlAttribute(name = "QuoteID", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String quoteID;
    @XmlAttribute(name = "ReorderID")
    protected List<String> reorderIDs;
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
     * Gets the value of the estimate property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isEstimate() {
        return estimate;
    }

    /**
     * Sets the value of the estimate property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setEstimate(Boolean value) {
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
     * Gets the value of the reorderIDs property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the reorderIDs property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getReorderIDs().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getReorderIDs() {
        if (reorderIDs == null) {
            reorderIDs = new ArrayList<String>();
        }
        return this.reorderIDs;
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
