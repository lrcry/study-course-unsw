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
public interface AsgtDao {
	Assignment getAssignmentById(long asgtId);

	List<Assignment> getAssignmentsByCourse(String courseCode);

	List<Assignment> getAssignmentOfCourseByDueDate(String courseCode,
			Date endDate);
}
