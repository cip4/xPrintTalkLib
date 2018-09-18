package org.cip4.lib.xprinttalk.xml.internal;

import org.cip4.lib.xjdf.xml.internal.XJdfNamespaceMapper;
import org.cip4.lib.xprinttalk.xml.PrintTalkConstants;

import com.sun.xml.bind.marshaller.NamespacePrefixMapper;

/**
 * PrintTalk Namespace Prefix Mapper for organizing namespace prefixes.
 * @author s.meissner
 */
public class PrintTalkNamespaceMapper extends NamespacePrefixMapper {

	private final NamespacePrefixMapper xjdfMapper;

	/**
	 * Default constructor.
	 */
	public PrintTalkNamespaceMapper() {

		// chain constructors
		this(null);
	}

	/**
	 * Custom constructor.
	 * Accepting a String object as place holder for default namespace. This place holder later can be replaced by empty string.
	 */
	public PrintTalkNamespaceMapper(String nsDefaultNamespace) {

		// initialize parameter
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
