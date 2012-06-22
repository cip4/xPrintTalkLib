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

import java.util.Calendar;

import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;

import org.cip4.lib.xjdf.builder.AbstractNodeBuilder;
import org.cip4.lib.xjdf.util.ConversionUtils;
import org.cip4.lib.xprinttalk.PrintTalkNodeFactory;
import org.cip4.lib.xprinttalk.schema.jdf.BusinessObject;
import org.cip4.lib.xprinttalk.schema.jdf.PrintTalk;
import org.cip4.lib.xprinttalk.schema.jdf.Request;
import org.cip4.lib.xprinttalk.xml.PrintTalkConstants;

/**
 * Implementation of a PrintTalk builder class.
 * @author s.meissner
 * @date 22.06.2012
 */
public class PrintTalkBuilder extends AbstractNodeBuilder<PrintTalk> {

	private final PrintTalkNodeFactory ptkNodeFactory;

	/**
	 * Private default constructor. Class cannot being instantiated from external.
	 */
	private PrintTalkBuilder() {

		super(PrintTalkNodeFactory.newInstance().createPrintTalk());

		// initialize instance parameters
		ptkNodeFactory = PrintTalkNodeFactory.newInstance();
	}

	/**
	 * Create and return a new instance of PrintTalkBuilder.
	 * @return New PrintTalkBuilder instance.
	 */
	public static PrintTalkBuilder newInstance() {

		// return new instance
		return new PrintTalkBuilder();
	}

	/**
	 * Create and return a new instance of PrintTalkBuilder preconfigured with attributes Timestamp (current Time), payloadID (paramter) and the latest version
	 * number.
	 * @return New PrintTalkBuilder instance.
	 */
	public static PrintTalkBuilder newInstance(String payloadID) {

		// create instance
		PrintTalkBuilder printTalkBuilder = newInstance();

		// preconfiguration
		printTalkBuilder.getPrintTalk().setTimestamp(ConversionUtils.date2String(Calendar.getInstance()));
		printTalkBuilder.getPrintTalk().setPayloadID(payloadID);
		printTalkBuilder.getPrintTalk().setVersion(PrintTalkConstants.PTK_CURRENT_VERSION);

		// return instance
		return printTalkBuilder;
	}

	/**
	 * Add a BusinessObject object as request.
	 * @param businessObject BusinessObject object to append.
	 * @return The current PrintTalkBuilder instance.
	 */
	public PrintTalkBuilder addRequest(BusinessObject businessObject) {

		if (getPrintTalk().getRequest() == null) {
			// new Request node
			Request request = ptkNodeFactory.createRequest();
			getPrintTalk().setRequest(request);
		}

		// set business object
		String paramName = businessObject.getClass().getSimpleName();
		QName qname = new QName(PrintTalkConstants.NAMESPACE_PTK20, paramName);
		JAXBElement element = new JAXBElement(qname, businessObject.getClass(), businessObject);

		Request request = getPrintTalk().getRequest();
		request.setBusinessObject(element);

		// return current builder
		return this;
	}

	/**
	 * Getter for PrintTalk attribute.
	 * @return the PrintTalk
	 */
	public PrintTalk getPrintTalk() {
		return getNode();
	}

}
