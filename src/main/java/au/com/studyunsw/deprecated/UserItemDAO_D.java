package au.com.studyunsw.deprecated;

import au.com.studyunsw.dao.TimeLineItemDAO;
import au.com.studyunsw.model.timelineitem.UserItem;

public interface UserItemDAO_D extends TimeLineItemDAO {
	boolean insertUserItem(UserItem item);
	
	boolean updateUserItem(UserItem item);
	
	boolean removeUserItem(UserItem item);
}
