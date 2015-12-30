package org.cip4.lib.xprinttalk.xml;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;
import org.cip4.lib.xjdf.XJdfNodeFactory;
import org.cip4.lib.xjdf.builder.ProductBuilder;
import org.cip4.lib.xjdf.builder.XJdfBuilder;
import org.cip4.lib.xjdf.schema.Product;
import org.cip4.lib.xjdf.schema.XJDF;
import org.cip4.lib.xjdf.xml.internal.AbstractXmlPackager.CompressionLevel;
import org.cip4.lib.xprinttalk.PrintTalkNodeFactory;
import org.cip4.lib.xprinttalk.builder.PrintTalkBuilder;
import org.cip4.lib.xprinttalk.schema.PrintTalk;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Paths;
import java.util.UUID;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/**
 * JUnit test case for PrintTalkPackager
 * @author stefan.meissner
 */
public class PrintTalkPackagerTest {

	private final static String RES_PDF = "/org/cip4/lib/xprinttalk/test.pdf";

	/**
	 * Set up unit test.
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * Tear down unit test.
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testPackagePrintTalk() throws Exception {

		// arrange
		String resPdf = PrintTalkPackagerTest.class.getResource(RES_PDF).toURI().getPath();

		XJdfNodeFactory nf = new XJdfNodeFactory();
		PrintTalkNodeFactory ptkNf = new PrintTalkNodeFactory();

		ProductBuilder productBuilder = new ProductBuilder(1000);
		Product product = productBuilder.build();

		XJdfBuilder xJdfBuilder = new XJdfBuilder("MyJobId");
		xJdfBuilder.addProduct(product);
		xJdfBuilder.addParameter(nf.createRunList(resPdf));
		XJDF xjdf = xJdfBuilder.build();

		PrintTalkBuilder ptkBuilder = new PrintTalkBuilder();
		ptkBuilder.addRequest(ptkNf.createPurchaseOrder("MyBusinessId", null, xjdf));
		PrintTalk ptk = ptkBuilder.build();

		// act
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		PrintTalkPackager packager = new PrintTalkPackager(bos, false);
		packager.setCompressionLevel(CompressionLevel.BEST_SPEED);
		packager.packagePrintTalk(
            new PrintTalkNavigator(new PrintTalkParser().parsePrintTalk(ptk), true),
            "MyJobFile.ptk",
            Paths.get(".").toUri()
        );

		// assert
		String dir = unzipStream(new ByteArrayInputStream(bos.toByteArray()));

		File xPtk = new File(FilenameUtils.concat(dir, "MyJobFile.ptk"));
		File pdf = new File(FilenameUtils.concat(dir, "artwork/test.pdf"));

		Assert.assertTrue("PrintTalk File does not exist.", xPtk.exists());
		Assert.assertTrue("PrintTalk File size is 0.", xPtk.length() > 0);

		PrintTalkNavigator ptkNav = new PrintTalkNavigator(new FileInputStream(xPtk));
		String pdfPath = ptkNav.readAttribute("//FileSpec/@URL");
		Assert.assertEquals("URL attribute is wrong.", "artwork/test.pdf", pdfPath);

		Assert.assertTrue("PDF File does not exist.", pdf.exists());
		Assert.assertTrue("PDF File size is 0.", pdf.length() > 0);

		FileUtils.deleteDirectory(new File(dir));
	}

	@Test
	public void testPackagePrintTalkWithoutHierarchy() throws Exception {

		// arrange
		String resPdf = PrintTalkPackagerTest.class.getResource(RES_PDF).toURI().getPath();

		XJdfNodeFactory nf = new XJdfNodeFactory();
		PrintTalkNodeFactory ptkNf = new PrintTalkNodeFactory();

		ProductBuilder productBuilder = new ProductBuilder(1000);
		Product product = productBuilder.build();

		XJdfBuilder xJdfBuilder = new XJdfBuilder("MyJobId");
		xJdfBuilder.addProduct(product);
		xJdfBuilder.addParameter(nf.createRunList(resPdf));
		XJDF xjdf = xJdfBuilder.build();

		PrintTalkBuilder ptkBuilder = new PrintTalkBuilder();
		ptkBuilder.addRequest(ptkNf.createPurchaseOrder("MyBusinessId", null, xjdf));
		PrintTalk ptk = ptkBuilder.build();

		// act
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		PrintTalkPackager packager = new PrintTalkPackager(bos, true);
		packager.setCompressionLevel(CompressionLevel.BEST_SPEED);
		packager.packagePrintTalk(
			new PrintTalkNavigator(new PrintTalkParser().parsePrintTalk(ptk), true),
			"MyJobFile.ptk",
            Paths.get(".").toUri()
		);

		// assert
		String dir = unzipStream(new ByteArrayInputStream(bos.toByteArray()));

		File xPtk = new File(FilenameUtils.concat(dir, "MyJobFile.ptk"));
		File pdf = new File(FilenameUtils.concat(dir, "test.pdf"));

		Assert.assertTrue("PrintTalk File does not exist.", xPtk.exists());
		Assert.assertTrue("PrintTalk File size is 0.", xPtk.length() > 0);

		PrintTalkNavigator ptkNav = new PrintTalkNavigator(new FileInputStream(xPtk));
		String pdfPath = ptkNav.readAttribute("//FileSpec/@URL");
		Assert.assertEquals("URL attribute is wrong.", "test.pdf", pdfPath);

		Assert.assertTrue("PDF File does not exist.", pdf.exists());
		Assert.assertTrue("PDF File size is 0.", pdf.length() > 0);

		FileUtils.deleteDirectory(new File(dir));
	}

	/**
	 * Private helper method for unpackaging zip stream.
	 * @param inputStream ZipStream as InputStream.
	 * @throws IOException
	 */
	private String unzipStream(InputStream inputStream) throws IOException {

		// create packaging root
		String strDir = FilenameUtils.concat(FileUtils.getTempDirectoryPath(), "PrintTalk-Packaging-" + UUID.randomUUID().toString());
		File dir = new File(strDir);
		dir.deleteOnExit();

		ZipInputStream zis = new ZipInputStream(inputStream);
		ZipEntry entry = null;

		while ((entry = zis.getNextEntry()) != null) {

			String entryName = entry.getName();

			if (!entry.isDirectory()) {
				// target path
				File f = new File(FilenameUtils.concat(dir.getAbsolutePath(), entryName));

				// create directory
				String s = FilenameUtils.getFullPath(f.getPath());
				new File(s).mkdirs();

				// create file
				OutputStream out = new FileOutputStream(f);
				IOUtils.copy(zis, out);
				out.close();
			}
		}

		return strDir;
	}

}
