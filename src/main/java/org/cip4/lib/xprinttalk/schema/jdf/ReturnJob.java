
package org.cip4.lib.xprinttalk.schema.jdf;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import org.cip4.lib.xjdf.schema.jdf.XJDF;


/**
 * <p>Java class for ReturnJob complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ReturnJob">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.printtalk.org/schema_2_0}BusinessObject">
 *       &lt;sequence>
 *         &lt;element ref="{http://www.CIP4.org/JDFSchema_2_0}XJDF"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ReturnJob", propOrder = {
    "xjdf"
})
public class ReturnJob
    extends BusinessObject
    implements Serializable
{

    @XmlElement(name = "XJDF", namespace = "http://www.CIP4.org/JDFSchema_2_0", required = true)
    protected XJDF xjdf;

    /**
     * Gets the value of the xjdf property.
     * 
     * @return
     *     possible object is
     *     {@link XJDF }
     *     
     */
    public XJDF getXJDF() {
        return xjdf;
    }

    /**
     * Sets the value of the xjdf property.
     * 
     * @param value
     *     allowed object is
     *     {@link XJDF }
     *     
     */
    public void setXJDF(XJDF value) {
        this.xjdf = value;
    }

}
