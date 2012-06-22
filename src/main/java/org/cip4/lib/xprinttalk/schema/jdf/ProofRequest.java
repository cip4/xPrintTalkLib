
package org.cip4.lib.xprinttalk.schema.jdf;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import org.cip4.lib.xjdf.schema.jdf.ProofItem;


/**
 * <p>Java class for ProofRequest complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ProofRequest">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.printtalk.org/schema_2_0}Abstract_pt">
 *       &lt;sequence>
 *         &lt;element name="ProofItem" type="{http://www.CIP4.org/JDFSchema_2_0}ProofItem"/>
 *       &lt;/sequence>
 *       &lt;attribute name="JobIDRef" type="{http://www.CIP4.org/JDFSchema_2_0}string" />
 *       &lt;attribute name="JobPartIDRef" type="{http://www.CIP4.org/JDFSchema_2_0}string" />
 *       &lt;attribute name="ProofLocation" type="{http://www.CIP4.org/JDFSchema_2_0}URI" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ProofRequest", propOrder = {
    "proofItem"
})
public class ProofRequest
    extends AbstractPt
    implements Serializable
{

    @XmlElement(name = "ProofItem", required = true)
    protected ProofItem proofItem;
    @XmlAttribute(name = "JobIDRef")
    protected String jobIDRef;
    @XmlAttribute(name = "JobPartIDRef")
    protected String jobPartIDRef;
    @XmlAttribute(name = "ProofLocation")
    protected String proofLocation;

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
     * Gets the value of the proofLocation property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProofLocation() {
        return proofLocation;
    }

    /**
     * Sets the value of the proofLocation property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProofLocation(String value) {
        this.proofLocation = value;
    }

}
