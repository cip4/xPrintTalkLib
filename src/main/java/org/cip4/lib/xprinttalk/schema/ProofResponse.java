
package org.cip4.lib.xprinttalk.schema;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import org.cip4.lib.xjdf.schema.ApprovalSuccess;
import org.cip4.lib.xjdf.schema.ProofItem;


/**
 * <p>Java class for ProofResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ProofResponse">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.printtalk.org/schema_2_0}Abstract_pt">
 *       &lt;sequence>
 *         &lt;element ref="{http://www.CIP4.org/JDFSchema_2_0}ApprovalSuccess"/>
 *         &lt;element name="ProofItem" type="{http://www.CIP4.org/JDFSchema_2_0}ProofItem"/>
 *       &lt;/sequence>
 *       &lt;attribute name="JobIDRef" type="{http://www.CIP4.org/JDFSchema_2_0}string" />
 *       &lt;attribute name="JobPartIDRef" type="{http://www.CIP4.org/JDFSchema_2_0}string" />
 *       &lt;attribute name="PageIndex" type="{http://www.CIP4.org/JDFSchema_2_0}IntegerRangeList" />
 *       &lt;attribute name="Response">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}NMTOKEN">
 *             &lt;enumeration value="Approved"/>
 *             &lt;enumeration value="ApprovedWithEdits"/>
 *             &lt;enumeration value="Rejected"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ProofResponse", propOrder = {
    "approvalSuccess",
    "proofItem"
})
public class ProofResponse
    extends AbstractPt
    implements Serializable
{

    @XmlElement(name = "ApprovalSuccess", namespace = "http://www.CIP4.org/JDFSchema_2_0", required = true)
    protected ApprovalSuccess approvalSuccess;
    @XmlElement(name = "ProofItem", required = true)
    protected ProofItem proofItem;
    @XmlAttribute(name = "JobIDRef")
    protected String jobIDRef;
    @XmlAttribute(name = "JobPartIDRef")
    protected String jobPartIDRef;
    @XmlAttribute(name = "PageIndex")
    protected Integer pageIndex;
    @XmlAttribute(name = "Response")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String response;

    /**
     * Gets the value of the approvalSuccess property.
     * 
     * @return
     *     possible object is
     *     {@link ApprovalSuccess }
     *     
     */
    public ApprovalSuccess getApprovalSuccess() {
        return approvalSuccess;
    }

    /**
     * Sets the value of the approvalSuccess property.
     * 
     * @param value
     *     allowed object is
     *     {@link ApprovalSuccess }
     *     
     */
    public void setApprovalSuccess(ApprovalSuccess value) {
        this.approvalSuccess = value;
    }

    /**
     * Gets the value of the proofItem property.
     * 
     * @return
     *     possible object is
     *     {@link ProofItem }
     *     
     */
    public ProofItem getProofItem() {
        return proofItem;
    }

    /**
     * Sets the value of the proofItem property.
     * 
     * @param value
     *     allowed object is
     *     {@link ProofItem }
     *     
     */
    public void setProofItem(ProofItem value) {
        this.proofItem = value;
    }

    /**
     * Gets the value of the jobIDRef property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getJobIDRef() {
        return jobIDRef;
    }

    /**
     * Sets the value of the jobIDRef property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setJobIDRef(String value) {
        this.jobIDRef = value;
    }

    /**
     * Gets the value of the jobPartIDRef property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getJobPartIDRef() {
        return jobPartIDRef;
    }

    /**
     * Sets the value of the jobPartIDRef property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setJobPartIDRef(String value) {
        this.jobPartIDRef = value;
    }

    /**
     * Gets the value of the pageIndex property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getPageIndex() {
        return pageIndex;
    }

    /**
     * Sets the value of the pageIndex property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setPageIndex(Integer value) {
        this.pageIndex = value;
    }

    /**
     * Gets the value of the response property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getResponse() {
        return response;
    }

    /**
     * Sets the value of the response property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setResponse(String value) {
        this.response = value;
    }

}
