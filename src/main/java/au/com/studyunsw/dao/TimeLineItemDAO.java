package au.com.studyunsw.dao;

import java.util.*;

import au.com.studyunsw.model.*;

/**
 * DAO for TimeLineItem and the table named that<br />
 * @author range-ubuntu
 *
 */
public interface TimeLineItemDAO {
	/**
	 * Retrieve all time line items in the database<br />
	 * 
	 * @return item list
	 */
	List<TimeLineItem> getAllItems();

	/**
	 * Get a time line item by its ID<br />
	 * 
	 * @param itemId
	 *            item ID
	 * @return item object
	 */
	TimeLineItem getItemById(long itemId);

	/**
	 * Get all items in a time line record<br />
	 * 
	 * @param timeLineId
	 *            time line ID
	 * @return item list
	 */
	List<TimeLineItem> getItemsInTimeLine(long timeLineId);

	/**
	 * Get all items in a time line record whose due dates are before some day<br />
	 * 
	 * @param timeLineId
	 *            time line ID
	 * @param day
	 *            some day
	 * @return item list
	 */
	List<TimeLineItem> getItemsInTimeLineBeforeDate(long timeLineId, Date day);

	/**
	 * Get all items in a time line record whose due dates are after some day<br />
	 * 
	 * @param timeLineId
	 *            time line ID
	 * @param day
	 *            some day
	 * @return item list
	 */
	List<TimeLineItem> getItemsInTimeLineAfterDate(long timeLineId, Date day);

	/**
	 * Get all assignments in a time line record<br />
	 * 
	 * @param timeLineId
	 *            time line ID
	 * @return item list
	 */
	List<TimeLineItem> getAssignmentsInTimeLine(long timeLineId);

	/**
	 * Get all exams in a time line record<br />
	 * 
	 * @param timeLineId
	 *            time line ID
	 * @return item list
	 */
	List<TimeLineItem> getExamsInTimeLine(long timeLineId);

	/**
	 * Insert a new time line item<br />
	 * 
	 * @param item
	 *            item object
	 * @return if the insertion is successful
	 */
	boolean insertItem(TimeLineItem item);

	/**
	 * Update an existing time line item<br />
	 * 
	 * @param item
	 *            item object
	 * @return if the update is successful
	 */
	boolean udpateItem(TimeLineItem item);

	/**
	 * Remove an item<br />
	 * 
	 * @param item
	 *            item object
	 * @return if the remove is successful
	 */
	boolean removeItem(TimeLineItem item);
}
