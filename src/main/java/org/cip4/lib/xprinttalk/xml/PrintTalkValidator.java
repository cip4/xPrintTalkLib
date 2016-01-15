package org.cip4.lib.xprinttalk.xml;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.cip4.lib.xjdf.xml.XJdfConstants;
import org.cip4.lib.xjdf.xml.internal.AbstractXmlValidator;
import org.cip4.lib.xprinttalk.schema.PrintTalk;

/**
 * Validation of PrintTalk Documents based on PrintTalk schema file.
 */
public class PrintTalkValidator extends AbstractXmlValidator<PrintTalk> {

    /**
     * URL of the internal PrintTalk schema.
     */
    private static final URL SCHEMA = PrintTalkValidator.class.getResource("/PrintTalk20.xsd");

    /**
     * Custom constructor. Accepting PrintTalk Stream for initializing.
     */
    public PrintTalkValidator() {
        super(loadXsdDependencies());
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

    @Override
    protected final URL getSchema() {
        return SCHEMA;
    }
}
