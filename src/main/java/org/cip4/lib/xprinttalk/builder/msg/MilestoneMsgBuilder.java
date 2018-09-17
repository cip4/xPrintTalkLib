package org.cip4.lib.xprinttalk.builder.msg;

import org.cip4.lib.xjdf.XJdfNodeFactory;
import org.cip4.lib.xjdf.schema.Milestone;
import org.cip4.lib.xjdf.schema.Notification;
import org.cip4.lib.xjdf.schema.Severity;
import org.cip4.lib.xprinttalk.PrintTalkNodeFactory;
import org.cip4.lib.xprinttalk.builder.PrintTalkBuilder;
import org.cip4.lib.xprinttalk.schema.OrderStatusResponse;

/**
 * Implementation of a Milestone builder class. This class covers the functionality for the creation of a full milestone PrintTalk Message.
 */
public final class MilestoneMsgBuilder extends PrintTalkBuilder {

	private final PrintTalkNodeFactory ptkNf;

	private final XJdfNodeFactory nf;

	/**
	 * Custom Constructor. Create and return a new instance of PrintTalkBuilder.
	 */
	public MilestoneMsgBuilder(String businessID, String jobID, String milestoneType) {
		super();

		// init instance variables
		nf = new XJdfNodeFactory();
		ptkNf = new PrintTalkNodeFactory();

		// create milestone
		Milestone milestone = new Milestone();
		milestone.setMilestoneType(milestoneType);

		Notification notification = new Notification();
		notification.setJobID(jobID);
		notification.setClazz(Severity.EVENT);
		notification.setMilestone(milestone);

		OrderStatusResponse orderStatusResponse = ptkNf.createOrderStatusResponse(businessID);
		orderStatusResponse.getNotification().add(notification);
		this.addRequest(orderStatusResponse);
	}
}