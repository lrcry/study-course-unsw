package au.com.studyunsw.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import au.com.studyunsw.commons.OprStatus;
import au.com.studyunsw.dao.AsgtDAO;
import au.com.studyunsw.dao.AsgtItemDAO;
import au.com.studyunsw.dao.ExamDAO;
import au.com.studyunsw.dao.ExamItemDAO;
import au.com.studyunsw.dao.TimeLineDAO;
import au.com.studyunsw.dao.TimeLineItemDAO;
import au.com.studyunsw.dao.UserCourseDAO;
import au.com.studyunsw.model.Assignment;
import au.com.studyunsw.model.DueDateLineOnTime;
import au.com.studyunsw.model.Exam;
import au.com.studyunsw.model.UserCourse;
import au.com.studyunsw.model.comparator.TimeLineComparator;
import au.com.studyunsw.model.comparator.TimeLineItemComparator;
import au.com.studyunsw.model.timelineitem.AsgtItem;
import au.com.studyunsw.model.timelineitem.ExamItem;
import au.com.studyunsw.model.timelineitem.TimeLineItem;
import au.com.studyunsw.model.timelineitem.UserItem;
import au.com.studyunsw.service.TimeLineService;

@Service
public class TimeLineServiceImpl implements TimeLineService {
	@Autowired
	private TimeLineDAO lineDao;
	
	@Autowired
	private TimeLineItemDAO itemDao;
	
	@Autowired
	private AsgtItemDAO asgtDao;
	
	@Autowired
	private ExamItemDAO examDao;
	
	@Autowired
	private AsgtDAO aDao;
	
	@Autowired
	private ExamDAO eDao;
	
	@Autowired
	private UserCourseDAO userCourseDao;

	@Override
	public List<DueDateLineOnTime> getAllTimeLine() {
		try {
			List<DueDateLineOnTime> lines = lineDao.getAllDueDateLine();
			return lines;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public DueDateLineOnTime getTimeLineById(long timeLineId) {
		try {
			DueDateLineOnTime line = lineDao.getLineById(timeLineId);
			return line;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
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
		List<TimeLineItem> systemItem = new ArrayList<>();
		long timeLineId = timeLine.getTimeLineId();

		try {
			List<AsgtItem> asgtItems = new ArrayList<>();
			List<ExamItem> examItems = new ArrayList<>();

			// clear before add or update
			systemItem = asgtDao.getItemsInTimeLine(timeLineId);
			if (systemItem != null && systemItem.size() > 0) {
				asgtDao.removeItemInTimeLine(timeLineId);
			}

			systemItem = examDao.getItemsInTimeLine(timeLineId);
			if (systemItem != null && systemItem.size() > 0) {
				examDao.removeItemInTimeLine(timeLineId);
			}

			// get user selected course
			long userId = timeLine.getUserId();
			if (userId == 0) {
				return OprStatus.USER_NOT_LOGIN_YET;
			}

			List<UserCourse> userCourses = userCourseDao
					.getCoursesSelectedByUser(userId);
			
			if (userCourses == null || userCourses.size() == 0) {
				return OprStatus.USER_NO_COURSE_SELECTED;
			}

			// get information of assignments and exams
			// TODO performance problem needs to be solved here
			for (UserCourse uCourse : userCourses) {
				String courseCode = uCourse.getCourse();
				List<Assignment> asgts = aDao
						.getAssignmentsByCourse(courseCode);
				List<Exam> exams = eDao.getExamsByCourse(courseCode);

				if (asgts != null && asgts.size() > 0) {
					for (Assignment asgt : asgts) {

						AsgtItem asgtItem = new AsgtItem();
						asgtItem.setCourse(courseCode);
						asgtItem.setAssignment(asgt.getAssignmentId());
						asgtItem.setTimeLine(timeLineId);
						asgtItem.setDueDate(asgt.getEndDate());

						// build the item description
						StringBuilder asgtItemDescriptionBuilder = new StringBuilder(
								courseCode);
						asgtItemDescriptionBuilder.append(" assignment ");
						asgtItemDescriptionBuilder.append(asgt.getNth());
						asgtItem.setDescription(asgtItemDescriptionBuilder
								.toString());
						asgtItems.add(asgtItem);
					}
				}

				if (exams != null && exams.size() > 0) {
					for (Exam exam : exams) {
						ExamItem examItem = new ExamItem();
						examItem.setCourse(courseCode);
						examItem.setExam(exam.getExamId());
						examItem.setTimeLine(timeLineId);
						examItem.setDueDate(exam.getStartDate());

						StringBuilder examItemDescriptionBuilder = new StringBuilder(
								courseCode);
						examItemDescriptionBuilder.append(" ");
						int examType = exam.getExamType();
						switch (examType) {
						case 1:
							examItemDescriptionBuilder.append("mid-term exam");
							break;
						case 2:
							examItemDescriptionBuilder.append("final exam");
							break;
						case 3:
							examItemDescriptionBuilder.append("exemption exam");
							break;
						default:
							break;
						}
						examItem.setDescription(examItemDescriptionBuilder
								.toString());
						examItems.add(examItem);
					}
				}
			}
			
			// if no arrangement yet in all the courses
			if (asgtItems.size() == 0 && examItems.size() == 0) { 
				return OprStatus.NO_ARRANGEMENT_IN_ALL_COURSES_AND_EXAMS;
			}
			
			asgtDao.insertAsgtItemBatch(asgtItems);
			examDao.insertExamItemBatch(examItems);
		} catch (Exception e) {
			e.printStackTrace();
			return OprStatus.DAO_EXCEPTION;
		}

		return OprStatus.SUCCESS;
	}

	@Override
	public int addItemToTimeLine(DueDateLineOnTime timeLine, UserItem item) {
		if (timeLine.getUserId() == 0) {
			return OprStatus.USER_NOT_LOGIN_YET;
		}
		
		if (item.getDueDate() == null) {
			return OprStatus.NO_DUEDATE_IN_ITEM;
		}
		
		long timeLineId = timeLine.getTimeLineId();
		item.setTimeLine(timeLineId);
		
		try {
			itemDao.insertItem(item);
			lineDao.updateLine(timeLine);
		} catch (Exception e) {
			e.printStackTrace();
			return OprStatus.DAO_EXCEPTION;
		}
		
		return OprStatus.SUCCESS;
	}

	@Override
	public int updateItemOfTimeLine(DueDateLineOnTime timeLine,
			TimeLineItem item) {
		if (timeLine.getUserId() == 0) {
			return OprStatus.USER_NOT_LOGIN_YET;
		}
		
		try {
			itemDao.updateItem(item);
			lineDao.updateLine(timeLine);
		} catch (Exception e) {
			e.printStackTrace();
			return OprStatus.DAO_EXCEPTION;
		}
		
		return OprStatus.SUCCESS;
	}

	@Override
	public int removeItemFromTimeLine(DueDateLineOnTime timeLine,
			TimeLineItem item) {
		if (timeLine.getUserId() == 0) {
			return OprStatus.USER_NOT_LOGIN_YET;
		}
		
		try {
			itemDao.removeItem(item);
			lineDao.updateLine(timeLine);
		} catch (Exception e) {
			e.printStackTrace();
			return OprStatus.DAO_EXCEPTION;
		}
		
		return OprStatus.SUCCESS;
	}
}
