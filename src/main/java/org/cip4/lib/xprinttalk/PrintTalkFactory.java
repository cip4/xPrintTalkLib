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

import javax.xml.bind.JAXBException;

import org.cip4.lib.xjdf.XJdfFactory;
import org.cip4.lib.xprinttalk.xml.PrintTalkConstants;
import org.cip4.lib.xprinttalk.xml.internal.JAXBContextFactory;

/**
 * Factory class for global library initialization.
 * @author s.meissner
 */
public class PrintTalkFactory implements Runnable {

	/**
	 * Private custom constructor.
	 */
	private PrintTalkFactory(boolean initAsync) {

		// init
		if (initAsync) {

			// synchronous call
			new Thread(this).start();

		} else {

			// synchronous call
			run();
		}

	}

	/**
	 * Initialize the PrintTalk Library.
	 */
	public static void init(boolean initAsync) {

		new PrintTalkFactory(initAsync);
	}

	/**
	 * Initialize the JAXB framework.
	 */
	public static void initXJdfPrintTalk() throws JAXBException {

		// init JAXB framework
		JAXBContextFactory.init();
	}

	/**
	 * Initialize PrintTalk Constants.
	 */
	public static void initPtkConstants() {

		// init constants
		@SuppressWarnings("unused")
		String tmp;
		tmp = PrintTalkConstants.NAMESPACE_PTK20;
		tmp = PrintTalkConstants.PTK_LIB_VERSION;
		tmp = PrintTalkConstants.PTK_LIB_BUILD_DATE;

		byte[] bytes = PrintTalkConstants.PTK_XSD_BYTES;
	}

	/**
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {

		// init JAXB
		try {
			initXJdfPrintTalk();
		} catch (JAXBException e) {
			throw new AssertionError(e);
		}

		// init XJDF Constants
		XJdfFactory.initXJdfConstants();

		// init PrintTalk Constants
		initPtkConstants();
	}
}
