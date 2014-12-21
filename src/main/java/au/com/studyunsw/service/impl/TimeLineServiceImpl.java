package au.com.studyunsw.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import au.com.studyunsw.commons.OprStatus;
import au.com.studyunsw.dao.AsgtItemDAO;
import au.com.studyunsw.dao.ExamItemDAO;
import au.com.studyunsw.dao.TimeLineDAO;
import au.com.studyunsw.dao.TimeLineItemDAO;
import au.com.studyunsw.model.DueDateLineOnTime;
import au.com.studyunsw.model.comparator.TimeLineComparator;
import au.com.studyunsw.model.comparator.TimeLineItemComparator;
import au.com.studyunsw.model.timelineitem.TimeLineItem;
import au.com.studyunsw.model.timelineitem.UserItem;
import au.com.studyunsw.service.TimeLineService;

@Service
public class TimeLineServiceImpl implements TimeLineService {
	@Autowired
	private TimeLineDAO lineDao;
	private TimeLineItemDAO itemDao;
	private AsgtItemDAO asgtDao;
	private ExamItemDAO examDao;

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
	public List<TimeLineItem> getAllItems() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TimeLineItem getItemById(long itemId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TimeLineItem> getItemsFromTimeLine(long timeLineId) {
		List<TimeLineItem> items = new ArrayList<>();
		try {
			// user items
			items = itemDao.getItemsInTimeLine(timeLineId);

			// system items
			items.addAll(asgtDao.getItemsInTimeLine(timeLineId));
			items.addAll(examDao.getItemsInTimeLine(timeLineId));

			// sort by due date in ascending order
			Collections.sort(items, new TimeLineItemComparator());
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

		return items;
	}

	@Override
	public List<TimeLineItem> getAllAutoGenItemsFromLine(long timeLineId) {
		List<TimeLineItem> systemItems = new ArrayList<>();
		try {
			systemItems = asgtDao.getItemsInTimeLine(timeLineId);
			systemItems.addAll(examDao.getItemsInTimeLine(timeLineId));
			Collections.sort(systemItems, new TimeLineItemComparator());
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

		return systemItems;
	}

	@Override
	public List<TimeLineItem> getAllUserItemsFromLine(long timeLineId) {
		List<TimeLineItem> userItems = new ArrayList<>();

		try {
			userItems = itemDao.getItemsInTimeLine(timeLineId);
			Collections.sort(userItems, new TimeLineItemComparator());
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

		return userItems;
	}

	@Override
	public List<DueDateLineOnTime> getUserTimeLine(long userId) {
		List<DueDateLineOnTime> lines = new ArrayList<>();
		try {
			lines = lineDao.getLineByUser(userId);
			Collections.sort(lines, new TimeLineComparator());
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

		return lines;
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
			lineDao.insertNewLine(timeLine);

		} catch (Exception e) {
			// this false indicates server DAO exception
			e.printStackTrace();
			return OprStatus.DAO_EXCEPTION;
		}

		return OprStatus.SUCCESS;
	}

	@Override
	public int modifyTimeLine(DueDateLineOnTime timeLine) {
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
			lineDao.updateLine(timeLine);

		} catch (Exception e) {
			// this false indicates server DAO exception
			e.printStackTrace();
			return OprStatus.DAO_EXCEPTION;
		}

		return OprStatus.SUCCESS;
	}

	@Override
	public int removeTimeLine(DueDateLineOnTime timeLine) {
		// / check data null
		if (timeLine == null) {
			return OprStatus.DATA_OBJECT_NULL;
		}

		// check logging in
		if (timeLine.getUserId() == 0) {
			return OprStatus.USER_NOT_LOGIN_YET;
		}

		// remove all the items of the time line
		try {
			itemDao.removeItemInTimeLine(timeLine.getTimeLineId());
		} catch (Exception e) {
			e.printStackTrace();
			return OprStatus.DAO_EXCEPTION;
		}

		// remove the time line itself
		try {
			lineDao.removeLine(timeLine);
		} catch (Exception e) {
			// this false indicates server DAO exception
			e.printStackTrace();
			return OprStatus.DAO_EXCEPTION;
		}

		return OprStatus.SUCCESS;
	}

	@Override
	public int addSystemItemToTimeLine(DueDateLineOnTime timeLine) {

		return OprStatus.SUCCESS;
	}

	@Override
	public int addItemToTimeLine(DueDateLineOnTime timeLine, UserItem item) {
		// TODO Auto-generated method stub
		return OprStatus.SUCCESS;
	}

	@Override
	public int updateItemOfTimeLine(DueDateLineOnTime timeLine,
			TimeLineItem item) {
		// TODO Auto-generated method stub
		return OprStatus.SUCCESS;
	}

	@Override
	public int removeItemFromTimeLine(DueDateLineOnTime timeLine,
			TimeLineItem item) {
		// TODO Auto-generated method stub
		return OprStatus.SUCCESS;
	}

	@Override
	public int updateSystemItemOfTimeLine(DueDateLineOnTime timeLine,
			TimeLineItem item) {
		// TODO Auto-generated method stub
		return 0;
	}
}
