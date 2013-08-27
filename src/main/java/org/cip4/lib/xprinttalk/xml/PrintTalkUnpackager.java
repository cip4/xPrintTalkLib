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

import org.cip4.lib.xjdf.xml.internal.AbstractXmlUnpackager;

/**
 * Unpackaging logic for PrintTalk Packages.
 * @author s.meissner
 * @date 12.08.2013
 */
public class PrintTalkUnpackager extends AbstractXmlUnpackager {

	/**
	 * Custom constructor. Accepting a PrintTalk Package Path for initializing.
	 * @param pathPackage Path to XJDF Package.
	 * @throws IOException
	 */
	public PrintTalkUnpackager(String pathPackage) throws IOException {
		super(pathPackage);
	}

	/**
	 * Returns the PrintTalk Master Document covered by the PrintTalkNavigator.
	 * @return PrintTalk Document covered by the PrintTalkNavigator.
	 * @throws Exception
	 */
	public PrintTalkNavigator getPrintTalkDocument() throws Exception {

		// find XJDF master document
		byte[] bytes = super.findMasterDocument();

		// return as navigator
		return new PrintTalkNavigator(bytes);
	}

	/**
	 * Unpackage an PrintTalk Package to a temporary directory.
	 * @param pathPackage PrintTalk Package to be unpackaged.
	 * @return The path of the printtalk document.
	 * @throws IOException
	 */
	public String unpackagePrintTalkTemp() throws IOException {

		// unpackage
		return super.unpackageZipTemp();
	}

	/**
	 * Unpackage an PrintTalk Package to a temporary directory.
	 * @param pathPackage PrintTalk Package to be unpackaged.
	 * @return The path of the printtalk document.
	 * @throws IOException
	 */
	public String unpackagePrintTalkTemp(String appName) throws IOException {

		// unpackage
		return super.unpackageZipTemp(appName);
	}

	/**
	 * Unpackage an PrintTalk Package to a target directory.
	 * @param pathPackage PrintTalk Package to be unpackaged.
	 * @param targetDir Target directory for unpackaging.
	 * @return The path of the printtalk document.
	 * @throws IOException
	 */
	public String unpackagePrintTalk(String targetDir) throws IOException {

		// unpackge
		return super.unpackageZip(targetDir);
	}

	/**
	 * @see org.cip4.lib.xjdf.xml.internal.AbstractXmlUnpackager#getMasterExtension()
	 */
	@Override
	protected String[] getMasterExtension() {
		return new String[] { "ptk", "xjdf" };
	}
}
