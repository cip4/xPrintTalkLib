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

import java.io.InputStream;
import java.io.OutputStream;

import javax.xml.bind.JAXBException;
import javax.xml.bind.ValidationException;

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

	/**
	 * Parse a PrintTalk Object Tree to a binary output stream.
	 * @param printTalk PrintTalk Object Tree for parsing.
	 * @param os Target OutputStream where PrintTalk Document is being parsed.
	 * @throws ValidationException Is thrown in case PrintTalk is not valid and validation process is not being skipped.
	 * @throws Exception Is thrown in case an exception occurs.
	 */
	public void parsePrintTalk(PrintTalk printTalk, OutputStream os) throws Exception {
		parseXml(printTalk, os);
	}

	/**
	 * Parse a PrintTalk Object Tree to a binary output stream.
	 * @param printTalk PrintTalk Object Tree for parsing.
	 * @param os Target OutputStream where PrintTalk Document is being parsed.
	 * @param skipValidation Indicates whether or not validation has to be skipped.
	 * @throws ValidationException Is thrown in case PrintTalk is not valid and validation process is not being skipped.
	 * @throws Exception Is thrown in case an exception occurs.
	 */
	public void parsePrintTalk(PrintTalk printTalk, OutputStream os, boolean skipValidation) throws Exception {
		parseXml(printTalk, os, skipValidation);
	}

	/**
	 * Parse a binary input stream to a PrintTalk Object Tree.
	 * @param is Binary PrintTalk Input Stream for parsing.
	 * @return PrintTalk Object Tree parsed from binary input stream.
	 * @throws Exception Is thrown in case an exception occurs.
	 */
	@Override
	public PrintTalk parseStream(InputStream is) throws Exception {
		return super.parseStream(is);
	}

}
