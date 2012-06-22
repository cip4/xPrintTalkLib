
package org.cip4.lib.xprinttalk.schema.jdf;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Status complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Status">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.printtalk.org/schema_2_0}Abstract_pt_B">
 *       &lt;attribute name="JobIDRef" use="required" type="{http://www.CIP4.org/JDFSchema_2_0}string" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Status")
public class Status
    extends AbstractPtB
    implements Serializable
{

    @XmlAttribute(name = "JobIDRef", required = true)
    protected String jobIDRef;

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

}
