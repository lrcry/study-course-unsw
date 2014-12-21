package au.com.studyunsw.dao;

import java.util.*;

import au.com.studyunsw.model.*;

/**
 * DAO for CourseBasicInfo and coursebasicinfo table<br />
 * 
 * @author range-ubuntu
 * 
 */
public interface CourseBasicInfoDAO {
	/**
	 * Retrieve all courses<br />
	 * 
	 * @return courses list
	 */
	List<CourseBasicInfo> getAllCourses();

	/**
	 * Get the course by its course code<br />
	 * 
	 * @param courseCode
	 *            course code
	 * @return course object
	 */
	CourseBasicInfo getCourseByCourseCode(String courseCode);

	/**
	 * Retrieve all courses held by a faculty<br />
	 * 
	 * @param courseAuthority
	 *            course authority
	 * @return courses list
	 */
	List<CourseBasicInfo> getCoursesByAuthority(String courseAuthority);

	/**
	 * Get the course by its name<br />
	 * 
	 * @param courseName
	 *            course name
	 * @return course object
	 */
	CourseBasicInfo getCourseByName(String courseName);

	/**
	 * Retrieve all courses held in the semester<br />
	 * 
	 * @param semester
	 *            semester
	 * @return courses list
	 */
	List<CourseBasicInfo> getSemesterCourses(int semester);

	/**
	 * Get all courses held by a lecturer<br />
	 * 
	 * @param lecturerName
	 *            lecturer's name
	 * @return courses list
	 */
	List<CourseBasicInfo> getCoursesByLecturer(String lecturerName);

	/**
	 * Create a new course<br />
	 * 
	 * @param course
	 *            course object
	 */
	void insertNewCourse(CourseBasicInfo course);

	/**
	 * Update an existing course<br />
	 * 
	 * @param course
	 *            course object
	 */
	void updateCourse(CourseBasicInfo course);

	/**
	 * Remove a course<br />
	 * 
	 * @param course
	 *            course object
	 */
	void removeCourse(CourseBasicInfo course);
}
