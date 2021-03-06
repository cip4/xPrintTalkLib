package org.cip4.lib.xprinttalk.xml.internal;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;

import org.cip4.lib.xprinttalk.schema.PrintTalk;

/**
 * Static Factory Class which is managing a JAXB2 Marshaller instance.
 * @author s.meissner
 */
public class JAXBContextFactory {

	private static JAXBContext jaxbContext;

	/**
	 * Private constructor. This class cannot be instantiated.
	 */
	private JAXBContextFactory() {
		// protection from reflection
		throw new AssertionError("Factory Class cannot be instantiated.");
	}

	/**
	 * Initialize the marshaller instance.
	 */
	public static void init() throws JAXBException {
		if (jaxbContext == null) {
			// initialize
			jaxbContext = JAXBContext.newInstance(PrintTalk.class);
		}
	}

	/**
	 * Create and return a new Marshaller Instance.
	 * @return New Marshaller instance.
	 * @throws JAXBException
	 */
	public static JAXBContext getInstance() throws JAXBException {

		// if necessary initialize
		if (jaxbContext == null) {
			init();
		}

		// return JAXBContext instance
		return jaxbContext;
	}
}
