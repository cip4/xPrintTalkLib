package org.cip4.lib.xprinttalk.xml;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.StringUtils;
import org.cip4.lib.xjdf.util.IDGeneratorUtil;
import org.cip4.lib.xjdf.xml.internal.AbstractXmlPackager;
import org.cip4.lib.xjdf.xml.internal.JAXBNavigator;
import org.cip4.lib.xjdf.xml.internal.PackagerException;
import org.cip4.lib.xprinttalk.schema.PrintTalk;
import org.cip4.lib.xprinttalk.schema.PurchaseOrder;

import javax.xml.xpath.XPathExpressionException;
import java.io.OutputStream;
import java.nio.file.Path;

/**
 * Packaging logic for PrintTalk Documents. Package an PrintTalk with all references in a ZIP Package.
 */
public class PrintTalkPackager extends AbstractXmlPackager<PrintTalk> {

    /**
     * Create a new PrintTalkPackager.
     *
     * @param out The underlying OutputStream to write the package to.
     */
    public PrintTalkPackager(final OutputStream out) {
        super(out);
    }

    /**
     * Create a new PrintTalkPackager.
     *
     * This constructor should be used if an existing archive should be enhanced.
     *
     * @param zipPath The path to an existing archive.
     * @param out The underlying OutputStream to write the package to.
     */
    public PrintTalkPackager(final Path zipPath, final OutputStream out) {
        super(zipPath, out);
    }

    @Override
    protected final byte[] parseDocument(final PrintTalk printTalk) throws Exception {
        return new PrintTalkParser().parsePrintTalk(printTalk);
    }

    /**
     * Packages a PrintTalk document to a zipped binary output stream.
     *
     * @param ptk The PrintTalk document to package.
     *
     * @throws Exception If packaging fails.
     */
    public final void packagePrintTalk(final PrintTalk ptk) throws Exception {
        JAXBNavigator<PrintTalk> jaxbNavigator = new JAXBNavigator<>(ptk);
        jaxbNavigator.addNamespace("ptk", PrintTalkConstants.NAMESPACE_PTK20);
        PurchaseOrder purchaseOrder = (PurchaseOrder) jaxbNavigator.evaluateNode(
            "//ptk:PrintTalk/ptk:Request/ptk:PurchaseOrder");
        packagePrintTalk(ptk, purchaseOrder.getBusinessID());
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
        packageXml(ptk, docName);
    }
}