
package org.cip4.lib.xprinttalk.schema;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import org.cip4.lib.xjdf.schema.Contact;


/**
 * <p>Java class for ProofApprovalResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ProofApprovalResponse">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.printtalk.org/schema_2_0}BusinessObject">
 *       &lt;sequence>
 *         &lt;element ref="{http://www.CIP4.org/JDFSchema_2_0}Contact" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="ProofResponse" type="{http://www.printtalk.org/schema_2_0}ProofResponse" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ProofApprovalResponse", propOrder = {
    "contact",
    "proofResponse"
})
public class ProofApprovalResponse
    extends BusinessObject
    implements Serializable
{

    @XmlElement(name = "Contact", namespace = "http://www.CIP4.org/JDFSchema_2_0")
    protected List<Contact> contact;
    @XmlElement(name = "ProofResponse")
    protected List<ProofResponse> proofResponse;

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
     * Gets the value of the proofResponse property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the proofResponse property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getProofResponse().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ProofResponse }
     * 
     * 
     */
    public List<ProofResponse> getProofResponse() {
        if (proofResponse == null) {
            proofResponse = new ArrayList<ProofResponse>();
        }
        return this.proofResponse;
    }

}
