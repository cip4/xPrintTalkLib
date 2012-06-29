
package org.cip4.lib.xprinttalk.schema;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for cXML-UserAgent complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="cXML-UserAgent">
 *   &lt;simpleContent>
 *     &lt;extension base="&lt;http://www.printtalk.org/schema_2_0>cXML-TextOnly">
 *     &lt;/extension>
 *   &lt;/simpleContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "cXML-UserAgent")
public class CXMLUserAgent
    extends CXMLTextOnly
    implements Serializable
{


}
