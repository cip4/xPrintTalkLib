package org.cip4.lib.xprinttalk.xml;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;

/**
 * JUnit test case for PrintTalkUnpackager class.
 * @author s.meissner
 * @date 21.08.2013
 */
public class PrintTalkUnpackagerTest {

	private final static String RES_PGK = "/org/cip4/lib/xprinttalk/testPackage.zip";

	/**
	 * Setup unit test.
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
	public void testUnpackageZip() throws IOException, URISyntaxException {

		// arrange
		String pathZip = PrintTalkUnpackagerTest.class.getResource(RES_PGK).toURI().getPath();

		String tmpDir = FileUtils.getTempDirectoryPath();
		String targetDir = FilenameUtils.concat(tmpDir, "xPrintTalkLib_UnpackageTest_" + System.currentTimeMillis());

		// assert
		PrintTalkUnpackager unpackager = new PrintTalkUnpackager(pathZip);
		unpackager.unpackagePrintTalk(targetDir);

		// act
		File targetFile = new File(targetDir);
		Assert.assertTrue("Target destination does not exist.", targetFile.exists());

		String pathPtk = FilenameUtils.concat(targetDir, "testPackage.ptk");
		Assert.assertTrue("File does not exist.", new File(pathPtk).exists());

		String pathArtwork = FilenameUtils.concat(targetDir, "artwork/testArtwork.pdf");
		Assert.assertTrue("Artwork does not exist.", new File(pathArtwork).exists());

		String pathPreview = FilenameUtils.concat(targetDir, "preview/testPreview.pdf");
		Assert.assertTrue("Preview does not exist.", new File(pathPreview).exists());

		FileUtils.deleteDirectory(targetFile); // clean up
		Assert.assertFalse("Target destination was not removed.", targetFile.exists());
	}

	@Test
	public void testUnpackageZipTempDir() throws IOException, URISyntaxException {

		// arrange
		String pathZip = PrintTalkUnpackagerTest.class.getResource(RES_PGK).toURI().getPath();

		// assert
		PrintTalkUnpackager unpackager = new PrintTalkUnpackager(pathZip);
		String targetDir = FilenameUtils.getFullPath(unpackager.unpackagePrintTalkTemp());

		// act
		File targetFile = new File(targetDir);
		Assert.assertTrue("Target destination does not exist.", targetFile.exists());

		String pathPtk = FilenameUtils.concat(targetDir, "testPackage.ptk");
		Assert.assertTrue("File does not exist.", new File(pathPtk).exists());

		String pathArtwork = FilenameUtils.concat(targetDir, "artwork/testArtwork.pdf");
		Assert.assertTrue("Artwork does not exist.", new File(pathArtwork).exists());

		String pathPreview = FilenameUtils.concat(targetDir, "preview/testPreview.pdf");
		Assert.assertTrue("Preview does not exist.", new File(pathPreview).exists());

		FileUtils.deleteDirectory(targetFile); // clean up
		Assert.assertFalse("Target destination was not removed.", targetFile.exists());
	}

	@Test
	public void testGetPrintTalkDocument() throws Exception {

		// arrange
		String path = PrintTalkUnpackagerTest.class.getResource(RES_PGK).toURI().getPath();
		PrintTalkUnpackager unpackager = new PrintTalkUnpackager(path);

		// act
		PrintTalkNavigator nav = unpackager.getPrintTalkDocument();

		String pathPreview = nav.evaluateString("//XJDF/ParameterSet[@Name='Preview']/Parameter/Preview/@URL");
		byte[] bytes = unpackager.extractFile(pathPreview);

		// assert
		Assert.assertEquals("BusinessID is wrong.", "95733854", nav.evaluateString(PrintTalkNavigator.BUSINESS_ID));
        Assert.assertTrue("Preview is null.", 0 < bytes.length);
	}

}
