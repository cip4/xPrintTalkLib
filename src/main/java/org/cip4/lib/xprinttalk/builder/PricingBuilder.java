package org.cip4.lib.xprinttalk.builder;

import org.cip4.lib.xjdf.XJdfNodeFactory;
import org.cip4.lib.xjdf.builder.AbstractNodeBuilder;
import org.cip4.lib.xjdf.schema.GeneralID;
import org.cip4.lib.xjdf.schema.XJDF;
import org.cip4.lib.xprinttalk.PrintTalkNodeFactory;
import org.cip4.lib.xprinttalk.schema.Price;
import org.cip4.lib.xprinttalk.schema.Pricing;

/**
 * Implementation of a Pricing builder class.
 * @author s.meissner
 */
public class PricingBuilder extends AbstractNodeBuilder<Pricing> {

	private final PrintTalkNodeFactory ptkNodeFactory;

	private final XJdfNodeFactory xjdfNodeFactory;

	private int lineCounter = 0;

	/**
	 * Default constructor.
	 */
	public PricingBuilder() {

		super(new PrintTalkNodeFactory().createPricing());

		// initialize instance parameters
		ptkNodeFactory = new PrintTalkNodeFactory();
		xjdfNodeFactory = new XJdfNodeFactory();
	}

	/**
	 * Create a new Price node and append to Pricing node and references the XJDF.
	 * @param xjdf The XJDF Document which belongs to this price.
	 * @param price Attribute Price of Price Node.
	 * @return Price node which is append to Pricing Node and references the XJDF.
	 */
	public Price appendPrice(XJDF xjdf, double price) {

		return appendPrice(xjdf, price, xjdf.getDescriptiveName());
	}

	/**
	 * Create a new Price object and append to Pricing node.
	 * @param descriptiveName Attribute DescriptiveName of Price Node.
	 * @param price Attribute Price of Price Node.
	 * @return Price object which also is append to Pricing Node.
	 */
	public Price appendPrice(String descriptiveName, double price) {

		return appendPrice(null, price, descriptiveName);
	}

	/**
	 * Create a new Price node and append to Pricing node and references the XJDF.
	 * @param xjdf The XJDF Document which belongs to this price.
	 * @param descriptiveName Attribute DescriptiveName of Price Node.
	 * @param price Attribute Price of Price Node.
	 * @return Price node which is append to Pricing Node and references the XJDF.
	 */
	public Price appendPrice(XJDF xjdf, double price, String descriptiveName) {

		String lineId = getNextLineId();

		// create price node
		Price obj = ptkNodeFactory.createPrice();
		obj.setDescriptiveName(descriptiveName);
		obj.setLineID(lineId);
		obj.setPrice(price);
		getNode().getPrice().add(obj);

		// add GeneralID to XJDF
		if (xjdf != null) {
			GeneralID generalID = xjdfNodeFactory.createGeneralID("Line_ID", lineId);
			xjdf.getGeneralID().add(generalID);
		}

		// chained method
		return obj;
	}

	/**
	 * This method automatically creates a tex item and generate the total over all Price Items.
	 * @param tax Tax in percent as double.
	 */
	public void appendTotalPriceWithTax(double tax) {

		// create price node
		Price obj = ptkNodeFactory.createPrice();

		// iterate over all price itmes
		double total = 0;

		for (Price price : getNode().getPrice()) {
			// create total
			total += price.getPrice().doubleValue();
		}

		// add tax
		obj.setDescriptiveName(String.format("Tax %s %%", Double.valueOf(tax)));
		obj.setPrice(Math.round(total * tax) / 100d);
		obj.setLineID(getNextLineId());
		getNode().getPrice().add(obj);

		// append total price
		appendTotalPrice();
	}

	/**
	 * This method automatically creates a total over all Price Items.
	 */
	public Price appendTotalPrice() {

		// create price node
		Price obj = ptkNodeFactory.createPrice();

		// iterate over all price itmes
		double total = 0;

		for (Price price : getNode().getPrice()) {
			// create total
			total += price.getPrice().doubleValue() * 100;

			// add lineIDRefs
			obj.getLineIDRefs().add(price.getLineID());
		}

		// set further price attributes
		obj.setDescriptiveName("Total");
		obj.setPrice(Math.round(total) / 100d);
		obj.setLineID(getNextLineId());
		getNode().getPrice().add(obj);

		// return node
		return obj;
	}

	/**
	 * Returns the next lineId
	 * @return Next lineId
	 */
	private String getNextLineId() {

		// increment lineCounter
		lineCounter++;

		// get next line id

		// return id
		return "Line_" + Integer.toString(lineCounter);
	}
}
