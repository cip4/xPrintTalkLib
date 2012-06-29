
package org.cip4.lib.xprinttalk.schema;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * <p>Java class for BusinessObject complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="BusinessObject">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.printtalk.org/schema_2_0}Abstract_pt">
 *       &lt;attribute name="AgentID" use="required" type="{http://www.CIP4.org/JDFSchema_2_0}NMTOKEN" />
 *       &lt;attribute name="AgentDisplayName" use="required" type="{http://www.CIP4.org/JDFSchema_2_0}string" />
 *       &lt;attribute name="AuxID" type="{http://www.CIP4.org/JDFSchema_2_0}NMTOKEN" />
 *       &lt;attribute name="BusinessID" use="required" type="{http://www.CIP4.org/JDFSchema_2_0}NMTOKEN" />
 *       &lt;attribute name="BusinessRefID" type="{http://www.CIP4.org/JDFSchema_2_0}NMTOKEN" />
 *       &lt;attribute name="RequestDate" type="{http://www.CIP4.org/JDFSchema_2_0}dateTime" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BusinessObject")
@XmlSeeAlso({
    Confirmation.class,
    Cancellation.class,
    ProofApprovalRequest.class,
    OrderStatusResponse.class,
    Quotation.class,
    Invoice.class,
    PurchaseOrder.class,
    ProofApprovalResponse.class,
    Refusal.class,
    ReturnJob.class,
    OrderStatusRequest.class,
    RFQ.class
})
public abstract class BusinessObject
    extends AbstractPt
    implements Serializable
{

    @XmlAttribute(name = "AgentID", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String agentID;
    @XmlAttribute(name = "AgentDisplayName", required = true)
    protected String agentDisplayName;
    @XmlAttribute(name = "AuxID")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String auxID;
    @XmlAttribute(name = "BusinessID", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String businessID;
    @XmlAttribute(name = "BusinessRefID")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String businessRefID;
    @XmlAttribute(name = "RequestDate")
    protected String requestDate;

    /**
     * Gets the value of the agentID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAgentID() {
        return agentID;
    }

    /**
     * Sets the value of the agentID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAgentID(String value) {
        this.agentID = value;
    }

    /**
     * Gets the value of the agentDisplayName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAgentDisplayName() {
        return agentDisplayName;
    }

    /**
     * Sets the value of the agentDisplayName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAgentDisplayName(String value) {
        this.agentDisplayName = value;
    }

    /**
     * Gets the value of the auxID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAuxID() {
        return auxID;
    }

    /**
     * Sets the value of the auxID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAuxID(String value) {
        this.auxID = value;
    }

    /**
     * Gets the value of the businessID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBusinessID() {
        return businessID;
    }

    /**
     * Sets the value of the businessID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBusinessID(String value) {
        this.businessID = value;
    }

    /**
     * Gets the value of the businessRefID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBusinessRefID() {
        return businessRefID;
    }

    /**
     * Sets the value of the businessRefID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBusinessRefID(String value) {
        this.businessRefID = value;
    }

    /**
     * Gets the value of the requestDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRequestDate() {
        return requestDate;
    }

    /**
     * Sets the value of the requestDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRequestDate(String value) {
        this.requestDate = value;
    }

}
