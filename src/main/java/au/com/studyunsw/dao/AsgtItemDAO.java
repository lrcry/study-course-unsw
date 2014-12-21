package au.com.studyunsw.dao;

import au.com.studyunsw.model.timelineitem.AsgtItem;

/**
 * DAO for assignment items in a time line<br/>
 * 
 * @author range-ubuntu
 * 
 */
public interface AsgtItemDAO extends TimeLineItemDAO {
	void insertAsgtItem(AsgtItem item);

	void updateAsgtItem(AsgtItem item);
}
