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

import java.util.UUID;

import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;

import org.cip4.lib.xjdf.builder.AbstractNodeBuilder;
import org.cip4.lib.xjdf.type.DateTime;
import org.cip4.lib.xprinttalk.PrintTalkNodeFactory;
import org.cip4.lib.xprinttalk.schema.BusinessObject;
import org.cip4.lib.xprinttalk.schema.PrintTalk;
import org.cip4.lib.xprinttalk.schema.Request;
import org.cip4.lib.xprinttalk.xml.PrintTalkConstants;

/**
 * Implementation of a PrintTalk builder class.
 * @author s.meissner
 */
public class PrintTalkBuilder extends AbstractNodeBuilder<PrintTalk> {

	private final PrintTalkNodeFactory ptkNodeFactory;

	/**
	 * Default constructor.
	 */
	public PrintTalkBuilder() {

		this(UUID.randomUUID().toString());
	}

	/**
	 * Custom Constructor. Creates a new instance of PrintTalkBuilder preconfigured with attributes Timestamp (current Time), payloadID (paramter) and the
	 * latest version number.
	 */
	public PrintTalkBuilder(String payloadID) {

		super(new PrintTalkNodeFactory().createPrintTalk());

		// init
		this.ptkNodeFactory = new PrintTalkNodeFactory();

		// preconfiguration
		getPrintTalk().setTimestamp(new DateTime());
		getPrintTalk().setPayloadID(payloadID);
		getPrintTalk().setVersion(PrintTalkConstants.PTK_CURRENT_VERSION);

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
	protected PrintTalk getPrintTalk() {
		return getNode();
	}
}
