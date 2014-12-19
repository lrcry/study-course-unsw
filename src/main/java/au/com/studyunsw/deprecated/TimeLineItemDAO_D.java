package au.com.studyunsw.deprecated;

import java.util.*;

import au.com.studyunsw.model.*;

/**
 * DAO for TimeLineItem and the table named that<br />
 * 
 * @author range-ubuntu
 * 
 */
public interface TimeLineItemDAO_D {
	/**
	 * Retrieve all time line items in the database<br />
	 * 
	 * @return item list
	 */
	List<TimeLineItem_D> getAllItems();

	/**
	 * Get a time line item by its ID<br />
	 * 
	 * @param itemId
	 *            item ID
	 * @return item object
	 */
	TimeLineItem_D getItemById(long itemId);

	/**
	 * Get all items in a time line record<br />
	 * 
	 * @param timeLineId
	 *            time line ID
	 * @return item list
	 */
	List<TimeLineItem_D> getItemsInTimeLine(long timeLineId);

	/**
	 * Get all items in a time line record whose due dates are before some day<br />
	 * 
	 * @param timeLineId
	 *            time line ID
	 * @param day
	 *            some day
	 * @return item list
	 */
	List<TimeLineItem_D> getItemsInTimeLineBeforeDate(long timeLineId, Date day);

	/**
	 * Get all items in a time line record whose due dates are after some day<br />
	 * 
	 * @param timeLineId
	 *            time line ID
	 * @param day
	 *            some day
	 * @return item list
	 */
	List<TimeLineItem_D> getItemsInTimeLineAfterDate(long timeLineId, Date day);

	/**
	 * Get all assignments in a time line record<br />
	 * 
	 * @param timeLineId
	 *            time line ID
	 * @return item list
	 */
	List<TimeLineItem_D> getAssignmentsInTimeLine(long timeLineId);

	/**
	 * Get all exams in a time line record<br />
	 * 
	 * @param timeLineId
	 *            time line ID
	 * @return item list
	 */
	List<TimeLineItem_D> getExamsInTimeLine(long timeLineId);

	/**
	 * Insert a new time line item<br />
	 * 
	 * @param item
	 *            item object
	 * @return if the insertion is successful
	 */
	boolean insertItem(TimeLineItem_D item);

	/**
	 * Update an existing time line item<br />
	 * 
	 * @param item
	 *            item object
	 * @return if the update is successful
	 */
	boolean udpateItem(TimeLineItem_D item);

	/**
	 * Remove an item<br />
	 * 
	 * @param item
	 *            item object
	 * @return if the remove is successful
	 */
	boolean removeItem(TimeLineItem_D item);

	/**
	 * Remove all items in a time line<br/>
	 * 
	 * @param timeLineId
	 *            time line ID
	 * @return if the remove is successful
	 */
	boolean removeItemInTimeLine(long timeLineId);
}
