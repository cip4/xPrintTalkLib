package org.cip4.lib.xprinttalk.xml;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import org.cip4.lib.xjdf.xml.XJdfConstants;
import org.cip4.lib.xjdf.xml.internal.AbstractXmlValidator;
import org.cip4.lib.xprinttalk.schema.PrintTalk;

/**
 * Validation of PrintTalk Documents based on PrintTalk schema file.
 *
 * @author s.meissner
 */
public class PrintTalkValidator extends AbstractXmlValidator<PrintTalk> {

    /**
     * Custom constructor. Accepting PrintTalk Stream for initializing.
     *
     * @param printTalkStream Stream to read the PrintTalk document from.
     *
     * @throws IOException if an error errors while reading the document.
     */
    public PrintTalkValidator(final InputStream printTalkStream) throws IOException {
        super(PrintTalkConstants.PTK_XSD_BYTES, printTalkStream, loadXsdDependencies());
    }

    /**
     * Private helper method for load XSD Dependencies.
     *
     * @return XSD Dependencies
     */
    private static Map<String, byte[]> loadXsdDependencies() {
        Map<String, byte[]> map = new HashMap<>(2);
        map.put("./JDF20.xsd", XJdfConstants.XJDF_XSD_BYTES);

        return map;
    }
}
