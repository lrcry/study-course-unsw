package au.com.studyunsw.dao;

import au.com.studyunsw.model.timelineitem.AsgtItem;

/**
 * DAO for assignment items in a time line<br/>
 * @author range-ubuntu
 *
 */
public interface AsgtItemDAO extends TimeLineItemDAO {
	boolean insertAsgtItem(AsgtItem item);
	
	boolean updateAsgtItem(AsgtItem item);
}
