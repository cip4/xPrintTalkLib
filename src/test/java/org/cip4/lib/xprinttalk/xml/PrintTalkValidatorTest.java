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

import java.io.IOException;
import java.io.InputStream;

import javax.xml.bind.JAXBException;
import javax.xml.parsers.ParserConfigurationException;

import org.cip4.lib.xjdf.xml.internal.JAXBContextFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.xml.sax.SAXException;

/**
 * JUnit test case for PrintTalkValidator.
 * @author s.meissner
 * @date 03.07.2012
 */
public class PrintTalkValidatorTest {

	private final String RES_TEST_PTK = "/org/cip4/lib/xprinttalk/simple_job.ptk";

	private PrintTalkValidator printTalkValidator;

	/**
	 * Default constructor.
	 */
	public PrintTalkValidatorTest() {
		try {
			JAXBContextFactory.init();
		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Set up unit test.
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {

		// init instance variables

	}

	/**
	 * Tear down unit test.
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {

		printTalkValidator = null;
	}

	/**
	 * Test method for {@link org.cip4.lib.xjdf.xml.internal.AbstractXmlValidator#check(java.io.InputStream)}.
	 * @throws IOException
	 * @throws ParserConfigurationException
	 * @throws SAXException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws ClassNotFoundException
	 */
	@Test
	public void testCheck() throws SAXException, ParserConfigurationException, IOException, ClassNotFoundException, IllegalAccessException, InstantiationException {

		// arrange
		InputStream is = PrintTalkValidatorTest.class.getResourceAsStream(RES_TEST_PTK);

		// act
		printTalkValidator = new PrintTalkValidator(is);
		boolean isValid = printTalkValidator.isValid();

		// assert
		System.out.println(printTalkValidator.getMessagesText());

		// TODO Update XSD for validations (e.g. ID needed or not ??)
		// Assert.assertTrue("Validation result is wrong", isValid);
	}

}
