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
import org.cip4.lib.xjdf.schema.Milestone;
import org.cip4.lib.xjdf.schema.Notification;
import org.cip4.lib.xjdf.type.DateTime;
import org.cip4.lib.xprinttalk.PrintTalkNodeFactory;
import org.cip4.lib.xprinttalk.builder.PrintTalkBuilder;
import org.cip4.lib.xprinttalk.schema.OrderStatusResponse;

/**
 * Implementation of a Milestone builder class. This class covers the functionality for the creation of a full milestone PrintTalk Message.
 * @author stefan.meissner
 * @date 06.12.2012
 */
public final class MilestoneMsgBuilder extends PrintTalkBuilder {

	public final static String DIGITAL_ART_ARRIVED = "DigitalArtArrived";

	private final PrintTalkNodeFactory ptkNf;

	private final XJdfNodeFactory nf;

	/**
	 * Custom Constructor. Create and return a new instance of PrintTalkBuilder.
	 */
	public MilestoneMsgBuilder(String businessID, String milestoneType) {

		super();

		// init instance variables
		nf = new XJdfNodeFactory();
		ptkNf = new PrintTalkNodeFactory();

		// create milestone
		Milestone milestone = nf.createMilestone();
		milestone.setMilestoneType(milestoneType);

		Notification notification = nf.createNotification();
		notification.withMilestone(milestone);
		notification.withTimeStamp(new DateTime());

		OrderStatusResponse orderStatusResponse = ptkNf.createOrderStatusResponse(businessID);
		orderStatusResponse.getNotification().add(notification);
		this.addRequest(orderStatusResponse);

	}

}
