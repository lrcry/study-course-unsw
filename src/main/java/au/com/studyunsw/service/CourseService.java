package au.com.studyunsw.service;

import java.util.*;

import au.com.studyunsw.model.*;

/**
 * Service managing and querying course information<br />
 * 
 * @author range-ubuntu
 * 
 */
public interface CourseService {
	/**
	 * Get information of all courses<br/>
	 * 
	 * @return list of courses, or null if no course at all
	 */
	List<CourseBasicInfo> getAllCourse();

	/**
	 * Get brief information of all courses<br/>
	 * 
	 * @return <courseCode, courseName>, or null if no course at all
	 */
	Map<String, String> getAllCourseBrief();

	/**
	 * Get information of a course by its course code<br/>
	 * 
	 * @param courseCode
	 *            course code
	 * @return course object, or null if no course with the course code
	 */
	CourseBasicInfo getCourseByCourseCode(String courseCode);

	/**
	 * Get all assignments of a course<br/>
	 * 
	 * @param courseCode
	 *            course code
	 * @return list of assignments, or null if no assignment at all
	 */
	List<Assignment> getAllAssignmentsOfCourse(String courseCode);

	/**
	 * Get Nth assignment of a course<br/>
	 * 
	 * @param courseCode
	 *            course code
	 * @param nth
	 *            this is the nth assignment
	 * @return assignment object or null if not exists
	 */
	Assignment getNthAssignmentOfCourse(String courseCode, int nth);

	/**
	 * Get all exams of a course<br/>
	 * 
	 * @param courseCode
	 *            course code
	 * @return list of exams, or null if no assignment at all
	 */
	List<Exam> getAllExamsOfCourse(String courseCode);

	/**
	 * Get exams of some type (e.g. mid-term, final) of a course<br/>
	 * 
	 * @param courseCode
	 *            course code
	 * @param type
	 *            exam type
	 * @return exams which in the type
	 */
	List<Exam> getSomeTypeExamOfCourse(String courseCode, int type);
}
