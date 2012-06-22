
package org.cip4.lib.xprinttalk.schema.jdf;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlType;
import org.cip4.lib.xjdf.schema.jdf.Telem;


/**
 * <p>Java class for Payment complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Payment">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.printtalk.org/schema_2_0}Abstract_pt">
 *       &lt;sequence maxOccurs="unbounded" minOccurs="0">
 *         &lt;element name="PayTerm" type="{http://www.CIP4.org/JDFSchema_2_0}telem" minOccurs="0"/>
 *         &lt;element name="CreditCard" type="{http://www.printtalk.org/schema_2_0}CreditCard" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Payment", propOrder = {
    "payTermsAndCreditCards"
})
public class Payment
    extends AbstractPt
    implements Serializable
{

    @XmlElements({
        @XmlElement(name = "PayTerm", type = Telem.class),
        @XmlElement(name = "CreditCard", type = CreditCard.class)
    })
    protected List<Serializable> payTermsAndCreditCards;

    /**
     * Gets the value of the payTermsAndCreditCards property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the payTermsAndCreditCards property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPayTermsAndCreditCards().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Telem }
     * {@link CreditCard }
     * 
     * 
     */
    public List<Serializable> getPayTermsAndCreditCards() {
        if (payTermsAndCreditCards == null) {
            payTermsAndCreditCards = new ArrayList<Serializable>();
        }
        return this.payTermsAndCreditCards;
    }

}
