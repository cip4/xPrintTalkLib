
package org.cip4.lib.xprinttalk.schema.jdf;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ReturnJob complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ReturnJob">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.printtalk.org/schema_13}BusinessObject">
 *       &lt;sequence>
 *         &lt;element name="Pricing" type="{http://www.printtalk.org/schema_13}Pricing"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ReturnJob", propOrder = {
    "pricing"
})
public class ReturnJob
    extends BusinessObject
    implements Serializable
{

    @XmlElement(name = "Pricing", required = true)
    protected Pricing pricing;

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

}
