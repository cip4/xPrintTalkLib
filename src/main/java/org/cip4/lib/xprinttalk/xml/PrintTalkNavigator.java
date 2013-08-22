/**
 * All rights reserved by
 * 
 * flyeralarm GmbH
 * Alfred-Nobel-Straße 18
 * 97080 Würzburg
 *
 * Email: info@flyeralarm.com
 * Website: http://www.flyeralarm.com
 */
package org.cip4.lib.xprinttalk.xml;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import javax.xml.bind.JAXBException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;

import org.cip4.lib.xjdf.xml.XJdfConstants;
import org.cip4.lib.xjdf.xml.internal.XmlNavigator;

/**
 * Navigator class which simplify XPath handling using PrintTalk Documents.
 * @author s.meissner
 * @date 03.07.2012
 */
public class PrintTalkNavigator extends XmlNavigator {

	/**
	 * XPath to attribute 'TimeStamp' in PrintTalk Document.
	 */
	public static final String TIMESTAMP = "/PrintTalk/@Timestamp";

	/**
	 * XPath to attribute 'BusinessID' of PurchaseOrder Node in PrintTalk Document.
	 */
	public static final String BUSINESS_ID = "/PrintTalk/Request/PurchaseOrder/@BusinessID";

	/**
	 * XPath to attribute 'Currency' of PurchaseOrder Node in PrintTalk Document.
	 */
	public static final String CURRENCY = "/PrintTalk/Request/PurchaseOrder/@Currency";

	/**
	 * XPath to embedded XJDF Document in PrintTalk Document.
	 */
	public static final String XJDF = "/PrintTalk/Request/PurchaseOrder";

	/**
	 * Custom constructor. Accepting a PrintTalk as Input Stream for initializing.
	 * @param xPrintTalkStream The PrintTalk Document as Input Stream.
	 */
	public PrintTalkNavigator(InputStream xPrintTalkStream) throws Exception {

		// call super class
		super(xPrintTalkStream);
	}

	/**
	 * Custom constructor. Accepting a PrintTalk as Input Stream for initializing.
	 * @param xPrintTalkStream The PrintTalk Document as Input Stream.
	 * @param namespaceAware True if navigator should be XML Namespace aware.
	 */
	public PrintTalkNavigator(InputStream xPrintTalkStream, boolean namespaceAware) throws Exception {

		// call super class
		super(xPrintTalkStream, namespaceAware);

		// add namespace
		addNamespace("xjdf", XJdfConstants.NAMESPACE_JDF20);
	}

	/**
	 * Custom constructor. Accepting a PrintTalk as byte array for initializing.
	 * @param xPrintTalkBytes The PrintTalk Document as Byte Array.
	 * @throws Exception
	 */
	public PrintTalkNavigator(byte[] xPrintTalkBytes) throws Exception {
		super(new ByteArrayInputStream(xPrintTalkBytes));
	}

	/**
	 * Custom constructor. Accepting a PrintTalk as byte array for initializing.
	 * @param xPrintTalkBytes The PrintTalk Document as Byte Array.
	 * @param namespaceAware True if navigator should be XML Namespace aware.
	 * @throws Exception
	 */
	public PrintTalkNavigator(byte[] xPrintTalkBytes, boolean namespaceAware) throws Exception {
		this(new ByteArrayInputStream(xPrintTalkBytes), namespaceAware);
	}

	/**
	 * Custom constructor. Accepting a path for initializing.
	 * @param ptkPath The path to the PrintTalk Document.
	 * @throws Exception
	 */
	public PrintTalkNavigator(String ptkPath) throws Exception {
		this(new FileInputStream(ptkPath));
	}

	/**
	 * Custom constructor. Accepting a path for initializing.
	 * @param ptkPath The path to the PrintTalk Document.
	 * @param namespaceAware True if navigator should be XML Namespace aware.
	 * @throws Exception
	 */
	public PrintTalkNavigator(String ptkPath, boolean namespaceAware) throws Exception {
		this(new FileInputStream(ptkPath), namespaceAware);
	}

	/**
	 * Custom constructor. Accepting a file for initializing.
	 * @param ptkPath The file of the PrintTalk Document.
	 * @throws Exception
	 */
	public PrintTalkNavigator(File ptkFile) throws Exception {
		this(new FileInputStream(ptkFile));
	}

	/**
	 * Custom constructor. Accepting a file for initializing.
	 * @param ptkPath The file of the PrintTalk Document.
	 * @param namespaceAware True if navigator should be XML Namespace aware.
	 * @throws Exception
	 */
	public PrintTalkNavigator(File ptkFile, boolean namespaceAware) throws Exception {
		this(new FileInputStream(ptkFile), namespaceAware);
	}

	/**
	 * Returns the PrintTalk Document as Byte Array.
	 * @return PrintTalk Document as Byte Array.
	 * @throws Exception Is thrown in case an exception occurs.
	 */
	public byte[] getPtkBytes() throws Exception {
		return super.getXmlBytes();
	}

	/**
	 * Returns the PrintTalk Document as Stream.
	 * @return PrintTalk Document as Stream.
	 * @throws Exception Is thrown in case an exception occurs.
	 */
	public InputStream getPtkStream() throws Exception {
		return super.getXmlStream();
	}

	/**
	 * Read attribute from embedded XJdf Document in PrintTalk.
	 * @param xPath XPath expression of XJDF attribute needed.
	 * @return Value of attribute as String.
	 * @throws XPathExpressionException Is being thrown in case an exception occurs.
	 */
	public String readXJdfAttribute(String xPathXJdf) throws XPathExpressionException {

		// build XPath
		String xPath = XJDF + xPathXJdf;

		// return result
		return readAttribute(xPath);
	}

	/**
	 * Evaluates an XPath expression on PrintTalk Document and returns a parsed Node object as result.
	 * @param xPath XPath expression to execute to.
	 * @return The parsed PrintTalk Node object.
	 * @throws XPathExpressionException
	 * @throws JAXBException
	 */
	public Object extractNode(String xPath) throws XPathExpressionException, JAXBException {
		return super.extractNode(xPath, new PrintTalkParser());
	}

	/**
	 * Replace a node in PrintTalk Document located by the XPath expression.
	 * @param xPath Location of the node to be replaced.
	 * @param replacement The new node.
	 * @throws ParserConfigurationException
	 * @throws JAXBException
	 * @throws XPathExpressionException
	 */
	public void replaceNode(String xPath, Object replacement) throws XPathExpressionException, JAXBException, ParserConfigurationException {
		super.replaceNode(xPath, replacement, new PrintTalkParser());
	}
}
