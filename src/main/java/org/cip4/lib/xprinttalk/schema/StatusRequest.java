
package org.cip4.lib.xprinttalk.schema;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * <p>Java class for StatusRequest complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="StatusRequest">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.printtalk.org/schema_2_0}Abstract_pt">
 *       &lt;attribute name="JobIDRef" type="{http://www.CIP4.org/JDFSchema_2_0}string" />
 *       &lt;attribute name="JobPartIDRef" type="{http://www.CIP4.org/JDFSchema_2_0}string" />
 *       &lt;attribute name="ResponseDetails">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}NMTOKEN">
 *             &lt;enumeration value="Brief"/>
 *             &lt;enumeration value="CompletedMilestones"/>
 *             &lt;enumeration value="Full"/>
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
@XmlType(name = "StatusRequest")
public class StatusRequest
    extends AbstractPt
    implements Serializable
{

    @XmlAttribute(name = "JobIDRef")
    protected String jobIDRef;
    @XmlAttribute(name = "JobPartIDRef")
    protected String jobPartIDRef;
    @XmlAttribute(name = "ResponseDetails")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String responseDetails;

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
     * Gets the value of the responseDetails property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getResponseDetails() {
        return responseDetails;
    }

    /**
     * Sets the value of the responseDetails property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setResponseDetails(String value) {
        this.responseDetails = value;
    }

}
