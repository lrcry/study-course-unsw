package au.com.studyunsw.dao;

import java.util.List;

import au.com.studyunsw.model.Exam;

/**
 * DAO for Exam and exam table<br />
 * @author range-ubuntu
 *
 */
public interface ExamDAO {
	/**
	 * Retrieve all exams of all courses<br />
	 * 
	 * @return exam list
	 */
	List<Exam> getAllExams();

	/**
	 * Get an exam by its ID<br />
	 * 
	 * @param examId
	 *            exam ID
	 * @return exam object
	 */
	Exam getExamId(long examId);

	/**
	 * Retrieve exams by a course<br />
	 * 
	 * @param courseCode
	 *            course code
	 * @return exam list
	 */
	List<Exam> getExamByCourse(String courseCode);

	/**
	 * Get some type of exams of a course<br />
	 * 
	 * @param courseCode
	 *            course code
	 * @param examType
	 *            type of exam
	 * @return exam list
	 */
	List<Exam> getTypeOfExamByCourse(String courseCode, int examType);

	/**
	 * Retrieve all exams by location<br />
	 * 
	 * @param location
	 *            exam location
	 * @return exam list
	 */
	List<Exam> getExamsByLocation(String location);

	/**
	 * Insert a new exam<br />
	 * 
	 * @param exam
	 *            exam object
	 * @return if the insertion is successful
	 */
	boolean insertNewExam(Exam exam);

	/**
	 * Update an existing exam<br />
	 * 
	 * @param exam
	 *            exam object
	 * @return if the update is successful
	 */
	boolean updateExam(Exam exam);

	/**
	 * Remove an exam<br />
	 * 
	 * @param exam
	 *            exam object
	 * @return if the removing is successful (I know all of you hope it
	 *         successful...)
	 */
	boolean removeExam(Exam exam);
}
