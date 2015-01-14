package au.com.studyunsw.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import au.com.studyunsw.model.CourseBasicInfo;
import au.com.studyunsw.model.Assignment;
import au.com.studyunsw.model.Exam;
import au.com.studyunsw.dao.ExamDAO;
import au.com.studyunsw.dao.ExamItemDAO;
import au.com.studyunsw.dao.AsgtDAO;
import au.com.studyunsw.dao.AsgtItemDAO;
import au.com.studyunsw.dao.CourseBasicInfoDAO;
import au.com.studyunsw.service.CourseService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Implementor of course service<br/>
 * 
 * @author Liren Wang
 */
@Service
public class CourseServiceImpl implements CourseService {
	@Autowired
	private ExamDAO examdao;

	@Autowired
	private ExamItemDAO examitemdao;

	@Autowired
	private AsgtDAO asgtdao;

	@Autowired
	private AsgtItemDAO asgtitemdao;

	@Autowired
	private CourseBasicInfoDAO coursebasicinfodao;

	public List<CourseBasicInfo> getAllCourse() {
		try {
			List<CourseBasicInfo> allcourses = coursebasicinfodao
					.getAllCourses();// get all coursebasicinfo into the list
										// allcourse
			return allcourses;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public Map<String, String> getAllCourseBrief() {
		List<CourseBasicInfo> allcourses = null;
		Map<String, String> courseBrief = null;
		try {
			courseBrief = new HashMap<>();
			// get the list of all coursebasicinfo objects
			allcourses = coursebasicinfodao.getAllCourses();

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

		int size = allcourses.size();
		for (int j = 0; j < size; j++) {
			courseBrief.put(allcourses.get(j).getCourseCode(), allcourses
					.get(j).getCourseName());
		}// traverse the list and put the code and corresponding coursename of
			// each course into the map
		return courseBrief;
	}

	public CourseBasicInfo getCourseByCourseCode(String courseCode) {
		try {
			CourseBasicInfo coursebycode = coursebasicinfodao
					.getCourseByCourseCode(courseCode);
			// use dao to get the coursebasicinfo by code
			return coursebycode;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public List<Assignment> getAllAssignmentsOfCourse(String courseCode) {
		try {
			List<Assignment> allassignments = asgtdao
					.getAssignmentsByCourse(courseCode);// get all assignment
														// into the list
														// allassignments
			return allassignments;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	public Assignment getNthAssignmentOfCourse(String courseCode, int nth) {
		try {
			Assignment nthassignment = asgtdao.getNthAssignmentOfCourse(
					courseCode, nth);// get nthassignment by dao
			return nthassignment;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	public List<Exam> getAllExamsOfCourse(String courseCode) {
		try {
			List<Exam> allexams = examdao.getExamsByCourse(courseCode);
			return allexams;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public List<Exam> getSomeTypeExamOfCourse(String courseCode, int type) {
		try {
			List<Exam> typeexams = examdao.getTypeOfExamByCourse(courseCode,
					type);// get all typed exams into the list by dao
			return typeexams;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
