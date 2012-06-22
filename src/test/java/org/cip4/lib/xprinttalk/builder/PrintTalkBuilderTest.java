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
package org.cip4.lib.xprinttalk.builder;

import org.apache.commons.lang.StringUtils;
import org.cip4.lib.xjdf.XJdfNodeFactory;
import org.cip4.lib.xjdf.builder.ProductBuilder;
import org.cip4.lib.xjdf.builder.XJdfBuilder;
import org.cip4.lib.xjdf.schema.jdf.GeneralID;
import org.cip4.lib.xjdf.schema.jdf.RunList;
import org.cip4.lib.xprinttalk.PrintTalkNodeFactory;
import org.cip4.lib.xprinttalk.schema.jdf.PrintTalk;
import org.cip4.lib.xprinttalk.schema.jdf.PurchaseOrder;
import org.cip4.lib.xprinttalk.xml.PrintTalkConstants;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * JUnit Test Case for PrintTalkBuilder
 * @author s.meissner
 * @date 22.06.2012
 */
public class PrintTalkBuilderTest extends AbstractBuilderTest<PrintTalk> {

	private PrintTalkBuilder printTalkBuilder;

	/**
	 * Setup unit test.
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		printTalkBuilder = PrintTalkBuilder.newInstance();
	}

	/**
	 * Tear down unit test.
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		printTalkBuilder = null;
	}

	/**
	 * Integration Test
	 */
	@Test
	public void testNewInstancePayload() throws Exception {

		// arrange
		final String PAYLOAD_ID = "PL_200";

		// act
		PrintTalkBuilder builder = PrintTalkBuilder.newInstance(PAYLOAD_ID);

		// assert
		byte[] bytes = marsahlResult(builder);

		String actualPayloadID = getXPathValue(bytes, "/ptk:PrintTalk/@payloadID");
		Assert.assertEquals("PayloadID is wrong.", PAYLOAD_ID, actualPayloadID);

		String actualVersion = getXPathValue(bytes, "/ptk:PrintTalk/@version");
		Assert.assertEquals("Version is wrong.", PrintTalkConstants.PTK_CURRENT_VERSION, actualVersion);

		String actualTimestamp = getXPathValue(bytes, "/ptk:PrintTalk/@Timestamp");
		Assert.assertFalse("Timestamp is empty.", StringUtils.isEmpty(actualVersion));
	}

	/**
	 * Integration Test
	 */
	@Test
	public void testIntegrationDocumentCreation() throws Exception {

		// arrange
		final String PAYLOAD_ID = "PL_200";
		final String BUSINESS_ID = "BS_12345";
		final String JOB_ID = "JB_1234";
		final String AMOUNT = "1500";

		PrintTalkNodeFactory ptkNodeFactory = PrintTalkNodeFactory.newInstance();
		XJdfNodeFactory xJdfNodeFactory = XJdfNodeFactory.newInstance();

		// act
		PrintTalkBuilder builder = PrintTalkBuilder.newInstance(PAYLOAD_ID);

		PurchaseOrder purchaseOrder = ptkNodeFactory.createPurchaseOrder(BUSINESS_ID, "EUR");
		builder.addRequest(purchaseOrder);

		XJdfBuilder xJdfBuilder = XJdfBuilder.newInstance(JOB_ID);

		GeneralID generalId = xJdfNodeFactory.createGeneralID("CatalogID", "49");
		xJdfBuilder.addGeneralID(generalId);

		ProductBuilder productBuilder = ProductBuilder.newInstance(Integer.valueOf(AMOUNT).intValue());
		xJdfBuilder.addProduct(productBuilder.build());

		RunList runList = xJdfNodeFactory.createRunList("http://www.example.org:8080/artwork.pdf");
		xJdfBuilder.addParameter(runList);

		purchaseOrder.setXJDF(xJdfBuilder.build());

		// assert
		byte[] bytes = marsahlResult(builder);

		String actualPayloadID = getXPathValue(bytes, "/ptk:PrintTalk/@payloadID");
		Assert.assertEquals("PayloadID is wrong.", PAYLOAD_ID, actualPayloadID);

		String actualBusinessID = getXPathValue(bytes, "/ptk:PrintTalk/ptk:Request/ptk:PurchaseOrder/@BusinessID");
		Assert.assertEquals("BusinessID is wrong.", BUSINESS_ID, actualBusinessID);

		String actualJobID = getXPathValue(bytes, "/ptk:PrintTalk/ptk:Request/ptk:PurchaseOrder/xjdf:XJDF/@JobID");
		Assert.assertEquals("JobID is wrong.", JOB_ID, actualJobID);

		String actualAmount = getXPathValue(bytes, "/ptk:PrintTalk/ptk:Request/ptk:PurchaseOrder/xjdf:XJDF/xjdf:ProductList/xjdf:Product/@Amount");
		Assert.assertEquals("Amount is wrong.", AMOUNT, actualAmount);

	}
}
