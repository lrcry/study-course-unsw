package au.com.studyunsw.model;

/**
 * User-course model<br/>
 * @author range-ubuntu
 *
 */
public class UserCourse {
	private long userId;
	
	private String courseCode;

	public long getUser() {
		return userId;
	}

	public void setUser(long userId) {
		this.userId = userId;
	}

	public String getCourse() {
		return courseCode;
	}

	public void setCourse(String courseCode) {
		this.courseCode = courseCode;
	}
}
