/**
 * The CIP4 Software License, Version 1.0
 *
 * Copyright (c) 2001-2009 The International Cooperation for the Integration of 
 * Processes in  Prepress, Press and Postpress (CIP4).  All rights 
 * reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 * 1. Redistributions of source code must retain the above copyright
 *    notice, this list of conditions and the following disclaimer. 
 *
 * 2. Redistributions in binary form must reproduce the above copyright
 *    notice, this list of conditions and the following disclaimer in
 *    the documentation and/or other materials provided with the
 *    distribution.
 *
 * 3. The end-user documentation included with the redistribution,
 *    if any, must include the following acknowledgment:  
 *       "This product includes software developed by the
 *        The International Cooperation for the Integration of 
 *        Processes in  Prepress, Press and Postpress (www.cip4.org)"
 *    Alternately, this acknowledgment may appear in the software itself,
 *    if and wherever such third-party acknowledgments normally appear.
 *
 * 4. The names "CIP4" and "The International Cooperation for the Integration of 
 *    Processes in  Prepress, Press and Postpress" must
 *    not be used to endorse or promote products derived from this
 *    software without prior written permission. For written 
 *    permission, please contact info@cip4.org.
 *
 * 5. Products derived from this software may not be called "CIP4",
 *    nor may "CIP4" appear in their name, without prior written
 *    permission of the CIP4 organization
 *
 * Usage of this software in commercial products is subject to restrictions. For
 * details please consult info@cip4.org.
 *
 * THIS SOFTWARE IS PROVIDED ``AS IS'' AND ANY EXPRESSED OR IMPLIED
 * WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES
 * OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED.  IN NO EVENT SHALL THE INTERNATIONAL COOPERATION FOR
 * THE INTEGRATION OF PROCESSES IN PREPRESS, PRESS AND POSTPRESS OR
 * ITS CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
 * SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
 * LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF
 * USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT
 * OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF
 * SUCH DAMAGE.
 * ====================================================================
 *
 * This software consists of voluntary contributions made by many
 * individuals on behalf of the The International Cooperation for the Integration 
 * of Processes in Prepress, Press and Postpress and was
 * originally based on software 
 * copyright (c) 1999-2001, Heidelberger Druckmaschinen AG 
 * copyright (c) 1999-2001, Agfa-Gevaert N.V. 
 *  
 * For more information on The International Cooperation for the 
 * Integration of Processes in  Prepress, Press and Postpress , please see
 * <http://www.cip4.org/>.
 *  
 * 
 */
package org.cip4.lib.xprinttalk.xml;

import java.io.ByteArrayOutputStream;

import org.cip4.lib.xjdf.XJdfNodeFactory;
import org.cip4.lib.xjdf.builder.ProductBuilder;
import org.cip4.lib.xjdf.builder.XJdfBuilder;
import org.cip4.lib.xjdf.schema.GeneralID;
import org.cip4.lib.xjdf.schema.RunList;
import org.cip4.lib.xprinttalk.PrintTalkNodeFactory;
import org.cip4.lib.xprinttalk.builder.PrintTalkBuilder;
import org.cip4.lib.xprinttalk.schema.PrintTalk;
import org.cip4.lib.xprinttalk.schema.PurchaseOrder;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * JUnit test case for PrintTalkParser
 * @author stefan.meissner
 * @date 23.10.2012
 */
public class PrintTalkParserTest {

	PrintTalkParser ptkParser;

	/**
	 * Set up unit test.
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {

		// new Instance
		ptkParser = PrintTalkParser.newInstance();
	}

	/**
	 * Tear down unit test.
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {

		// set null
		ptkParser = null;
	}

	/**
	 * Test method for
	 * {@link org.cip4.lib.xprinttalk.xml.PrintTalkParser#parsePrintTalk(org.cip4.lib.xprinttalk.schema.PrintTalk, java.io.OutputStream, boolean)}.
	 */
	@Test
	public void testParsePrintTalkXmlHeader() throws Exception {

		// arrange
		final String PAYLOAD_ID = "PL_200";
		final String BUSINESS_ID = "BS_12345";
		final String JOB_ID = "JB_1234";
		final String AMOUNT = "1500";

		PrintTalkNodeFactory ptkNodeFactory = PrintTalkNodeFactory.newInstance();
		XJdfNodeFactory xJdfNodeFactory = XJdfNodeFactory.newInstance();

		PrintTalkBuilder builder = PrintTalkBuilder.newInstance(PAYLOAD_ID);

		PurchaseOrder purchaseOrder = ptkNodeFactory.createPurchaseOrder(BUSINESS_ID, "EUR");
		builder.addRequest(purchaseOrder);

		XJdfBuilder xJdfBuilder = XJdfBuilder.newInstance(JOB_ID);

		GeneralID generalId = xJdfNodeFactory.createGeneralID("CatalogID", "49");
		xJdfBuilder.addGeneralID(generalId);

		ProductBuilder productBuilder = ProductBuilder.newInstance(Integer.valueOf(AMOUNT).intValue());
		xJdfBuilder.addProduct(productBuilder.build());

		RunList runList = xJdfNodeFactory.createRunList("http://www.example.org:8080/artwork.pdf");
		xJdfBuilder.addParameter(runList);

		purchaseOrder.setXJDF(xJdfBuilder.build());
		PrintTalk printTalk = builder.build();

		// act
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		ptkParser.parsePrintTalk(printTalk, bos, true);

		// assert
		String strXml = new String(bos.toByteArray());
		System.out.println(strXml);

		int i = strXml.indexOf("\n");
		int n = strXml.indexOf("\n", i + 1);

		String actual = strXml.substring(i + 1, n);

		Assert.assertEquals("Result is wrong", "<!-- Generated by CIP4 xPrintTalkLib [version not specified] and CIP4 xJdfLib [version not specified] -->", actual);

	}
}
