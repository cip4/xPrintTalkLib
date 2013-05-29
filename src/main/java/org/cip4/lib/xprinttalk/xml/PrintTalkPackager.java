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

import java.io.OutputStream;

import org.cip4.lib.xjdf.util.IDGeneratorUtil;
import org.cip4.lib.xjdf.xml.XJdfPackager;

/**
 * Packaging logic for PrintTalk Documents. Package an PrintTalk with all references in a ZIP Package.
 * @author stefan.meissner
 * @date 27.01.2013
 */
public class PrintTalkPackager extends XJdfPackager {

	/**
	 * Custom constructor. Accepting an PrintTalk Document for initializing.
	 * @param ptk PrintTalk Document byte array for packaging.
	 * @throws Exception
	 */
	public PrintTalkPackager(byte[] ptk) throws Exception {

		super(ptk);

	}

	/**
	 * Packages an XJDF Document to a zipped binary output stream.
	 * @param os Target OutputStream where XJdfDocument is being packaged.
	 * @param docName Documents name in ZIP Package.
	 * @throws Exception
	 */
	public void packagePrintTalk(OutputStream os, String docName) throws Exception {

		// package xml
		packageXJdf(os, docName, false);
	}

	/**
	 * Packages an XJDF Document to a zipped binary output stream.
	 * @param os Target OutputStream where XJdfDocument is being packaged.
	 * @param docName Documents name in ZIP Package.
	 * @param withoutHierarchy Put all files into the ZIP Root.
	 * @throws Exception
	 */
	public void packagePrintTalk(OutputStream os, String docName, boolean withoutHierarchy) throws Exception {

		// create main doc Name
		if (docName == null || docName.equals("")) {
			docName = IDGeneratorUtil.generateID("PTK") + ".ptk";
		}

		// package xml
		packageXJdf(os, docName, withoutHierarchy);
	}

}
