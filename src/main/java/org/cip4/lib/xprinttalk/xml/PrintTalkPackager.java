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
	 * @param rootUri The root URI to use when dealing with relative URIs.
	 */
	public PrintTalkPackager(OutputStream out, URI rootUri) {
		super(out, rootUri);
	}

    /**
     * Packages an XJDF Document to a zipped binary output stream.
     *
     * @param ptkNavigator The PrintTalkNavigator containing the data.
     *
     * @throws Exception If the XML document could not be packaged.
     */
    public void packagePrintTalk(PrintTalkNavigator ptkNavigator) throws Exception {
        String jobId = ptkNavigator.readAttribute(PrintTalkNavigator.BUSINESS_ID);
        if (jobId != null) {
            jobId += ".ptk";
        }

        packagePrintTalk(ptkNavigator, jobId);
    }

    /**
     * Packages an XJDF Document to a zipped binary output stream.
     *
     * @param ptkNavigator The PrintTalkNavigator containing the data.
     * @param docName Documents name in ZIP Package.
     *
     * @throws Exception If the XML document could not be packaged.
     */
    public void packagePrintTalk(PrintTalkNavigator ptkNavigator, String docName) throws Exception {
        packagePrintTalk(ptkNavigator, docName, false);
    }

    /**
     * Packages an XJDF Document to a zipped binary output stream.
     *
     * @param ptkNavigator The PrintTalkNavigator containing the data.
     * @param docName Documents name in ZIP Package.
     * @param withoutHierarchy Put all files into the ZIP Root.
     *
     * @throws Exception If the XML document could not be packaged.
     */
    public void packagePrintTalk(PrintTalkNavigator ptkNavigator, String docName, boolean withoutHierarchy) throws Exception {
        if (StringUtils.isNotBlank(docName)) {
            if (StringUtils.isBlank(FilenameUtils.getExtension(docName))) {
                docName += ".ptk";
            }
        } else {
            docName = IDGeneratorUtil.generateID("PTK") + ".ptk";
        }

        packageXml(ptkNavigator, docName, withoutHierarchy);
    }

}
