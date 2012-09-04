
package org.cip4.lib.xprinttalk.schema;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import org.cip4.lib.xjdf.schema.Contact;
import org.cip4.lib.xjdf.schema.DeliveryParams;


/**
 * <p>Java class for OrderStatusResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="OrderStatusResponse">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.printtalk.org/schema_2_0}BusinessObject">
 *       &lt;sequence>
 *         &lt;element ref="{http://www.CIP4.org/JDFSchema_2_0}Contact" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{http://www.CIP4.org/JDFSchema_2_0}DeliveryParams" minOccurs="0"/>
 *         &lt;element name="Status" type="{http://www.printtalk.org/schema_2_0}Status" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "OrderStatusResponse", propOrder = {
    "contacts",
    "deliveryParams",
    "statuses"
})
public class OrderStatusResponse
    extends BusinessObject
    implements Serializable
{

    @XmlElement(name = "Contact", namespace = "http://www.CIP4.org/JDFSchema_2_0")
    protected List<Contact> contacts;
    @XmlElement(name = "DeliveryParams", namespace = "http://www.CIP4.org/JDFSchema_2_0")
    protected DeliveryParams deliveryParams;
    @XmlElement(name = "Status")
    protected List<Status> statuses;

    /**
     * Gets the value of the contacts property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the contacts property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getContacts().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Contact }
     * 
     * 
     */
    public List<Contact> getContacts() {
        if (contacts == null) {
            contacts = new ArrayList<Contact>();
        }
        return this.contacts;
    }

    /**
     * Gets the value of the deliveryParams property.
     * 
     * @return
     *     possible object is
     *     {@link DeliveryParams }
     *     
     */
    public DeliveryParams getDeliveryParams() {
        return deliveryParams;
    }

    /**
     * Sets the value of the deliveryParams property.
     * 
     * @param value
     *     allowed object is
     *     {@link DeliveryParams }
     *     
     */
    public void setDeliveryParams(DeliveryParams value) {
        this.deliveryParams = value;
    }

    /**
     * Gets the value of the statuses property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the statuses property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getStatuses().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Status }
     * 
     * 
     */
    public List<Status> getStatuses() {
        if (statuses == null) {
            statuses = new ArrayList<Status>();
        }
        return this.statuses;
    }

}
