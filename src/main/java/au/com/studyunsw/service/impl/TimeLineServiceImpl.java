package au.com.studyunsw.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import au.com.studyunsw.model.DueDateLineOnTime;
import au.com.studyunsw.model.timelineitem.TimeLineItem;
import au.com.studyunsw.model.timelineitem.UserItem;
import au.com.studyunsw.service.TimeLineService;

@Service
public class TimeLineServiceImpl implements TimeLineService {

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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TimeLineItem> getAllAutoGenItemsFromLine(long timeLineId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TimeLineItem> getAllUserItemsFromLine(long timeLineId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<DueDateLineOnTime> getUserTimeLine(long userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int createNewTimeLine(DueDateLineOnTime timeLine) {
		// TODO Auto-generated method stub
		return 0;
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
	public int addSystemItemToTimeLine(DueDateLineOnTime timeLine) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int addItemToTimeLine(DueDateLineOnTime timeLine, UserItem item) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateItemOfTimeLine(DueDateLineOnTime timeLine,
			TimeLineItem item) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean removeItemFromTimeLine(DueDateLineOnTime timeLine,
			TimeLineItem item) {
		// TODO Auto-generated method stub
		return false;
	}
}
