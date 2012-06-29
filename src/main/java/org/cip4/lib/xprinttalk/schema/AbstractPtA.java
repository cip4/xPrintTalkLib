
package org.cip4.lib.xprinttalk.schema;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 * 				This is a special version of the Abstract pt Element without the optional DescriptiveName attribute 
 * 			
 * 
 * <p>Java class for Abstract_pt_A complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Abstract_pt_A">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.printtalk.org/schema_2_0}Abstract_pt">
 *       &lt;sequence>
 *         &lt;element ref="{http://www.CIP4.org/JDFSchema_2_0}Comment" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{http://www.CIP4.org/JDFSchema_2_0}GeneralID" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="DescriptiveName" use="required" type="{http://www.CIP4.org/JDFSchema_2_0}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Abstract_pt_A")
@XmlSeeAlso({
    Price.class
})
public abstract class AbstractPtA
    extends AbstractPt
    implements Serializable
{


}
