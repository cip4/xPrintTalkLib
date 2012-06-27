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

import org.cip4.lib.xjdf.builder.AbstractNodeBuilder;
import org.cip4.lib.xprinttalk.PrintTalkNodeFactory;
import org.cip4.lib.xprinttalk.schema.jdf.Price;
import org.cip4.lib.xprinttalk.schema.jdf.Pricing;

/**
 * Implementation of a Pricing builder class.
 * @author s.meissner
 * @date 25.06.2012
 */
public class PricingBuilder extends AbstractNodeBuilder<Pricing> {

	private final PrintTalkNodeFactory ptkNodeFactory;

	/**
	 * Private default constructor. Class cannot being instantiated from external.
	 */
	private PricingBuilder() {

		super(PrintTalkNodeFactory.newInstance().createPricing());

		// initialize instance parameters
		ptkNodeFactory = PrintTalkNodeFactory.newInstance();
	}

	/**
	 * Create and return a new instance of PrintTalkBuilder.
	 * @return New PrintTalkBuilder instance.
	 */
	public static PricingBuilder newInstance() {

		// return new instance
		return new PricingBuilder();
	}

	/**
	 * Getter for PrintTalk attribute.
	 * @return the PrintTalk
	 */
	public Pricing getPricing() {
		return getNode();
	}

	/**
	 * Create a new Price object and append to Pricing node.
	 * @param descriptiveName Attribute DescriptiveName of Price Node.
	 * @param lineID Attribute LineID of Price Node.
	 * @param price Attribute Price of Price Node.
	 * @return Price object which also is append to Pricing Node.
	 */
	public Price appendPrice(String descriptiveName, String lineID, double price) {

		// chained method
		return appendPrice(descriptiveName, lineID, price, null);
	}

	/**
	 * Create a new Price object and append to Pricing node.
	 * @param descriptiveName Attribute DescriptiveName of Price Node.
	 * @param lineID Attribute LineID of Price Node.
	 * @param price Attribute Price of Price Node.
	 * @param lineIDRefs Attribute LineIDRefs of Price Node.
	 * @return Price object which also is append to Pricing Node.
	 */
	public Price appendPrice(String descriptiveName, String lineID, double price, String lineIDRefs) {

		// create Price object
		Price obj = ptkNodeFactory.createPrice();

		// set attributes
		obj.setDescriptiveName(descriptiveName);
		obj.setLineID(lineID);
		obj.setPrice(price);
		obj.setLineID(lineIDRefs);

		// append to pricing
		getNode().getPrices().add(obj);

		// return price object
		return obj;
	}
}
