
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
import org.cip4.lib.xjdf.schema.Notification;


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
 *         &lt;element ref="{http://www.CIP4.org/JDFSchema_2_0}Notification" maxOccurs="unbounded" minOccurs="0"/>
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
    "notification",
    "contact",
    "deliveryParams",
    "status"
})
public class OrderStatusResponse
    extends BusinessObject
    implements Serializable
{

    @XmlElement(name = "Notification", namespace = "http://www.CIP4.org/JDFSchema_2_0")
    protected List<Notification> notification;
    @XmlElement(name = "Contact", namespace = "http://www.CIP4.org/JDFSchema_2_0")
    protected List<Contact> contact;
    @XmlElement(name = "DeliveryParams", namespace = "http://www.CIP4.org/JDFSchema_2_0")
    protected DeliveryParams deliveryParams;
    @XmlElement(name = "Status")
    protected List<Status> status;

    /**
     * Gets the value of the notification property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the notification property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getNotification().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Notification }
     * 
     * 
     */
    public List<Notification> getNotification() {
        if (notification == null) {
            notification = new ArrayList<Notification>();
        }
        return this.notification;
    }

    /**
     * Gets the value of the contact property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the contact property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getContact().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Contact }
     * 
     * 
     */
    public List<Contact> getContact() {
        if (contact == null) {
            contact = new ArrayList<Contact>();
        }
        return this.contact;
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
     * Gets the value of the status property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the status property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getStatus().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Status }
     * 
     * 
     */
    public List<Status> getStatus() {
        if (status == null) {
            status = new ArrayList<Status>();
        }
        return this.status;
    }

}
