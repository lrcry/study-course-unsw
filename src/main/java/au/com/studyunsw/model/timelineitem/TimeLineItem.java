package au.com.studyunsw.model.timelineitem;

import java.util.*;

/**
 * Base model of time line items<br/>
 * 
 * @author range-ubuntu
 *
 */
public class TimeLineItem {
	private long itemId;
	
	private long timeLineId;
	
	private String description;
	
	private Date createAt;
	
	private Date dueDate;

	public long getItemId() {
		return itemId;
	}

	public void setItemId(long itemId) {
		this.itemId = itemId;
	}

	public long getTimeLine() {
		return timeLineId;
	}

	public void setTimeLine(long timeLineId) {
		this.timeLineId = timeLineId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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
}
