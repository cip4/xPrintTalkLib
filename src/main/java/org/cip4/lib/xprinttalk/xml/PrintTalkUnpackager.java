package org.cip4.lib.xprinttalk.xml;

import java.io.IOException;

import org.cip4.lib.xjdf.xml.internal.AbstractXmlUnpackager;

/**
 * Unpackaging logic for PrintTalk Packages.
 *
 * @author s.meissner
 * @author m.hartmann
 */
public class PrintTalkUnpackager extends AbstractXmlUnpackager {

    /**
     * Custom constructor. Accepting a PrintTalk Package Path for initializing.
     *
     * @param pathPackage Path to XJDF Package.
     *
     * @throws IOException if an I/O error occurs.
     */
    public PrintTalkUnpackager(final String pathPackage) throws IOException {
        super(pathPackage);
    }

    /**
     * Returns the PrintTalk Master Document covered by the PrintTalkNavigator.
     *
     * @return PrintTalk Document covered by the PrintTalkNavigator.
     * @throws Exception
     */
    public final PrintTalkNavigator getPrintTalkDocument() throws Exception {
        return getPrintTalkDocument(false);
    }

    /**
     * Returns the PrintTalk Master Document covered by the PrintTalkNavigator.
     *
     * @param namespaceAware true if document should be opened namespace aware.
     *
     * @return PrintTalk Document covered by the PrintTalkNavigator.
     * @throws Exception
     */
    public final PrintTalkNavigator getPrintTalkDocument(final boolean namespaceAware) throws Exception {
        // find XJDF master document
        byte[] bytes = super.findMasterDocument();

        // return as navigator
        return new PrintTalkNavigator(bytes, namespaceAware);
    }

    /**
     * Unpackage an PrintTalk Package to a temporary directory.
     *
     * @return The path of the printtalk document.
     * @throws IOException if an I/O error occurs.
     */
    public final String unpackagePrintTalkTemp() throws IOException {
        // unpackage
        return super.unpackageZipTemp();
    }

    /**
     * Unpackage an PrintTalk Package to a temporary directory.
     *
     * @param appName Name of the app.
     *
     * @return The path of the printtalk document.
     * @throws IOException if an I/O error occurs.
     */
    public final String unpackagePrintTalkTemp(final String appName) throws IOException {
        // unpackage
        return super.unpackageZipTemp(appName);
    }

    /**
     * Unpackage an PrintTalk Package to a target directory.
     *
     * @param targetDir Target directory for unpackaging.
     *
     * @return The path of the printtalk document.
     * @throws IOException if an I/O error occurs.
     */
    public final String unpackagePrintTalk(final String targetDir) throws IOException {
        // unpackge
        return super.unpackageZip(targetDir);
    }

    /**
     * @see org.cip4.lib.xjdf.xml.internal.AbstractXmlUnpackager#getMasterExtension()
     */
    @Override
    protected final String[] getMasterExtension() {
        return new String[]{"ptk", "xjdf"};
    }
}
