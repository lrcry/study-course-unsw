package au.com.studyunsw.dao;

import au.com.studyunsw.model.timelineitem.ExamItem;

/**
 * DAO for exam items in a time line<br/>
 * @author range-ubuntu
 *
 */
public interface ExamItemDAO extends TimeLineItemDAO {
	boolean insertExamItem(ExamItem item);
	
	boolean updateExamItem(ExamItem item);
}
