package org.cip4.lib.xprinttalk.xml;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang.StringUtils;
import org.cip4.lib.xjdf.schema.XJDF;
import org.cip4.lib.xjdf.util.IDGeneratorUtil;
import org.cip4.lib.xjdf.xml.internal.AbstractXmlPackager;
import org.cip4.lib.xjdf.xml.internal.JAXBNavigator;
import org.cip4.lib.xjdf.xml.internal.PackagerException;
import org.cip4.lib.xprinttalk.schema.PrintTalk;

import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import java.io.OutputStream;

/**
 * Packaging logic for PrintTalk Documents. Package an PrintTalk with all references in a ZIP Package.
 */
public class PrintTalkPackager extends AbstractXmlPackager {

    /**
     * Create a new PrintTalkPackager.
     *
     * @param out The underlying OutputStream to write the package to.
     */
    public PrintTalkPackager(final OutputStream out) {
        super(out);
    }

    /**
     * Packages a PrintTalk document to a zipped binary output stream.
     *
     * @param ptk The PrintTalk document to package.
     *
     * @throws PackagerException If the PTK document could not be packaged.
     * @throws XPathExpressionException If the BusinessID of the PTK could not be read.
     */
    public final void packagePrintTalk(
        final PrintTalk ptk
    ) throws PackagerException, XPathExpressionException {
        String businessID = ptk.getRequest().getBusinessObject().getValue().getBusinessID();
        packagePrintTalk(ptk, businessID);
    }

    /**
     * Packages a PrintTalk document.
     *
     * @param ptk The PrintTalk document to package.
     * @param docName Document's name in ZIP Package.
     *
     * @throws PackagerException If the PTK could not be packaged.
     * @throws XPathExpressionException If the PTK could not be packaged.
     */
    public final void packagePrintTalk(
        final PrintTalk ptk,
        String docName
    ) throws PackagerException, XPathExpressionException {
        if (StringUtils.isBlank(docName)) {
            docName = IDGeneratorUtil.generateID("PTK") + ".ptk";
        } else {
            if (StringUtils.isBlank(FilenameUtils.getExtension(docName))) {
                docName += ".ptk";
            }
        }
        XJDF xjdf = extractXjdfNode(ptk);
        packageXml(xjdf, docName);
    }

    /**
     * Extracts the XJDF node out of a PrintTalk document.
     *
     * @param ptk PrintTalk document.
     *
     * @return Extracted xjdf.
     */
    private XJDF extractXjdfNode(final PrintTalk ptk) {
        try {
            JAXBNavigator<PrintTalk> jaxbNavigator = new JAXBNavigator<>(ptk);
            return (XJDF) jaxbNavigator.evaluate("//xjdf:XJDF", XPathConstants.NODE);
        } catch (Exception e) {
            throw new IllegalArgumentException("Could not extract the XJDF document", e);
        }
    }
}