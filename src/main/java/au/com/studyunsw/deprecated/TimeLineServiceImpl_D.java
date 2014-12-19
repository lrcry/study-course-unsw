package au.com.studyunsw.deprecated;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import au.com.studyunsw.commons.OprStatus;
import au.com.studyunsw.dao.AsgtDAO;
import au.com.studyunsw.dao.ExamDAO;
import au.com.studyunsw.dao.TimeLineDAO;
import au.com.studyunsw.model.Assignment;
import au.com.studyunsw.model.DueDateLineOnTime;
import au.com.studyunsw.model.Exam;
import au.com.studyunsw.service.TimeLineService;

/*
@Service
public abstract class TimeLineServiceImpl_D implements TimeLineService {
	@Autowired
	private TimeLineItemDAO_D itemDao;
	private TimeLineDAO lineDao;
	private AsgtDAO asgtDao;
	private ExamDAO examDao;

	@Override
	public List<DueDateLineOnTime> getAllTimeLine() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DueDateLineOnTime getTimeLineById(long timeLineId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TimeLineItem_D> getAllItems() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TimeLineItem_D getItemById(long itemId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TimeLineItem_D> getItemsFromTimeLine(long timeLineId) {
		List<TimeLineItem_D> itemsInLine = new ArrayList<>();
		try {
			itemsInLine = itemDao.getItemsInTimeLine(timeLineId);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

		return itemsInLine;
	}

	@Override
	public List<DueDateLineOnTime> getUserTimeLine(long userId) {
		List<DueDateLineOnTime> userLine = new ArrayList<>();
		try {
			userLine = lineDao.getLineByUser(userId);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

		return userLine;
	}

	@Override
	public int createNewTimeLine(DueDateLineOnTime timeLine) {
		// check data null
		if (timeLine == null) {
			return OprStatus.DATA_OBJECT_NULL;
		}

		// check logging in
		if (timeLine.getUserId() == 0) {
			return OprStatus.USER_NOT_LOGIN_YET;
		}

		// check time line name, empty string if null
		if (timeLine.getTimeLineName() == null) {
			timeLine.setTimeLineName("");
		}

		timeLine.setCreateAt(new Date());

		try {
			boolean isCreated = lineDao.insertNewLine(timeLine);
			if (!isCreated) {
				return OprStatus.DAO_EXCEPTION;
			}
		} catch (Exception e) {
			// this false indicates server DAO exception
			e.printStackTrace();
			return OprStatus.DAO_EXCEPTION;
		}

		return OprStatus.SUCCESS;
	}

	@Override
	public boolean modifyTimeLine(DueDateLineOnTime timeLine) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeTimeLine(DueDateLineOnTime timeLine) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	@Deprecated
	public int addItemToTimeLine(DueDateLineOnTime timeLine, TimeLineItem_D item) {
		if (timeLine.getUserId() == 0) {
			return OprStatus.USER_NOT_LOGIN_YET;
		}

		if (timeLine.getTimeLineName() == null) {
			timeLine.setTimeLineName("");
		}
		// end of checking timeLine object

		if (item.getTimeLineId() != timeLine.getTimeLineId()) {
			return OprStatus.DATA_FK_CONSTRAINT_UNSATISFY;
		}
		
		item.setTimeLineId(timeLine.getTimeLineId());

		// an item can only be an assignment, an exam or an other thing
		if (item.getCourseCode() != null) { // item about course
			if (item.getAssignmentId() == 0 && item.getExamId() == 0) {
				// neither asgt nor exam
				return OprStatus.COURSE_WITHOUT_ASGT_EXAM;
			}

			
			item.setCreateAt(new Date());

			Date dueDate = null;
			try {
				if (item.getAssignmentId() != 0) {
					Assignment asgt = asgtDao.getAssignmentById(item
							.getAssignmentId());
					if (asgt == null) { // no such assignment
						return OprStatus.NO_SUCH_ASGT;
					}
					dueDate = asgt.getEndDate();
					item.setExamId(0); 
				} else if (item.getExamId() != 0) {
					Exam exam = examDao.getExamId(item.getExamId());
					if (exam == null) { // no such exam
						return OprStatus.NO_SUCH_EXAM;
					}
					dueDate = exam.getStartDate();
					item.setAssignmentId(0); 
				}
			} catch (Exception e) {
				e.printStackTrace();
				return OprStatus.DAO_EXCEPTION;
			}
			
			item.setDueDate(dueDate);
		} else { // item of others
			item.setAssignmentId(0); // will be handled when saving to db
			item.setExamId(0);
			item.setCourseCode("");
		}
		
		// once the item added, the date is changed to the one it added
		timeLine.setCreateAt(new Date());
		item.setCreateAt(new Date());
		
		try {
			itemDao.insertItem(item);
			lineDao.udpateLine(timeLine);
		} catch (Exception e) {
			e.printStackTrace();
			return OprStatus.DAO_EXCEPTION;
		}
		
		return OprStatus.SUCCESS;
	}

	@Override
	public int updateItemOfTimeLine(DueDateLineOnTime timeLine,
			TimeLineItem_D item) {
		if (timeLine.getUserId() == 0) {
			return OprStatus.USER_NOT_LOGIN_YET;
		}
		
		
		
		return OprStatus.SUCCESS;
	}

	@Override
	public boolean removeItemFromTimeLine(DueDateLineOnTime timeLine,
			TimeLineItem_D item) {
		// TODO Auto-generated method stub
		return false;
	}

}*/
