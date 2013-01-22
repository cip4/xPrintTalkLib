/**
 * All rights reserved by
 * 
 * flyeralarm GmbH
 * Alfred-Nobel-Straße 18
 * 97080 Würzburg
 *
 * Email: info@flyeralarm.com
 * Website: http://www.flyeralarm.com
 */
package org.cip4.lib.xprinttalk.builder.msg;

import org.cip4.lib.xjdf.XJdfNodeFactory;
import org.cip4.lib.xjdf.builder.AbstractNodeBuilder;
import org.cip4.lib.xjdf.schema.Milestone;
import org.cip4.lib.xjdf.schema.Notification;
import org.cip4.lib.xprinttalk.PrintTalkNodeFactory;
import org.cip4.lib.xprinttalk.builder.PrintTalkBuilder;
import org.cip4.lib.xprinttalk.schema.OrderStatusResponse;
import org.cip4.lib.xprinttalk.schema.PrintTalk;

/**
 * Implementation of a Milestone builder class. This class covers the functionality for the creation of a full milestone PrintTalk Message.
 * @author stefan.meissner
 * @date 06.12.2012
 */
public final class MilestoneMsgBuilder extends AbstractNodeBuilder<PrintTalk> {

	public final static String DIGITAL_ART_ARRIVED = "DigitalArtArrived";

	/**
	 * Private default constructor. Class cannot being instantiated from external.
	 */
	private MilestoneMsgBuilder(PrintTalk printTalk) {

		super(printTalk);
	}

	/**
	 * Create and return a new instance of PrintTalkBuilder.
	 * @return New PrintTalkBuilder instance.
	 */
	public static MilestoneMsgBuilder newInstance(String businessID, String jobID, String milestoneType) {

		// create instance
		PrintTalkBuilder ptkBuilder = new PrintTalkBuilder();
		MilestoneMsgBuilder milestoneBuilder = new MilestoneMsgBuilder(ptkBuilder.build());

		// preconfiguration
		XJdfNodeFactory xJdfNodeFactory = new XJdfNodeFactory();

		Milestone milestone = xJdfNodeFactory.createMilestone();
		milestone.setMilestoneType(milestoneType);

		Notification notification = xJdfNodeFactory.createNotification();
		notification.setJobID(jobID);
		notification.setType("Milestone");
		notification.getMilestone().add(milestone);

		PrintTalkNodeFactory ptkNodeFactory = new PrintTalkNodeFactory();
		OrderStatusResponse orderStatusResponse = ptkNodeFactory.createOrderStatusResponse(businessID);
		ptkBuilder.addRequest(orderStatusResponse);

		orderStatusResponse.getNotification().add(notification);

		// return instance
		return milestoneBuilder;
	}

	/**
	 * Getter for PrintTalk attribute.
	 * @return the PrintTalk
	 */
	protected PrintTalk getPrintTalk() {
		return getNode();
	}
}
