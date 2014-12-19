package au.com.studyunsw.model.timelineitem;

/**
 * Model of system created items<br/>
 * @author range-ubuntu
 *
 */
public class SystemItem extends TimeLineItem {
	private String courseCode;

	public String getCourseCode() {
		return courseCode;
	}

	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}
}
