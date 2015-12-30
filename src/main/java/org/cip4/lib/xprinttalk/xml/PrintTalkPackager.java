package org.cip4.lib.xprinttalk.xml;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang.StringUtils;
import org.cip4.lib.xjdf.util.IDGeneratorUtil;
import org.cip4.lib.xjdf.xml.internal.AbstractXmlPackager;

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
	 * @param withoutHierarchy Put all files into the zip root.
	 */
	public PrintTalkPackager(final OutputStream out, final boolean withoutHierarchy) {
		super(out, withoutHierarchy);
	}

    /**
     * Packages an XJDF Document to a zipped binary output stream.
     *
     * @param ptkNavigator The PrintTalkNavigator containing the data.
     * @param rootUri The root URI to use when dealing with relative URIs.
     *
     * @throws Exception If the XML document could not be packaged.
     */
    public final void packagePrintTalk(final PrintTalkNavigator ptkNavigator, final URI rootUri) throws Exception {
        String jobId = ptkNavigator.readAttribute(PrintTalkNavigator.BUSINESS_ID);
        if (jobId != null) {
            jobId += ".ptk";
        }

        packagePrintTalk(ptkNavigator, jobId, rootUri);
    }

    /**
     * Packages an XJDF Document to a zipped binary output stream.
     *
     * @param ptkNavigator The PrintTalkNavigator containing the data.
     * @param docName Documents name in ZIP Package.
     * @param rootUri The root URI to use when dealing with relative URIs.
     *
     * @throws Exception If the XML document could not be packaged.
     */
    public final void packagePrintTalk(
        final PrintTalkNavigator ptkNavigator,
        final String docName,
        final URI rootUri
    ) throws Exception {
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