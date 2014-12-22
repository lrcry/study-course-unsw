package au.com.studyunsw.dao;

import java.util.List;

import au.com.studyunsw.model.Exam;

/**
 * DAO for Exam and exam table<br />
 * 
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
	Exam getExamById(long examId);

	/**
	 * Retrieve exams by a course<br />
	 * 
	 * @param courseCode
	 *            course code
	 * @return exam list
	 */
	List<Exam> getExamsByCourse(String courseCode);

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
	 */
	void insertNewExam(Exam exam);

	/**
	 * Update an existing exam<br />
	 * 
	 * @param exam
	 *            exam object
	 */
	void updateExam(Exam exam);

	/**
	 * Remove an exam<br />
	 * 
	 * @param exam
	 *            exam object
	 */
	void removeExam(Exam exam);
}
