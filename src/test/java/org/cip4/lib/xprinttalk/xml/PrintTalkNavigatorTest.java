package org.cip4.lib.xprinttalk.xml;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;

import org.apache.commons.io.IOUtils;
import org.cip4.lib.xjdf.schema.ProductList;
import org.cip4.lib.xjdf.xml.XJdfConstants;
import org.cip4.lib.xjdf.xml.XJdfNavigator;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * JUnit test case for PrintTalkNavigator
 * @author s.meissner
 * @date 03.07.2012
 */
public class PrintTalkNavigatorTest {

	private final String RES_TEST_PTK = "/org/cip4/lib/xprinttalk/simple_job.ptk";

	private final String RES_TEST_SAMPLE = "/org/cip4/lib/xprinttalk/sample.ptk";

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
        try (final InputStream is = PrintTalkNavigatorTest.class.getResourceAsStream(RES_TEST_PTK)) {
            PrintTalkNavigator printTalkNavigator = new PrintTalkNavigator(is, true);
            // arrange
            String actual;

            // act / assert
            actual = printTalkNavigator.readAttribute("//xjdf:XJDF/xjdf:GeneralID[@IDUsage='CatalogID']/@IDValue");
            Assert.assertEquals("Value 'CatalogID' is wrong.", "42", actual);

            actual = printTalkNavigator.readAttribute("//xjdf:XJDF/xjdf:ProductList/xjdf:Product/@Amount");
            Assert.assertEquals("Value 'Amount' is wrong.", "1500", actual);

        }
	}

	@Test
	public void testPrintTalkNodeModification() throws Exception {

		// arrange
		File testBefore = new File(PrintTalkNavigatorTest.class.getResource(RES_TEST_SAMPLE).toURI());
		File fileAfter = File.createTempFile("cip4-test", ".ptk");
		fileAfter.deleteOnExit();

		PrintTalkNavigator ptkNavigator = new PrintTalkNavigator(new FileInputStream(testBefore), true);

		// act
		ProductList productList = (ProductList) ptkNavigator.extractNode("//xjdf:XJDF/xjdf:ProductList");
		productList.getProduct().remove(0);
		ptkNavigator.replaceNode("//xjdf:XJDF/xjdf:ProductList", productList);

		FileOutputStream fos = new FileOutputStream(fileAfter);
		IOUtils.write(ptkNavigator.getXmlBytes(), fos);
		fos.close();

		// assert
		PrintTalkNavigator navBefore = new PrintTalkNavigator(testBefore);
		int cntItemsBefore = navBefore.evaluateInt("count(//XJDF/ProductList/Product)");

		PrintTalkNavigator navAfter = new PrintTalkNavigator(fileAfter);
		int cntItemsAfter = navAfter.evaluateInt("count(//XJDF/ProductList/Product)");

		Assert.assertEquals("Number of Intents before is wrong.", 2, cntItemsBefore);
		Assert.assertEquals("Number of Intents after is wrong.", 1, cntItemsAfter);
	}

	@Test
	public void testPrintTalkNodeRemoval() throws Exception {

		// arrange
		File testBefore = new File(PrintTalkNavigatorTest.class.getResource(RES_TEST_SAMPLE).toURI());
		File fileAfter = File.createTempFile("cip4-test", ".ptk");
		fileAfter.deleteOnExit();

		PrintTalkNavigator ptkNavigator = new PrintTalkNavigator(new FileInputStream(testBefore), false);

		// act
		ptkNavigator.removeNode("//XJDF/ProductList/Product[1]");

		FileOutputStream fos = new FileOutputStream(fileAfter);
		IOUtils.write(ptkNavigator.getXmlBytes(), fos);
		fos.close();

		// assert
		PrintTalkNavigator navBefore = new PrintTalkNavigator(testBefore);
		int cntItemsBefore = navBefore.evaluateInt("count(//XJDF/ProductList/Product)");

		PrintTalkNavigator navAfter = new PrintTalkNavigator(fileAfter);
		int cntItemsAfter = navAfter.evaluateInt("count(//XJDF/ProductList/Product)");

		Assert.assertEquals("Number of Intents before is wrong.", 2, cntItemsBefore);
		Assert.assertEquals("Number of Intents after is wrong.", 1, cntItemsAfter);
	}

}
