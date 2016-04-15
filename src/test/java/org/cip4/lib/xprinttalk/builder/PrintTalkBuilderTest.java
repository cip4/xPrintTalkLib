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

import org.apache.commons.lang3.StringUtils;
import org.cip4.lib.xjdf.XJdfNodeFactory;
import org.cip4.lib.xjdf.builder.ProductBuilder;
import org.cip4.lib.xjdf.builder.XJdfBuilder;
import org.cip4.lib.xjdf.schema.GeneralID;
import org.cip4.lib.xjdf.schema.RunList;
import org.cip4.lib.xjdf.type.URI;
import org.cip4.lib.xprinttalk.PrintTalkNodeFactory;
import org.cip4.lib.xprinttalk.schema.PrintTalk;
import org.cip4.lib.xprinttalk.schema.PurchaseOrder;
import org.cip4.lib.xprinttalk.xml.PrintTalkConstants;
import org.junit.Assert;
import org.junit.Test;

public class PrintTalkBuilderTest extends AbstractBuilderTest<PrintTalk> {

    /**
     * Integration Test
     */
    @Test
    public void testNewInstancePayload() throws Exception {

        // arrange
        final String PAYLOAD_ID = "PL_200";

        // act
        PrintTalkBuilder builder = new PrintTalkBuilder(PAYLOAD_ID);

        // assert
        byte[] bytes = marsahlResult(builder);

        String actualPayloadID = getXPathValue(bytes, "/ptk:PrintTalk/@payloadID");
        Assert.assertEquals("PayloadID is wrong.", PAYLOAD_ID, actualPayloadID);

        String actualVersion = getXPathValue(bytes, "/ptk:PrintTalk/@version");
        Assert.assertEquals("Version is wrong.", PrintTalkConstants.PTK_CURRENT_VERSION, actualVersion);

        String actualTimestamp = getXPathValue(bytes, "/ptk:PrintTalk/@Timestamp");
        Assert.assertFalse("Timestamp is empty.", StringUtils.isEmpty(actualTimestamp));
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

        PrintTalkNodeFactory ptkNodeFactory = new PrintTalkNodeFactory();
        XJdfNodeFactory xJdfNodeFactory = new XJdfNodeFactory();

        // act
        PrintTalkBuilder builder = new PrintTalkBuilder(PAYLOAD_ID);

        PurchaseOrder purchaseOrder = ptkNodeFactory.createPurchaseOrder(BUSINESS_ID, "EUR");
        builder.addRequest(purchaseOrder);

        XJdfBuilder xJdfBuilder = new XJdfBuilder(JOB_ID);

        GeneralID generalId = xJdfNodeFactory.createGeneralID("CatalogID", "49");
        xJdfBuilder.addGeneralID(generalId);

        ProductBuilder productBuilder = new ProductBuilder(Integer.valueOf(AMOUNT));
        xJdfBuilder.addProduct(productBuilder.build());

        RunList runList = xJdfNodeFactory.createRunList(
            new URI(
                new java.net.URI("http://www.example.org:8080/artwork.pdf")
            )
        );
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

        String actualAmount = getXPathValue(
            bytes,
            "/ptk:PrintTalk/ptk:Request/ptk:PurchaseOrder/xjdf:XJDF/xjdf:ProductList/xjdf:Product/@Amount"
        );
        Assert.assertEquals("Amount is wrong.", AMOUNT, actualAmount);

    }
}
