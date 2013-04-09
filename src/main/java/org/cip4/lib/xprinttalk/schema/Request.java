
package org.cip4.lib.xprinttalk.schema;

import java.io.Serializable;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Request complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Request">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://www.printtalk.org/schema_2_0}BusinessObject"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Request", propOrder = {
    "businessObject"
})
public class Request
    implements Serializable
{

    @XmlElementRef(name = "BusinessObject", namespace = "http://www.printtalk.org/schema_2_0", type = JAXBElement.class)
    protected JAXBElement<? extends BusinessObject> businessObject;

    /**
     * Gets the value of the businessObject property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Refusal }{@code >}
     *     {@link JAXBElement }{@code <}{@link Quotation }{@code >}
     *     {@link JAXBElement }{@code <}{@link Cancellation }{@code >}
     *     {@link JAXBElement }{@code <}{@link ProofApprovalRequest }{@code >}
     *     {@link JAXBElement }{@code <}{@link ReturnJob }{@code >}
     *     {@link JAXBElement }{@code <}{@link PurchaseOrder }{@code >}
     *     {@link JAXBElement }{@code <}{@link RFQ }{@code >}
     *     {@link JAXBElement }{@code <}{@link ProofApprovalResponse }{@code >}
     *     {@link JAXBElement }{@code <}{@link Quotation }{@code >}
     *     {@link JAXBElement }{@code <}{@link BusinessObject }{@code >}
     *     {@link JAXBElement }{@code <}{@link Invoice }{@code >}
     *     {@link JAXBElement }{@code <}{@link OrderStatusRequest }{@code >}
     *     {@link JAXBElement }{@code <}{@link Confirmation }{@code >}
     *     {@link JAXBElement }{@code <}{@link OrderStatusResponse }{@code >}
     *     
     */
    public JAXBElement<? extends BusinessObject> getBusinessObject() {
        return businessObject;
    }

    /**
     * Sets the value of the businessObject property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Refusal }{@code >}
     *     {@link JAXBElement }{@code <}{@link Quotation }{@code >}
     *     {@link JAXBElement }{@code <}{@link Cancellation }{@code >}
     *     {@link JAXBElement }{@code <}{@link ProofApprovalRequest }{@code >}
     *     {@link JAXBElement }{@code <}{@link ReturnJob }{@code >}
     *     {@link JAXBElement }{@code <}{@link PurchaseOrder }{@code >}
     *     {@link JAXBElement }{@code <}{@link RFQ }{@code >}
     *     {@link JAXBElement }{@code <}{@link ProofApprovalResponse }{@code >}
     *     {@link JAXBElement }{@code <}{@link Quotation }{@code >}
     *     {@link JAXBElement }{@code <}{@link BusinessObject }{@code >}
     *     {@link JAXBElement }{@code <}{@link Invoice }{@code >}
     *     {@link JAXBElement }{@code <}{@link OrderStatusRequest }{@code >}
     *     {@link JAXBElement }{@code <}{@link Confirmation }{@code >}
     *     {@link JAXBElement }{@code <}{@link OrderStatusResponse }{@code >}
     *     
     */
    public void setBusinessObject(JAXBElement<? extends BusinessObject> value) {
        this.businessObject = value;
    }

}
