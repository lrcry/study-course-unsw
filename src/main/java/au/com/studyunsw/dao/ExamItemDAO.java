package au.com.studyunsw.dao;

import java.util.List;

import au.com.studyunsw.model.timelineitem.ExamItem;

/**
 * DAO for exam items in a time line<br/>
 * 
 * @author range-ubuntu
 * 
 */
public interface ExamItemDAO extends TimeLineItemDAO {
	void insertExamItem(ExamItem item);

	void updateExamItem(ExamItem item);
	
	void removeExamItem(ExamItem item);
	
	void insertExamItemBatch(List<ExamItem> items);
}
