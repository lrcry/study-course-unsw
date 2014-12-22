package au.com.studyunsw.service;

import java.util.*;

import au.com.studyunsw.model.timelineitem.*;
import au.com.studyunsw.model.DueDateLineOnTime;

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
	 * Retrieve all system-generated items (assignments, exams) from a time line<br/>
	 * 
	 * @param timeLineId
	 *            time line ID
	 * @return list of system items
	 */
	List<TimeLineItem> getAllAutoGenItemsFromLine(long timeLineId);

	/**
	 * Retrieve all user-created items from a time line<br/>
	 * 
	 * @param timeLineId
	 *            time line ID
	 * @return list of user items
	 */
	List<TimeLineItem> getAllUserItemsFromLine(long timeLineId);

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
	 * @return operation status code
	 */
	int createNewTimeLine(DueDateLineOnTime timeLine);

	/**
	 * Modify an existing time line (i.e. name of a time line, etc.)<br/>
	 * 
	 * @param timeLine
	 *            time line object
	 * @return operation status code
	 */
	int modifyTimeLine(DueDateLineOnTime timeLine);

	/**
	 * Remove the time line with all of its items<br/>
	 * 
	 * @param timeLine
	 *            time line object
	 * @return operation status code
	 */
	int removeTimeLine(DueDateLineOnTime timeLine);

	/**
	 * Automatically add or update system items for a user<br/>
	 * 
	 * @param timeLine
	 *            time line object
	 * @return operation status code
	 */
	int addSystemItemToTimeLine(DueDateLineOnTime timeLine);

	/**
	 * User add an item to time line<br/>
	 * 
	 * @param timeLine
	 *            time line object (to get the time line ID)
	 * @param item
	 *            user item object
	 * @return operation status code
	 */
	int addItemToTimeLine(DueDateLineOnTime timeLine, UserItem item);

	/**
	 * Update a system-generated item of a time line<br/>
	 * 
	 * @param timeLine
	 *            time line object
	 * @param item
	 *            item object
	 * @return operation status code
	 */
//	int updateSystemItemOfTimeLine(DueDateLineOnTime timeLine, TimeLineItem item);

	/**
	 * Update a user-created item of some time line<br/>
	 * 
	 * @param timeLine
	 *            time line object
	 * @param item
	 *            item object
	 * @return operation status code
	 */
	int updateItemOfTimeLine(DueDateLineOnTime timeLine, TimeLineItem item);

	/**
	 * Remove an item from some time line<br/>
	 * 
	 * @param timeLine
	 *            time line object
	 * @param item
	 *            item object
	 * @return operation status code
	 */
	int removeItemFromTimeLine(DueDateLineOnTime timeLine, TimeLineItem item);

}
