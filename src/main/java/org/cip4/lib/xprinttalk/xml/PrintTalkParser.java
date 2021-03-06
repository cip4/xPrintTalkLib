package org.cip4.lib.xprinttalk.xml;

import com.sun.xml.bind.marshaller.NamespacePrefixMapper;
import org.cip4.lib.xjdf.xml.XJdfConstants;
import org.cip4.lib.xjdf.xml.internal.AbstractXmlParser;
import org.cip4.lib.xjdf.xml.internal.AbstractXmlValidator;
import org.cip4.lib.xprinttalk.schema.PrintTalk;
import org.cip4.lib.xprinttalk.xml.internal.JAXBContextFactory;
import org.cip4.lib.xprinttalk.xml.internal.PrintTalkNamespaceMapper;
import org.xml.sax.SAXException;

import javax.xml.bind.JAXBException;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.OutputStream;

/**
 * Parsing logic for building a XML Document from PrintTalk DOM-Tree and the way around.
 */
public class PrintTalkParser extends AbstractXmlParser<PrintTalk> {

    /**
     * Private default constructor.
     *
     * @throws JAXBException Thrown in case a JAXBException occurs.
     */
    public PrintTalkParser() throws JAXBException {
        super(JAXBContextFactory.getInstance());
    }

    /**
     * Parse a PrintTalk Object Tree to a binary output stream.
     *
     * @param printTalk PrintTalk Object Tree for parsing.
     * @param os Target OutputStream where PrintTalk Document is being parsed.
     *
     * @throws ParserConfigurationException Is thrown in case a serious configuration error occurs.
     * @throws JAXBException Is thrown in case any error while un-/marshalling occurs.
     * @throws SAXException Is thrown in case parsing an xml document fails.
     * @throws IOException Is thrown in case any IO error occurs.
     */
    public final void parsePrintTalk(final PrintTalk printTalk, final OutputStream os)
        throws ParserConfigurationException, JAXBException, SAXException, IOException {
        parseXml(printTalk, os);
    }

    /**
     * Parse a PrintTalk Object Tree to a binary output stream.
     *
     * @param printTalk PrintTalk Object Tree for parsing.
     * @param os Target OutputStream where PrintTalk Document is being parsed.
     * @param skipValidation Indicates whether or not validation has to be skipped.
     *
     * @throws ParserConfigurationException Is thrown in case a serious configuration error occurs.
     * @throws JAXBException Is thrown in case any error while un-/marshalling occurs.
     * @throws SAXException Is thrown in case parsing an xml document fails.
     * @throws IOException Is thrown in case any IO error occurs.
     */
    public final void parsePrintTalk(final PrintTalk printTalk, final OutputStream os, final boolean skipValidation)
        throws IOException, ParserConfigurationException, SAXException, JAXBException {
        parseXml(printTalk, os, skipValidation);
    }

    /**
     * Parse a PrintTalk Object Tree to a byte array.
     *
     * @param printTalk PrintTalk Object Tree for parsing.
     *
     * @return PrintTalk as byte array.
     * @throws ParserConfigurationException Is thrown in case a serious configuration error occurs.
     * @throws JAXBException Is thrown in case any error while un-/marshalling occurs.
     * @throws SAXException Is thrown in case parsing an xml document fails.
     * @throws IOException Is thrown in case any IO error occurs.
     */
    public final byte[] parsePrintTalk(final PrintTalk printTalk)
        throws ParserConfigurationException, IOException, SAXException, JAXBException {
        return parseXml(printTalk);
    }

    /**
     * Parse a PrintTalk Object Tree to a byte array.
     *
     * @param printTalk PrintTalk Object Tree for parsing.
     * @param skipValidation Skip validation.
     *
     * @return PrintTalk as byte array.
     * @throws ParserConfigurationException Is thrown in case a serious configuration error occurs.
     * @throws JAXBException Is thrown in case any error while un-/marshalling occurs.
     * @throws SAXException Is thrown in case parsing an xml document fails.
     * @throws IOException Is thrown in case any IO error occurs.
     */
    public final byte[] parsePrintTalk(final PrintTalk printTalk, final boolean skipValidation)
        throws ParserConfigurationException, JAXBException, SAXException, IOException {
        return parseXml(printTalk, skipValidation);
    }

    /**
     * Returns a new specific NamespacePrefixMapper implementation.
     *
     * @return New specific NamespacePrefixMapper implementation.
     */
    @Override
    protected final NamespacePrefixMapper getNamespacePrefixMapper() {
        return new PrintTalkNamespaceMapper();
    }

    /**
     * Returns the XML Header for marshaling.
     *
     * @return XML Header as String
     */
    @Override
    protected final String getXmlHeader() {
        String header = "<!-- Generated by CIP4 xPrintTalkLib " + PrintTalkConstants.PTK_LIB_VERSION
            + " and CIP4 xJdfLib " + XJdfConstants.XJDF_LIB_VERSION + " -->\r\n";
        header = header.replaceAll("  ", " ");
        return header;
    }

    @Override
    protected final AbstractXmlValidator createValidator() {
        return new PrintTalkValidator();
    }

}
