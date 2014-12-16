package au.com.studyunsw.dao;

import java.util.Date;
import java.util.List;

import au.com.studyunsw.model.Assignment;

/**
 * DAO for assignment and assignment table<br />
 * 
 * @author range-ubuntu
 * 
 */
public interface AsgtDAO {
	/**
	 * Get the assignment by an ID<br />
	 * 
	 * @param asgtId
	 *            assignment ID
	 * @return assignment object
	 */
	Assignment getAssignmentById(long asgtId);

	/**
	 * Retrieve assignments of a course<br />
	 * 
	 * @param courseCode
	 *            course code
	 * @return list of assignments
	 */
	List<Assignment> getAssignmentsByCourse(String courseCode);

	/**
	 * Retrieve the assignments of a course which have a census date<br />
	 * 
	 * @param courseCode
	 *            course code
	 * @param endDate
	 *            census date of the assignment
	 * @return list of assignments
	 */
	List<Assignment> getAssignmentOfCourseByDueDate(String courseCode,
			Date endDate);

	/**
	 * Get the nth assignment of a course<br />
	 * 
	 * @param courseCode
	 *            course code
	 * @param nth
	 *            ordinal of the assignment
	 * @return assignment object
	 */
	Assignment getNthAssignmentOfCourse(String courseCode, int nth);

	/**
	 * Insert a new assignment<br />
	 * 
	 * @param asgt
	 *            assignment object
	 * @return if the insertion is successful
	 */
	boolean insertNewAssignment(Assignment asgt);

	/**
	 * Update an existing assignment<br />
	 * 
	 * @param asgt
	 *            assignment object
	 * @return if the update is successful
	 */
	boolean updateAssignment(Assignment asgt);

	/**
	 * Remove an assignment<br />
	 * 
	 * @param asgt
	 *            assignment object
	 * @return if the remove is successful
	 */
	boolean removeAssignment(Assignment asgt);
}
