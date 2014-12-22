package au.com.studyunsw.model;

/**
 * User-course model<br/>
 * @author range-ubuntu
 *
 */
public class UserCourse {
	private long userId;
	
	private String courseCode;

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getCourseCode() {
		return courseCode;
	}

	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}
}
