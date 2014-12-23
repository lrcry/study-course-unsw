package au.com.studyunsw.dao;

import java.util.Date;
import java.util.List;

import au.com.studyunsw.model.timelineitem.ExamItem;
import au.com.studyunsw.model.timelineitem.TimeLineItem;

/**
 * DAO for exam items in a time line<br/>
 * 
 * @author range-ubuntu
 * 
 */
public interface ExamItemDAO {
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
	
	void insertExamItem(ExamItem item);

	void updateExamItem(ExamItem item);
	
	void removeExamItem(ExamItem item);
	
	void insertExamItemBatch(List<ExamItem> items);
	
	/**
	 * Remove all items in a time line<br/>
	 * 
	 * @param timeLineId
	 *            time line ID
	 */
	void removeItemInTimeLine(long timeLineId);
}
