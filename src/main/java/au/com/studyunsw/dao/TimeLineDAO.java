package au.com.studyunsw.dao;

import java.util.List;

import au.com.studyunsw.model.DueDateLineOnTime;

/**
 * DAO for DueDateLineOnTime and DueDateLineOnTime table<br />
 * 
 * @author range-ubuntu
 * 
 */
public interface TimeLineDAO {
	/**
	 * Retrieve all due date time line<br />
	 * 
	 * @return time line list
	 */
	List<DueDateLineOnTime> getAllDueDateLine();

	/**
	 * Get a time line record by its ID<br />
	 * 
	 * @param timeLineId
	 *            time line ID
	 * @return time line object
	 */
	DueDateLineOnTime getLineById(long timeLineId);

	/**
	 * Retrieve time lines created by a user<br />
	 * 
	 * @param userId
	 *            user ID
	 * @return time line list
	 */
	List<DueDateLineOnTime> getLineByUser(long userId);

	/**
	 * Retrieve time lines with a name created by a user<br />
	 * 
	 * @param userId
	 *            user ID
	 * @param lineName
	 *            time line name
	 * @return time line object
	 */
	List<DueDateLineOnTime> getLineByUserAndName(long userId, String lineName);

	/**
	 * Insert a new time line record<br />
	 * 
	 * @param line
	 *            time line object
	 * @return if the insertion is successful
	 */
	boolean insertNewLine(DueDateLineOnTime line);

	/**
	 * Update an existing time line record<br />
	 * 
	 * @param line
	 *            time line object
	 * @return if the update is successful
	 */
	boolean updateLine(DueDateLineOnTime line);

	/**
	 * Remove a time line record<br />
	 * 
	 * @param line
	 *            time line object
	 * @return if the remove is successful
	 */
	boolean removeLine(DueDateLineOnTime line);
}
