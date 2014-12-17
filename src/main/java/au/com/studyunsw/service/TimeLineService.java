package au.com.studyunsw.service;

import java.util.*;

import au.com.studyunsw.model.DueDateLineOnTime;
import au.com.studyunsw.model.TimeLineItem;

/**
 * Service generating due date time line.<br/>
 * A user can use it if and only if it has logged in.<br/>
 * U have a class, Assignment,
 * 
 * @author range-ubuntu
 * 
 */
public interface TimeLineService {
	List<DueDateLineOnTime> getAllTimeLine();

	DueDateLineOnTime getTimeLineById(long timeLineId);

	List<TimeLineItem> getAllItems();

	TimeLineItem getItemById(long itemId);

	/**
	 * Get all the items from a time line<br/>
	 * 
	 * @param timeLineId
	 *            time line ID
	 * @return list of time line items
	 */
	List<TimeLineItem> getItemsFromTimeLine(long timeLineId);

	/**
	 * Get all time lines for a user<br/>
	 * 
	 * @param userId
	 *            user ID
	 * @return list of time lines
	 */
	List<DueDateLineOnTime> getUserTimeLine(long userId);

	/**
	 * Create a new time line and save to server<br/>
	 * 
	 * @param timeLine
	 *            time line
	 * @return if successfully created
	 */
	boolean createNewTimeLine(DueDateLineOnTime timeLine);

	/**
	 * Modify an existing time line (i.e. name of a time line, etc.)<br/>
	 * 
	 * @param timeLine
	 *            time line object
	 * @return if successfully modified
	 */
	boolean modifyTimeLine(DueDateLineOnTime timeLine);

	/**
	 * Add an item to time line<br/>
	 * 
	 * @param timeLine
	 *            time line object (to get the time line ID)
	 * @param item
	 *            item object
	 * @return if successfully added
	 */
	boolean addItemToTimeLine(DueDateLineOnTime timeLine, TimeLineItem item);

	/**
	 * Update an item of some time line<br/>
	 * 
	 * @param timeLine
	 *            time line object
	 * @param item
	 *            item object
	 * @return if successfully updated
	 */
	boolean updateItemOfTimeLine(DueDateLineOnTime timeLine, TimeLineItem item);

	/**
	 * Remove an item from some time line<br/>
	 * 
	 * @param timeLine
	 *            time line object
	 * @param item
	 *            item object
	 * @return if successfully removed
	 */
	boolean removeItemFromTimeLine(DueDateLineOnTime timeLine, TimeLineItem item);

}
