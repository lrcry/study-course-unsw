package au.com.studyunsw.model;

import java.util.Date;

/**
 * Model of basic information of each course<br/>
 * Stored in database as a table called Course<br/>
 * @author range-ubuntu
 *
 */
public class CourseBasicInfo {
	private String courseCode; // course code e.g. COMP9024
	
	private String courseName; // course name e.g. Data Structures and Algorithms

	private String courseAuthority; // faculty which opens this course e.g. CSE
	
	private int semester; // semester in which the course is open (1, 2, summer)
	
	private int teachingPeriod; // teaching period (A, B)
	
	private String lecturerName; // name of the lecturer in charge (LiC)
	
	private String description; // description of the course
	
	private Date createAt; // when the course info come from the web to the db

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCourseCode() {
		return courseCode;
	}

	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getCourseAuthority() {
		return courseAuthority;
	}

	public void setCourseAuthority(String courseAuthority) {
		this.courseAuthority = courseAuthority;
	}

	public int getSemester() {
		return semester;
	}

	public void setSemester(int semester) {
		this.semester = semester;
	}

	public int getTeachingPeriod() {
		return teachingPeriod;
	}

	public void setTeachingPeriod(int teachingPeriod) {
		this.teachingPeriod = teachingPeriod;
	}

	public String getLecturerName() {
		return lecturerName;
	}

	public void setLecturerName(String lecturerName) {
		this.lecturerName = lecturerName;
	}

	public Date getCreateAt() {
		return createAt;
	}

	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}
	
}
