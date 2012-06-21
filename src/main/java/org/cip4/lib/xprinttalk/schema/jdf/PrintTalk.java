
package org.cip4.lib.xprinttalk.schema.jdf;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PrintTalk complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PrintTalk">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Header" type="{http://www.printtalk.org/schema_13}Header"/>
 *         &lt;element name="Request" type="{http://www.printtalk.org/schema_13}Request"/>
 *       &lt;/sequence>
 *       &lt;attribute name="version" use="required" type="{http://www.printtalk.org/schema_13}Version" />
 *       &lt;attribute name="payloadID" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="timeStamp" type="{http://www.CIP4.org/JDFSchema_2_0}dateTime" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PrintTalk", propOrder = {
    "header",
    "request"
})
@XmlRootElement(name = "PrintTalk")
public class PrintTalk
    implements Serializable
{

    @XmlElement(name = "Header", required = true)
    protected Header header;
    @XmlElement(name = "Request", required = true)
    protected Request request;
    @XmlAttribute(required = true)
    protected String version;
    @XmlAttribute(required = true)
    protected String payloadID;
    @XmlAttribute
    protected String timeStamp;

    /**
     * Gets the value of the header property.
     * 
     * @return
     *     possible object is
     *     {@link Header }
     *     
     */
    public Header getHeader() {
        return header;
    }

    /**
     * Sets the value of the header property.
     * 
     * @param value
     *     allowed object is
     *     {@link Header }
     *     
     */
    public void setHeader(Header value) {
        this.header = value;
    }

    /**
     * Gets the value of the request property.
     * 
     * @return
     *     possible object is
     *     {@link Request }
     *     
     */
    public Request getRequest() {
        return request;
    }

    /**
     * Sets the value of the request property.
     * 
     * @param value
     *     allowed object is
     *     {@link Request }
     *     
     */
    public void setRequest(Request value) {
        this.request = value;
    }

    /**
     * Gets the value of the version property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVersion() {
        return version;
    }

    /**
     * Sets the value of the version property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVersion(String value) {
        this.version = value;
    }

    /**
     * Gets the value of the payloadID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPayloadID() {
        return payloadID;
    }

    /**
     * Sets the value of the payloadID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPayloadID(String value) {
        this.payloadID = value;
    }

    /**
     * Gets the value of the timeStamp property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTimeStamp() {
        return timeStamp;
    }

    /**
     * Sets the value of the timeStamp property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTimeStamp(String value) {
        this.timeStamp = value;
    }

}
