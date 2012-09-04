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

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;
import org.cip4.lib.xjdf.xml.internal.AbstractXmlValidator;

/**
 * Validation of PrintTalk Documents based on PrintTalk schema file.
 * @author s.meissner
 * @date 03.07.2012
 */
public class PrintTalkValidator extends AbstractXmlValidator<PrintTalkValidator> {

	/**
	 * Custom private constructor. Accepting XML Schema for initializing.
	 */
	private PrintTalkValidator(byte[] xsdFile, InputStream printTalkStream) {
		super(xsdFile, printTalkStream);
	}

	/**
	 * Factory method for getting a new XJdfValidator instance.
	 * @return New XJdfValidator Instance
	 * @throws IOException
	 */
	public static PrintTalkValidator newInstance(InputStream printTalkStream) throws IOException {

		// load xsd file
		InputStream is = PrintTalkValidator.class.getResourceAsStream(PrintTalkConstants.RES_PTK20_XSD);

		ByteArrayOutputStream bos;

		// convert input stream to byte array
		bos = new ByteArrayOutputStream();
		IOUtils.copy(is, bos);
		bos.close();

		// return new instance
		return new PrintTalkValidator(bos.toByteArray(), printTalkStream);
	}

	/**
	 * @see org.cip4.lib.xjdf.xml.internal.AbstractXmlValidator#getXsdPath()
	 */
	@Override
	protected String getXsdPath() {

		// extract XSD Path
		return FilenameUtils.getFullPath(PrintTalkConstants.RES_PTK20_XSD);
	}
}
