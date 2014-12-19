package au.com.studyunsw.model;

/**
 * User-course model<br/>
 * @author range-ubuntu
 *
 */
public class UserCourse {
	private long userId;
	
	private long courseCode;

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public long getCourseCode() {
		return courseCode;
	}

	public void setCourseCode(long courseCode) {
		this.courseCode = courseCode;
	}
}
