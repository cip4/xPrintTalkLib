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
package org.cip4.lib.xprinttalk;

import org.cip4.lib.xjdf.schema.XJDF;
import org.cip4.lib.xprinttalk.schema.Additional;
import org.cip4.lib.xprinttalk.schema.ObjectFactory;
import org.cip4.lib.xprinttalk.schema.OrderStatusResponse;
import org.cip4.lib.xprinttalk.schema.Pricing;
import org.cip4.lib.xprinttalk.schema.PurchaseOrder;

/**
 * Static Factory Class which is managing the creation of PrintTalkNodes.
 * @author s.meissner
 * @date 22.06.2012
 */
public class PrintTalkNodeFactory extends ObjectFactory {

	/**
	 * Default constructor.
	 */
	public PrintTalkNodeFactory() {
		// no action
	}

	/**
	 * Create a new OrderStatusResponse Node which already contains the attribute BusinessID.
	 * @param BusinessID Value of BusinessID attribute.
	 * @return OrderStatusResponse Node which already contains the attribute BusinessID.
	 */
	public OrderStatusResponse createOrderStatusResponse(String businessID) {

		// create OrderStatusResponse Node
		OrderStatusResponse orderStatusResponse = super.createOrderStatusResponse();

		// set attributes
		orderStatusResponse.setBusinessID(businessID);

		// return OrderStatusResponse
		return orderStatusResponse;
	}

	/**
	 * Create a new PurchaseOrder Node which already contains the attributes BusinessID, Currency and BusinessRefID.
	 * @param BusinessID Value of BusinessID attribute.
	 * @param Currency Value of Currency attribute.
	 * @return PurchaseOrder Node which already contains the attributes BusinessID, Currency and BusinessRefID.
	 */
	public PurchaseOrder createPurchaseOrder(String businessID, String currency) {

		// return PurchaseOrder
		return createPurchaseOrder(businessID, currency, null, null, null);
	}

	/**
	 * Create a new PurchaseOrder Node which already contains the attributes BusinessID, Currency and XJDF.
	 * @param BusinessID Value of BusinessID attribute.
	 * @param Currency Value of Currency attribute.
	 * @param XJDF XJDF Document.
	 * @return PurchaseOrder Node which already contains the attributes BusinessID, Currency and BusinessRefID.
	 */
	public PurchaseOrder createPurchaseOrder(String businessID, String currency, XJDF xjdf) {

		// return PurchaseOrder
		return createPurchaseOrder(businessID, currency, xjdf, null, null);
	}

	/**
	 * Create a new PurchaseOrder Node which already contains the attributes BusinessID, Currency and XJDF.
	 * @param BusinessID Value of BusinessID attribute.
	 * @param Currency Value of Currency attribute.
	 * @param XJDF XJDF Document.
	 * @Param pricing Pricing Node
	 * @return PurchaseOrder Node which already contains the attributes BusinessID, Currency and BusinessRefID.
	 */
	public PurchaseOrder createPurchaseOrder(String businessID, String currency, XJDF xjdf, Pricing pricing) {

		// return PurchaseOrder
		return createPurchaseOrder(businessID, currency, xjdf, null, pricing);
	}

	/**
	 * Create a new PurchaseOrder Node which already contains the attributes BusinessID, Currency and XJDF.
	 * @param BusinessID Value of BusinessID attribute.
	 * @param Currency Value of Currency attribute.
	 * @param BueinssRefID Value of BusinessRefID attribute.
	 * @return PurchaseOrder Node which already contains the attributes BusinessID, Currency and BusinessRefID.
	 */
	public PurchaseOrder createPurchaseOrder(String businessID, String currency, String businessRefID) {

		// return PurchaseOrder
		return createPurchaseOrder(businessID, currency, null, null, null);
	}

	/**
	 * Create a new PurchaseOrder Node which already contains the attributes BusinessID, Currency, XJDF and BusinessRefID.
	 * @param BusinessID Value of BusinessID attribute.
	 * @param Currency Value of Currency attribute.
	 * @param XJDF XJDF Document.
	 * @param BueinssRefID Value of BusinessRefID attribute.
	 * @param Pricing Pricing Node.
	 * @return PurchaseOrder Node which already contains the attributes BusinessID, Currency, XJDF and BusinessRefID.
	 */
	public PurchaseOrder createPurchaseOrder(String businessID, String currency, XJDF xjdf, String businessRefID, Pricing pricing) {
		// create PurchaseOrder Node
		PurchaseOrder purchaseOrder = super.createPurchaseOrder();

		// set attriubtes
		purchaseOrder.setBusinessID(businessID);
		purchaseOrder.setCurrency(currency);
		purchaseOrder.setXJDF(xjdf);
		purchaseOrder.setBusinessRefID(businessRefID);
		purchaseOrder.setPricing(pricing);

		// return PurchaseOrder
		return purchaseOrder;
	}

	/**
	 * Create a new Additional Node which already contains the attributes Price and Amount.
	 * @param price Value of Price attribute.
	 * @param amount Value of amount attribute.
	 * @return Additional Node which already contains the attributes Price and Amount.
	 */
	public Additional createAdditional(double price, int amount) {

		// create additional node
		Additional additional = super.createAdditional();

		// set attributes
		additional.setPrice(price);
		additional.setAmount(amount);

		// return Additional
		return additional;
	}

}
