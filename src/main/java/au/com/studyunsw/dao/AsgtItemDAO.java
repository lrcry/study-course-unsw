package au.com.studyunsw.dao;

import java.util.*;

import au.com.studyunsw.model.timelineitem.AsgtItem;
import au.com.studyunsw.model.timelineitem.TimeLineItem;

/**
 * DAO for assignment items in a time line<br/>
 * 
 * @author range-ubuntu
 * 
 */
public interface AsgtItemDAO {
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
	
	void insertAsgtItem(AsgtItem item);

	void updateAsgtItem(AsgtItem item);
	
	void removeAsgtItem(AsgtItem item);
	
	void insertAsgtItemBatch(List<AsgtItem> items);
	
	/**
	 * Remove all items in a time line<br/>
	 * 
	 * @param timeLineId
	 *            time line ID
	 */
	void removeItemInTimeLine(long timeLineId);
}
