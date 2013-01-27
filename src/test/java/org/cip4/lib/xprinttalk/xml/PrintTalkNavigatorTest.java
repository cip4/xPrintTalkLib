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

import java.io.InputStream;

import junit.framework.Assert;

import org.cip4.lib.xjdf.xml.XJdfNavigator;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * JUnit test case for PrintTalkNavigator
 * @author s.meissner
 * @date 03.07.2012
 */
public class PrintTalkNavigatorTest {

	private final String RES_TEST_PTK = "/org/cip4/lib/xprinttalk/simple_job.ptk";

	private PrintTalkNavigator printTalkNavigator;

	/**
	 * Setup unit test.
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {

		InputStream is = PrintTalkNavigatorTest.class.getResourceAsStream(RES_TEST_PTK);
		printTalkNavigator = new PrintTalkNavigator(is);
	}

	/**
	 * Tear down unit test.
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {

		printTalkNavigator = null;
	}

	@Test
	public void testXPathExpressionsPrintTalk() throws Exception {

		// arrange
		String actual;

		// act / assert
		actual = printTalkNavigator.readAttribute(PrintTalkNavigator.TIMESTAMP);
		Assert.assertEquals("Value 'Timestamp' is wrong.", "2012-06-22T11:09:45+01:00", actual);

		actual = printTalkNavigator.readAttribute(PrintTalkNavigator.BUSINESS_ID);
		Assert.assertEquals("Value 'BusinessID' is wrong.", "PT_12345", actual);

		actual = printTalkNavigator.readAttribute(PrintTalkNavigator.CURRENCY);
		Assert.assertEquals("Value 'Currency' is wrong.", "EUR", actual);
	}

	@Test
	public void testXPathExpressionsXJDF() throws Exception {

		// arrange
		String actual;

		// act / assert
		actual = printTalkNavigator.readXJdfAttribute(XJdfNavigator.GENERAL_CATALOG_ID);
		Assert.assertEquals("Value 'CatalogID' is wrong.", "42", actual);

		actual = printTalkNavigator.readXJdfAttribute(XJdfNavigator.AMOUNT);
		Assert.assertEquals("Value 'Amount' is wrong.", "1500", actual);
	}

}
