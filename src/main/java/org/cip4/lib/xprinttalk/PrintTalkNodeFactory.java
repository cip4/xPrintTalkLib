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

import org.cip4.lib.xprinttalk.schema.jdf.ObjectFactory;
import org.cip4.lib.xprinttalk.schema.jdf.PurchaseOrder;

/**
 * Static Factory Class which is managing the creation of PrintTalkNodes.
 * @author s.meissner
 * @date 22.06.2012
 */
public class PrintTalkNodeFactory extends ObjectFactory {

	/**
	 * Private default constructor. Class cannot being instantiated from external.
	 */
	private PrintTalkNodeFactory() {
		// no action
	}

	/**
	 * Get instance of PrintTalkNodeFactory.
	 * @return New insatnce of PrintTalkNodeFactory
	 */
	public static PrintTalkNodeFactory newInstance() {
		return new PrintTalkNodeFactory();
	}

	/**
	 * Create a new PurchaseOrder Node which already contains the attributes BusinessID, Currency and BusinessRefID.
	 * @param BusinessID Value of BusinessID attribute.
	 * @param Currency Value of Currency attribute.
	 * @return PurchaseOrder Node which already contains the attributes BusinessID, Currency and BusinessRefID.
	 */
	public PurchaseOrder createPurchaseOrder(String businessID, String currency) {

		// return runList
		return createPurchaseOrder(businessID, currency, null);
	}

	/**
	 * Create a new PurchaseOrder Node which already contains the attributes BusinessID, Currency and BusinessRefID.
	 * @param BusinessID Value of BusinessID attribute.
	 * @param Currency Value of Currency attribute.
	 * @param BueinssRefID Valoue of BusinessRefID attribute.
	 * @return PurchaseOrder Node which already contains the attributes BusinessID, Currency and BusinessRefID.
	 */
	public PurchaseOrder createPurchaseOrder(String businessID, String currency, String businessRefID) {
		// create PurchaseOrder Node
		PurchaseOrder purchaseOrder = super.createPurchaseOrder();

		// set attriubtes
		purchaseOrder.setBusinessID(businessID);
		purchaseOrder.setCurrency(currency);
		purchaseOrder.setBusinessRefID(businessRefID);

		// return PurchaseOrder
		return purchaseOrder;
	}

}
