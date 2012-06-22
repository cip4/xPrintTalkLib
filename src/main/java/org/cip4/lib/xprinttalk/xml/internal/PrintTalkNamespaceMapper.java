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
package org.cip4.lib.xprinttalk.xml.internal;

import org.cip4.lib.xjdf.xml.internal.XJdfNamespaceMapper;
import org.cip4.lib.xprinttalk.xml.PrintTalkConstants;

import com.sun.xml.bind.marshaller.NamespacePrefixMapper;

/**
 * PrintTalk Namespace Prefix Mapper for organizing namespace prefixes.
 * @author s.meissner
 * @date 22.06.2012
 */
public class PrintTalkNamespaceMapper extends NamespacePrefixMapper {

	private final String nsDefaultNamespace;

	private final NamespacePrefixMapper xjdfMapper;

	/**
	 * Default constructor.
	 */
	public PrintTalkNamespaceMapper() {

		// chain constructors
		this(null);
	}

	/**
	 * Custom constructor. <br/>
	 * Accepting a String object as place holder for default namespace. This place holder later can be replaced by empty string.
	 */
	public PrintTalkNamespaceMapper(String nsDefaultNamespace) {

		// initialize parameter
		this.nsDefaultNamespace = nsDefaultNamespace;
		xjdfMapper = new XJdfNamespaceMapper();
	}

	/**
	 * @see com.sun.xml.bind.marshaller.NamespacePrefixMapper#getPreferredPrefix(java.lang.String, java.lang.String, boolean)
	 */
	@Override
	public String getPreferredPrefix(String namespaceUri, String suggestion, boolean requirePrefix) {

		String result;

		if (namespaceUri.equals(PrintTalkConstants.NAMESPACE_PTK20)) {
			// printtalk prefix
			result = "ptk";

		} else {
			// other namespace
			result = xjdfMapper.getPreferredPrefix(namespaceUri, suggestion, requirePrefix);
		}

		// return result
		return result;
	}

}
