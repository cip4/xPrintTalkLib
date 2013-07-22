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
import java.util.HashMap;
import java.util.Map;

import org.cip4.lib.xjdf.xml.XJdfConstants;
import org.cip4.lib.xjdf.xml.internal.AbstractXmlValidator;

/**
 * Validation of PrintTalk Documents based on PrintTalk schema file.
 * @author s.meissner
 * @date 03.07.2012
 */
public class PrintTalkValidator extends AbstractXmlValidator<PrintTalkValidator> {

	/**
	 * Custom constructor. Accepting PrintTalk Stream for initializing.
	 * @throws IOException
	 */
	public PrintTalkValidator(InputStream printTalkStream) throws IOException {
		super(PrintTalkConstants.PTK_XSD_BYTES, printTalkStream, loadXsdDependencies());
	}

	/**
	 * Private helper method for load XSD Dependencies.
	 * @return XSD Dependencies
	 */
	private static Map<String, byte[]> loadXsdDependencies() {

		// init map
		Map<String, byte[]> map = new HashMap<String, byte[]>(2);
		map.put("./JDF20.xsd", XJdfConstants.XJDF_XSD_BYTES);

		// return result
		return map;
	}
}
