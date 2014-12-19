package au.com.studyunsw.deprecated;

import java.util.Date;

/**
 * Model of each item in a due date line<br />
 * @author range-ubuntu
 *
 */
public class TimeLineItem_D {
	private long itemId; // pk
	
	private long timeLineId; // reference to timeLineId in DueDateLineOnTime
	
	private String courseCode; // reference to courseCode in CourseBasicInfo
	
	private long assignmentId; // reference to counterpart in Assignment
	
	private long examId; // reference to counterpart in Exam
	
	private String description; // description of the item
	
	private Date createAt;
	
	private Date dueDate; // for asgts, dueDate=endDate; for exams, dueDate=startDate

	public long getItemId() {
		return itemId;
	}

	public void setItemId(long itemId) {
		this.itemId = itemId;
	}

	public long getTimeLineId() {
		return timeLineId;
	}

	public void setTimeLineId(long timeLineId) {
		this.timeLineId = timeLineId;
	}

	public String getCourseCode() {
		return courseCode;
	}

	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}

	public long getAssignmentId() {
		return assignmentId;
	}

	public void setAssignmentId(long assignmentId) {
		this.assignmentId = assignmentId;
	}

	public long getExamId() {
		return examId;
	}

	public void setExamId(long examId) {
		this.examId = examId;
	}

	public Date getCreateAt() {
		return createAt;
	}

	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
