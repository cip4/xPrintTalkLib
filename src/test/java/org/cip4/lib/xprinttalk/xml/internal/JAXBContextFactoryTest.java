package org.cip4.lib.xprinttalk.xml.internal;

import org.junit.Test;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;

import static org.junit.Assert.*;

public class JAXBContextFactoryTest {

    @Test
    public void initIsIdempotent() throws JAXBException {
        JAXBContextFactory.init();
        JAXBContext context1 = JAXBContextFactory.getInstance();
        JAXBContextFactory.init();
        JAXBContext context2 = JAXBContextFactory.getInstance();
        assertSame(context1, context2);
    }

}