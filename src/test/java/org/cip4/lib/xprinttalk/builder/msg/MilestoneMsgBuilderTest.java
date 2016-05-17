package org.cip4.lib.xprinttalk.builder.msg;

import org.cip4.lib.xprinttalk.builder.AbstractBuilderTest;
import org.cip4.lib.xprinttalk.schema.PrintTalk;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * JUnit Test Case for MilestoneBuilder
 */
public class MilestoneMsgBuilderTest extends AbstractBuilderTest<PrintTalk> {

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

	/**
	 * PrintTalk Message creation test.
	 */
	@Test
	public void testBuildMessage() throws Exception {

		// arrange
		final String BUSINESS_ID = "businessID";
		final String JOB_ID = "jobID";
		final String MILESTONE_TYPE = "milestoneType";

		// act
		MilestoneMsgBuilder builder = new MilestoneMsgBuilder(BUSINESS_ID, JOB_ID, MILESTONE_TYPE);

		// assert
		byte[] bytes = marsahlResult(builder);

		String actualBusinessID = getXPathValue(bytes, "/ptk:PrintTalk/ptk:Request/ptk:OrderStatusResponse/@BusinessID");
		assertEquals("BusinessID is wrong.", BUSINESS_ID, actualBusinessID);

		String actualJobID = getXPathValue(bytes, "/ptk:PrintTalk/ptk:Request/ptk:OrderStatusResponse/xjdf:Notification/@JobID");
		assertEquals("JobID is wrong.", JOB_ID, actualJobID);

		String actualMilestoneType = getXPathValue(bytes, "/ptk:PrintTalk/ptk:Request/ptk:OrderStatusResponse/xjdf:Notification/xjdf:Milestone/@MilestoneType");
		assertEquals("MilestoneType is wrong.", MILESTONE_TYPE, actualMilestoneType);
	}
}