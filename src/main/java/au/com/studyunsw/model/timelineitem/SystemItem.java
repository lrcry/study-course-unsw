package au.com.studyunsw.model.timelineitem;

/**
 * Model of system created items<br/>
 * 
 * @author range-ubuntu
 *
 */
public class SystemItem extends TimeLineItem {
	private String courseCode;

	public String getCourse() {
		return courseCode;
	}

	public void setCourse(String courseCode) {
		this.courseCode = courseCode;
	}
}
