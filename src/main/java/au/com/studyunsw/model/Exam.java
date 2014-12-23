package au.com.studyunsw.model;

import java.util.Date;

/**
 * Model of each exam<br />
 * @author range-ubuntu
 *
 */
public class Exam {
	private long examId;
	
	private String courseCode; // reference to CourseBasicInfo
	
	private String materials;
	
	private Date startDate;
	
	private String examLocation;
	
	private int examType; // 1 for mid-term, 2 for final, 3 for exemption

	public int getExamType() {
		return examType;
	}

	public void setExamType(int examType) {
		this.examType = examType;
	}

	public long getExamId() {
		return examId;
	}

	public void setExamId(long examId) {
		this.examId = examId;
	}

	public String getCourse() {
		return courseCode;
	}

	public void setCourse(String courseCode) {
		this.courseCode = courseCode;
	}

	public String getMaterials() {
		return materials;
	}

	public void setMaterials(String materials) {
		this.materials = materials;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public String getExamLocation() {
		return examLocation;
	}

	public void setExamLocation(String examLocation) {
		this.examLocation = examLocation;
	}
}
