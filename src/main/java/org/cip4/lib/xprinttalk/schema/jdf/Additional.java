
package org.cip4.lib.xprinttalk.schema.jdf;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Additional complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Additional">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.printtalk.org/schema_13}Abstract_pt">
 *       &lt;attribute name="Amount" use="required" type="{http://www.CIP4.org/JDFSchema_2_0}double" />
 *       &lt;attribute name="Price" use="required" type="{http://www.CIP4.org/JDFSchema_2_0}double" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Additional")
public class Additional
    extends AbstractPt
    implements Serializable
{

    @XmlAttribute(name = "Amount", required = true)
    protected double amount;
    @XmlAttribute(name = "Price", required = true)
    protected double price;

    /**
     * Gets the value of the amount property.
     * 
     */
    public double getAmount() {
        return amount;
    }

    /**
     * Sets the value of the amount property.
     * 
     */
    public void setAmount(double value) {
        this.amount = value;
    }

    /**
     * Gets the value of the price property.
     * 
     */
    public double getPrice() {
        return price;
    }

    /**
     * Sets the value of the price property.
     * 
     */
    public void setPrice(double value) {
        this.price = value;
    }

}
