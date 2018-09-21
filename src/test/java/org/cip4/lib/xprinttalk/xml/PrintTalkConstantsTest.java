package org.cip4.lib.xprinttalk.xml;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.IOUtils;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * JUnit Test Case for PrintTalkConstants
 * @author s.meissner
 * @date 22.06.2012
 */
public class PrintTalkConstantsTest {

	private static final String RES_PTK20_XSD = "/PrintTalk20.xsd";

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
		assertEquals("Namespace PTK20 is wrong.", expectedNs, actualNs);
	}

	@Test
	public void testGradleBuildReplacedBuildProperties() throws IOException {
		String val = PrintTalkConstants.PTK_LIB_VERSION;

		assertNotEquals("${pom.version}", val);
	}
}
