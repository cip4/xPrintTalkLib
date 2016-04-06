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

import org.cip4.lib.xjdf.XJdfNodeFactory;
import org.cip4.lib.xjdf.builder.ProductBuilder;
import org.cip4.lib.xjdf.builder.XJdfBuilder;
import org.cip4.lib.xjdf.schema.XJDF;
import org.cip4.lib.xjdf.type.URI;
import org.cip4.lib.xprinttalk.PrintTalkNodeFactory;
import org.cip4.lib.xprinttalk.schema.PrintTalk;
import org.cip4.lib.xprinttalk.schema.PurchaseOrder;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PricingBuilderTest extends AbstractBuilderTest<PrintTalk> {

    private PricingBuilder pricingBuilder;

    /**
     * Setup unit test.
     *
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception {
        pricingBuilder = new PricingBuilder();
    }

    /**
     * Tear down unit test.
     *
     * @throws java.lang.Exception
     */
    @After
    public void tearDown() throws Exception {
        pricingBuilder = null;
    }

    @Test
    public void testPricingIntegration() throws Exception {

        // arrange
        XJdfNodeFactory nf = new XJdfNodeFactory();

        ProductBuilder productBuilder = new ProductBuilder(1000);
        productBuilder.addIntent(nf.createLayoutIntent(22));

        XJdfBuilder xJdfBuilder = new XJdfBuilder("Job387943", "Web2Print", "MyProduct");
        xJdfBuilder.addGeneralID(nf.createGeneralID("CatalogID", "ID_Whatever"));
        xJdfBuilder.addParameter(
            nf.createRunList(
                new URI(
                    new java.net.URI(
                        "http://www.hei-cloud.com/w2pvalidate/examples/w2p%20interface.pdf"
                    )
                )
            )
        );
        xJdfBuilder.addProduct(productBuilder.build());
        XJDF xjdf = xJdfBuilder.build();

        // act
        pricingBuilder.appendPrice(xjdf, 25.33);
        pricingBuilder.appendPrice("Shipping", 3.50);
        pricingBuilder.appendTotalPrice();

        // assert
        byte[] bytes = marshalPricing(pricingBuilder, xjdf);

        String actualIdValueLineID = getXPathValue(
            bytes,
            "/ptk:PrintTalk/ptk:Request/ptk:PurchaseOrder/xjdf:XJDF/xjdf:GeneralID[@IDUsage='Line_ID']/@IDValue"
        );
        Assert.assertEquals("LineID is wrong.", "Line_1", actualIdValueLineID);

        String actualDescName = getXPathValue(
            bytes,
            "/ptk:PrintTalk/ptk:Request/ptk:PurchaseOrder/ptk:Pricing/ptk:Price[@LineID='Line_1']/@DescriptiveName"
        );
        Assert.assertEquals("DescriptiveName is wrong.", "MyProduct", actualDescName);

        String actualTotal = getXPathValue(
            bytes,
            "/ptk:PrintTalk/ptk:Request/ptk:PurchaseOrder/ptk:Pricing/ptk:Price[@LineID='Line_3']/@Price"
        );
        Assert.assertEquals("Price is wrong.", "28.83", actualTotal);
    }

    @Test
    public void testPricingTaxIntegration() throws Exception {

        // arrange
        XJdfNodeFactory nf = new XJdfNodeFactory();

        ProductBuilder productBuilder = new ProductBuilder(1000);
        productBuilder.addIntent(nf.createLayoutIntent(22));

        XJdfBuilder xJdfBuilder = new XJdfBuilder("Job387943", "Web2Print", "MyProduct");
        xJdfBuilder.addGeneralID(nf.createGeneralID("CatalogID", "ID_Whatever"));
        xJdfBuilder.addParameter(
            nf.createRunList(
                new URI(
                    new java.net.URI(
                        "http://www.hei-cloud.com/w2pvalidate/examples/w2p%20interface.pdf"
                    )
                )
            )
        );
        xJdfBuilder.addProduct(productBuilder.build());
        XJDF xjdf = xJdfBuilder.build();

        // act
        pricingBuilder.appendPrice(xjdf, 25.33);
        pricingBuilder.appendPrice("Shipping", 3.50);
        pricingBuilder.appendTotalPriceWithTax(19.5);

        // assert
        byte[] bytes = marshalPricing(pricingBuilder, xjdf);

        String actualIdValueLineID = getXPathValue(
            bytes,
            "/ptk:PrintTalk/ptk:Request/ptk:PurchaseOrder/xjdf:XJDF/xjdf:GeneralID[@IDUsage='Line_ID']/@IDValue"
        );
        Assert.assertEquals("LineID is wrong.", "Line_1", actualIdValueLineID);

        String actualDescName = getXPathValue(
            bytes,
            "/ptk:PrintTalk/ptk:Request/ptk:PurchaseOrder/ptk:Pricing/ptk:Price[@LineID='Line_1']/@DescriptiveName"
        );
        Assert.assertEquals("DescriptiveName is wrong.", "MyProduct", actualDescName);

        String actualTotal = getXPathValue(
            bytes,
            "/ptk:PrintTalk/ptk:Request/ptk:PurchaseOrder/ptk:Pricing/ptk:Price[@LineID='Line_3']/@Price"
        );
        Assert.assertEquals("Price is wrong.", "5.62", actualTotal);
    }

    /**
     * Helper method for marshalling Pricing.
     *
     * @throws Exception
     */
    private byte[] marshalPricing(PricingBuilder pricingBuilder, XJDF xjdf) throws Exception {

        PrintTalkNodeFactory ptkNf = new PrintTalkNodeFactory();
        PrintTalkBuilder ptkBuilder = new PrintTalkBuilder();

        // create purchase order object
        PurchaseOrder purchaseOrder = ptkNf.createPurchaseOrder("businessID", "EUR");
        purchaseOrder.setPricing(pricingBuilder.build());
        purchaseOrder.setXJDF(xjdf);
        ptkBuilder.addRequest(purchaseOrder);

        // marshal
        return marsahlResult(ptkBuilder);
    }

}
