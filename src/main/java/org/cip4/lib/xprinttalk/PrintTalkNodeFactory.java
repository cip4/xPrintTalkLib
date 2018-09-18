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
	 * @param businessID Value of BusinessID attribute.
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
	 * @param businessID Value of BusinessID attribute.
	 * @param currency Value of Currency attribute.
	 * @return PurchaseOrder Node which already contains the attributes BusinessID, Currency and BusinessRefID.
	 */
	public PurchaseOrder createPurchaseOrder(String businessID, String currency) {

		// return PurchaseOrder
		return createPurchaseOrder(businessID, currency, null, null, null);
	}

	/**
	 * Create a new PurchaseOrder Node which already contains the attributes BusinessID, Currency and XJDF.
	 * @param businessID Value of BusinessID attribute.
	 * @param currency Value of Currency attribute.
	 * @param xjdf XJDF Document.
	 * @return PurchaseOrder Node which already contains the attributes BusinessID, Currency and BusinessRefID.
	 */
	public PurchaseOrder createPurchaseOrder(String businessID, String currency, XJDF xjdf) {

		// return PurchaseOrder
		return createPurchaseOrder(businessID, currency, xjdf, null, null);
	}

	/**
	 * Create a new PurchaseOrder Node which already contains the attributes BusinessID, Currency and XJDF.
	 * @param businessID Value of BusinessID attribute.
	 * @param currency Value of Currency attribute.
	 * @param xjdf XJDF Document.
	 * @param pricing Pricing Node
	 * @return PurchaseOrder Node which already contains the attributes BusinessID, Currency and BusinessRefID.
	 */
	public PurchaseOrder createPurchaseOrder(String businessID, String currency, XJDF xjdf, Pricing pricing) {

		// return PurchaseOrder
		return createPurchaseOrder(businessID, currency, xjdf, null, pricing);
	}

	/**
	 * Create a new PurchaseOrder Node which already contains the attributes BusinessID, Currency and XJDF.
	 * @param businessID Value of BusinessID attribute.
	 * @param currency Value of Currency attribute.
	 * @param businessRefID Value of BusinessRefID attribute.
	 * @return PurchaseOrder Node which already contains the attributes BusinessID, Currency and BusinessRefID.
	 */
	public PurchaseOrder createPurchaseOrder(String businessID, String currency, String businessRefID) {

		// return PurchaseOrder
		return createPurchaseOrder(businessID, currency, null, null, null);
	}

	/**
	 * Create a new PurchaseOrder Node which already contains the attributes BusinessID, Currency, XJDF and BusinessRefID.
	 * @param businessID Value of BusinessID attribute.
	 * @param currency Value of Currency attribute.
	 * @param xjdf XJDF Document.
	 * @param businessRefID Value of BusinessRefID attribute.
	 * @param pricing Pricing Node.
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
