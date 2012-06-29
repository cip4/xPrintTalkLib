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
package org.cip4.lib.xprinttalk.xml;

import javax.xml.bind.JAXBException;

import org.cip4.lib.xjdf.xml.internal.AbstractXmlParser;
import org.cip4.lib.xjdf.xml.internal.JAXBContextFactory;
import org.cip4.lib.xprinttalk.schema.PrintTalk;

/**
 * Parsing logic for building a XML Document from PrintTalk DOM-Tree and the way around.
 * @author s.meissner
 * @date 26.06.2012
 */
public class PrintTalkParser extends AbstractXmlParser<PrintTalk> {

	/**
	 * Private default constructor.
	 * @throws JAXBException Thrown in case a JAXBException occurs.
	 */
	private PrintTalkParser() throws JAXBException {

		// call super class
		super(JAXBContextFactory.getInstance());
	}

	/**
	 * Factory method for getting a new XJdfParser instance.
	 * @return New XJdfParser instance.
	 */
	public static PrintTalkParser newInstance() {

		try {

			// return new instance
			return new PrintTalkParser();

		} catch (JAXBException e) {

			// error
			e.printStackTrace();
			throw new AssertionError(e);

		}
	}

}
