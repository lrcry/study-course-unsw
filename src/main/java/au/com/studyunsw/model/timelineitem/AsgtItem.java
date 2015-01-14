package au.com.studyunsw.model.timelineitem;

/**
 * Models for assignment items<br/>
 * 
 * @author range
 *
 */
public class AsgtItem extends SystemItem {
	private long asgtId;

	public long getAssignment() {
		return asgtId;
	}

	public void setAssignment(long asgtId) {
		this.asgtId = asgtId;
	}
}
