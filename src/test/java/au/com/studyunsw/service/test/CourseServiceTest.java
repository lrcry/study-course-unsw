package au.com.studyunsw.service.test;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import au.com.studyunsw.commons.ExamType;
import au.com.studyunsw.model.Assignment;
import au.com.studyunsw.model.CourseBasicInfo;
import au.com.studyunsw.model.Exam;
import au.com.studyunsw.service.CourseService;

public class CourseServiceTest {
	@Autowired
	private static CourseService cs;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				new String[] { "classpath:conf/spring.xml",
						"classpath:conf/spring-mybatis.xml" });

		cs = (CourseService) context.getBean("courseServiceImpl");
	}

	// @Test
	public void testGetAllCourse() {
		List<CourseBasicInfo> courses = cs.getAllCourse();
		assert (courses == null);
		for (CourseBasicInfo course : courses) {
			System.out.println(course.getCourseCode());
		}
	}

	// @Test
	public void testGetAllCourseBrief() {
		Map<String, String> csBrf = cs.getAllCourseBrief();
		assert (csBrf == null);
		for (Map.Entry<String, String> entry : csBrf.entrySet()) {
			System.out.println(entry.getKey() + ": " + entry.getValue());
		}
	}

//	@Test
	public void testGetCourseByCourseCode() {
		CourseBasicInfo course = cs.getCourseByCourseCode("COMP9311");
		if (course == null) {
			System.out.println("No such course");
			return;
		}
		System.out.println(course.getCourseName());
	}

//	@Test
	public void testGetAllAssignmentsOfCourse() {
		List<Assignment> asgts = cs.getAllAssignmentsOfCourse("COMP9311");
		if (asgts == null) {
			System.out.println("No asgt yet");
			return;
		}
		
		for (Assignment asgt : asgts) {
			System.out.println(asgt.getDescription());
		}
	}

//	 @Test
	public void testGetNthAssignmentOfCourse() {
		Assignment asgt = cs.getNthAssignmentOfCourse("COMP9311", 2);
		
		Assert.assertFalse(asgt == null);
		
		System.out.println(asgt.getDescription());
	}

//	 @Test
	public void testGetAllExamsOfCourse() {
		List<Exam> es = cs.getAllExamsOfCourse("COMP9311");
		
		Assert.assertFalse(es == null);
		
		for (Exam e : es) {
			System.out.println(e.getStartDate() + ": " + e.getExamType());
		}
	}

//	 @Test
	public void testGetSomeTypeExamOfCourse() {
		List<Exam> es = cs.getSomeTypeExamOfCourse("COMP9311", ExamType.FINAL);
		Assert.assertFalse(es == null);
		
		System.out.println(es == null);
		
		for (Exam e : es) {
			System.out.println(e.getMaterials() + ": " + e.getStartDate());
		}
	 }

}
