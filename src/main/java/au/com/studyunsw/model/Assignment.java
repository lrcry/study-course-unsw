package au.com.studyunsw.model;

import java.util.Date;

/**
 * Model of each assignment<br/>
 * 
 * @author range-ubuntu
 * 
 */
public class Assignment {
	private long assignmentId;

	private String courseCode; // reference to CourseBasicInfo

	private String description;

	private Date startDate;

	private Date endDate;

	private String websiteUrl; // moodle, or WebCMS2 url

	private int nth; // nth assignment of this course

	public long getAssignmentId() {
		return assignmentId;
	}

	public void setAssignmentId(long assignmentId) {
		this.assignmentId = assignmentId;
	}

	public String getCourse() {
		return courseCode;
	}

	public void setCourse(String courseCode) {
		this.courseCode = courseCode;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getUrl() {
		return websiteUrl;
	}

	public void setUrl(String websiteUrl) {
		this.websiteUrl = websiteUrl;
	}

	public int getNth() {
		return nth;
	}

	public void setNth(int nth) {
		this.nth = nth;
	}
}
