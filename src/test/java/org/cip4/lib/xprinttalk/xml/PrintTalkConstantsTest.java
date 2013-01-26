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

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import junit.framework.Assert;

import org.apache.commons.io.IOUtils;
import org.junit.Test;

/**
 * JUnit Test Case for PrintTalkConstants
 * @author s.meissner
 * @date 22.06.2012
 */
public class PrintTalkConstantsTest {

	private static final String RES_PTK20_XSD = "/org/cip4/lib/xprinttalk/xsd/PrintTalk20.xsd";

	/**
	 * JUnit test
	 * @throws IOException
	 */
	@Test
	public void testNamespaceJdf20() throws IOException {

		// arrange
		InputStream is = PrintTalkConstantsTest.class.getResourceAsStream(RES_PTK20_XSD);

		ByteArrayOutputStream os = new ByteArrayOutputStream();
		IOUtils.copy(is, os);
		String doc = new String(os.toByteArray());

		int i = doc.indexOf("xmlns:ptk=\"") + 11;
		int n = doc.indexOf("\"", i);

		String expectedNs = doc.substring(i, n);

		// act
		String actualNs = PrintTalkConstants.NAMESPACE_PTK20;

		// assert
		Assert.assertEquals("Namespace PTK20 is wrong.", expectedNs, actualNs);
	}

	/**
	 * JUnit test
	 * @throws IOException
	 */
	@Test
	public void testLoadLibraryVersion() throws IOException {

		// arrange

		// act
		String val = PrintTalkConstants.PTK_LIB_VERSION;

		// assert
		// Assert.assertEquals("PTK library version is wrong.", "", val);
	}
}
