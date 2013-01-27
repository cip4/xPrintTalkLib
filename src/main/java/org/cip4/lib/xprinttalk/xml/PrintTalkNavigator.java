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

import java.io.IOException;
import java.io.InputStream;

import javax.xml.xpath.XPathExpressionException;

import org.cip4.lib.xjdf.xml.internal.XPathNavigatorBase;

/**
 * Navigator class which simplify XPath handling using PrintTalk Documents.
 * @author s.meissner
 * @date 03.07.2012
 */
public class PrintTalkNavigator extends XPathNavigatorBase {

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
	 * Custom private default constructor. Accepting a XJdf InputStream for initializing.
	 * @param xJdfStream The XJDF Input Stream.
	 */
	private PrintTalkNavigator(InputStream xPrintTalkStream) throws Exception {
		super(xPrintTalkStream);
	}

	/**
	 * Factory method for creating a new XJdfNavigator object.
	 * @param xmlStream XML document as input stream.
	 * @return Initialized XPathNavigator instance.
	 * @throws IOException Is being thrown in case an exception occurs.
	 */
	public static PrintTalkNavigator newInstance(InputStream xmlStream) throws Exception {

		// create and return new instance
		return new PrintTalkNavigator(xmlStream);
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
}
