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
	 * Default constructor.
	 */
	public PrintTalkUnpackager() {
	}

	/**
	 * Unpackage an PrintTalk Package to a temporary directory.
	 * @param pathPackage PrintTalk Package to be unpackaged.
	 * @return The target directory
	 * @throws IOException
	 */
	public String unpackagePrintTAlk(String pathPackage) throws IOException {

		// unpackge
		return super.unpackageZip(pathPackage);
	}

	/**
	 * Unpackage an PrintTalk Package to a target directory.
	 * @param pathPackage PrintTalk Package to be unpackaged.
	 * @param targetDir Target directory for unpackaging.
	 * @return The target directory
	 * @throws IOException
	 */
	public String unpackagePrintTAlk(String pathPackage, String targetDir) throws IOException {

		// unpackge
		return super.unpackageZip(pathPackage, targetDir);
	}
}
