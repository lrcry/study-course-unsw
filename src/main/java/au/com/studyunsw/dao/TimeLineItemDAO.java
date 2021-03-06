package au.com.studyunsw.dao;

import java.util.*;

import au.com.studyunsw.model.timelineitem.*;

/**
 * DAO for TimeLineItem and the table named that<br />
 * 
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
	 * Insert a new time line item<br />
	 * 
	 * @param item
	 *            item object
	 */
	void insertItem(TimeLineItem item);

	/**
	 * Update an existing time line item<br />
	 * 
	 * @param item
	 *            item object
	 */
	void updateItem(TimeLineItem item);

	/**
	 * Remove an item<br />
	 * 
	 * @param item
	 *            item object
	 */
	void removeItem(TimeLineItem item);

	/**
	 * Remove all items in a time line<br/>
	 * 
	 * @param timeLineId
	 *            time line ID
	 */
	void removeItemInTimeLine(long timeLineId);
}
