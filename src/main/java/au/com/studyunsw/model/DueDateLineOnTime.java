package au.com.studyunsw.model;

import java.util.Date;

/**
 * Model of due date time line information<br />
 * @author range-ubuntu
 *
 */
public class DueDateLineOnTime {
	private long timeLineId; // time line ID
	
	private String timeLineName; // name given by the user (if saved to server)
	
	private long userId; // ID of user who owns the time line (if saved to server)
	
	private Date createAt; // create time of the timeline (if saved to server)

	public long getTimeLineId() {
		return timeLineId;
	}

	public void setTimeLineId(long timeLineId) {
		this.timeLineId = timeLineId;
	}

	public String getTimeLineName() {
		return timeLineName;
	}

	public void setTimeLineName(String timeLineName) {
		this.timeLineName = timeLineName;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public Date getCreateAt() {
		return createAt;
	}

	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}
}
