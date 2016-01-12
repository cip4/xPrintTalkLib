package org.cip4.lib.xprinttalk.xml;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang.StringUtils;
import org.cip4.lib.xjdf.util.IDGeneratorUtil;
import org.cip4.lib.xjdf.xml.internal.AbstractXmlPackager;
import org.cip4.lib.xjdf.xml.internal.PackagerException;
import org.cip4.lib.xjdf.xml.internal.XmlNavigator;

import javax.xml.xpath.XPathExpressionException;
import java.io.OutputStream;
import java.net.URI;

/**
 * Packaging logic for PrintTalk Documents. Package an PrintTalk with all references in a ZIP Package.
 */
public class PrintTalkPackager extends AbstractXmlPackager {

    /**
     * Create a new PrintTalkPackager.
     *
     * @param out     The underlying OutputStream to write the package to.
     */
    public PrintTalkPackager(final OutputStream out) {
        super(out, false);
    }

	/**
	 * Create a new PrintTalkPackager.
	 *
	 * @param out     The underlying OutputStream to write the package to.
	 * @param withoutHierarchy Put all files into the zip root.
	 */
	public PrintTalkPackager(final OutputStream out, final boolean withoutHierarchy) {
		super(out, withoutHierarchy);
	}

    @Override
    public final void packageXml(
        final XmlNavigator ptkNavigator,
        final URI rootUri
    ) throws PackagerException, XPathExpressionException {
        packagePrintTalk((PrintTalkNavigator) ptkNavigator, rootUri);
    }

    /**
     * Packages an XJDF Document to a zipped binary output stream.
     *
     * @param ptkNavigator The PrintTalkNavigator containing the data.
     * @param rootUri The root URI to use when dealing with relative URIs.
     *
     * @throws PackagerException If the PTK document could not be packaged.
     * @throws XPathExpressionException If the BusinessID of the PTK could not be read.
     */
    public final void packagePrintTalk(
        final PrintTalkNavigator ptkNavigator,
        final URI rootUri
    ) throws PackagerException, XPathExpressionException {
        final String businessID = ptkNavigator.readAttribute(PrintTalkNavigator.BUSINESS_ID);
        packagePrintTalk(ptkNavigator, businessID, rootUri);
    }

    /**
     * Packages an XJDF Document to a zipped binary output stream.
     *
     * @param ptkNavigator The PrintTalkNavigator containing the data.
     * @param docName Documents name in ZIP Package.
     * @param rootUri The root URI to use when dealing with relative URIs.
     *
     * @throws PackagerException If the PTK could not be packaged.
     */
    public final void packagePrintTalk(
        final PrintTalkNavigator ptkNavigator,
        final String docName,
        final URI rootUri
    ) throws PackagerException {
        String tmpDocName = docName;
        if (StringUtils.isBlank(tmpDocName)) {
            tmpDocName = IDGeneratorUtil.generateID("PTK") + ".ptk";
        } else {
            if (StringUtils.isBlank(FilenameUtils.getExtension(tmpDocName))) {
                tmpDocName += ".ptk";
            }
        }

        packageXml(ptkNavigator, tmpDocName, rootUri);
    }
}