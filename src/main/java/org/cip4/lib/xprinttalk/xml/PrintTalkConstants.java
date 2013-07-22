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
import java.util.Properties;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;

import org.apache.commons.io.IOUtils;
import org.cip4.lib.xjdf.xml.XJdfConstants;
import org.cip4.lib.xjdf.xml.internal.NamespaceManager;
import org.xml.sax.InputSource;

/**
 * This class provides common PrintTalk default values.
 * @author s.meissner
 * @date 22.06.2012
 */
public class PrintTalkConstants {

	/**
	 * Default Namespace PrintTalk,
	 */
	public static final String NAMESPACE_PTK20 = loadNamespacePtk20();

	public static final String PTK_LIB_VERSION = loadLibraryVersion();

	public static final String PTK_LIB_BUILD_DATE = loadLibraryBuildDate();

	public static final String PTK_CURRENT_VERSION = "2.0";

	public static final byte[] PTK_XSD_BYTES = loadPtkByteArray();

	private static final String RES_BUILD_PROPS = "/org/cip4/lib/xprinttalk/build.properties";

	private static final String RES_PTK20_XSD = "/org/cip4/lib/xprinttalk/xsd/PrintTalk20.xsd";

	/**
	 * Load PrintTalk XSD as byte array.
	 * @return PrintTalk Schema as byte array.
	 */
	private static byte[] loadPtkByteArray() {

		// load xsd
		byte[] bytes = null;

		try {
			InputStream is = PrintTalkConstants.class.getResourceAsStream(RES_PTK20_XSD);
			bytes = IOUtils.toByteArray(is);
			is.close();
		} catch (Exception ex) {
		}

		// return
		return bytes;
	}

	/**
	 * Load the JDF20 Namespace from schema file.
	 * @return
	 */
	private static String loadNamespacePtk20() {

		String result;

		// new namespace manager
		NamespaceManager nsManager = new NamespaceManager();
		nsManager.addNamespace("xs", XJdfConstants.NAMESPACE_W3_XML);

		// create xpath query
		XPathFactory xPathFactory = XPathFactory.newInstance();
		XPath xPath = xPathFactory.newXPath();
		xPath.setNamespaceContext(nsManager);

		try {
			XPathExpression xPathExpression = xPath.compile("/xs:schema/@targetNamespace");

			// execute xPath query
			InputStream is = XJdfConstants.class.getResourceAsStream(RES_PTK20_XSD);
			result = xPathExpression.evaluate(new InputSource(is));

		} catch (Exception ex) {
			// throw error
			throw new AssertionError(ex);
		}

		// return result
		return result;
	}

	/**
	 * Load and returns schema as input stream object.
	 * @return schema as input stream
	 */
	public static InputStream loadSchema() {

		// load and return
		return PrintTalkConstants.class.getResourceAsStream(RES_PTK20_XSD);
	}

	/**
	 * Load Version Number from Package.
	 * @return Version Number as String
	 */
	private static String loadLibraryVersion() {

		String result = null;

		// load Version
		Properties props = new Properties();

		try {
			props.load(XJdfConstants.class.getResourceAsStream(RES_BUILD_PROPS));
			result = props.getProperty("version", "UNKNOWN");

		} catch (IOException e) {
		}

		// default
		if (result == null) {
			// result = "[version not specified]";
			result = "";
		}

		// return result
		return result;
	}

	/**
	 * Load Build Date from Package.
	 * @return Version Number as String
	 */
	private static String loadLibraryBuildDate() {

		String result = null;

		// load Version
		Properties props = new Properties();

		try {
			props.load(XJdfConstants.class.getResourceAsStream(RES_BUILD_PROPS));
			result = props.getProperty("build.date", "UNKNOWN");

		} catch (IOException e) {
		}

		// default
		if (result == null) {
			result = "";
		}

		// return result
		return result;
	}
}
