package au.com.studyunsw.dao.test;

import static org.junit.Assert.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import au.com.studyunsw.dao.TimeLineDAO;
import au.com.studyunsw.model.DueDateLineOnTime;
import au.com.studyunsw.model.timelineitem.TimeLineItem;
import au.com.studyunsw.model.timelineitem.UserItem;
import au.com.studyunsw.service.TimeLineService;

public class TimeLineServiceTest {
	@Autowired
	private static TimeLineService tlService;

	@Autowired
	private static TimeLineDAO tlDao;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				new String[] { "classpath:conf/spring.xml",
						"classpath:conf/spring-mybatis.xml" });

		tlService = (TimeLineService) context.getBean("timeLineServiceImpl");
		tlDao = (TimeLineDAO) context.getBean("timeLineDAO");
	}

	public void testUserItem() throws Exception {
		DueDateLineOnTime timeLine = tlDao.getLineById(4);
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");

		UserItem item = new UserItem();
		item.setTimeLine(timeLine.getTimeLineId());
		item.setDescription("Intersteller");
		item.setDueDate(format.parse("2014-11-11"));

		tlService.addItemToTimeLine(timeLine, item);
	}

	@Test
	public void testQuery() throws Exception {
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		long start = System.currentTimeMillis();
		List<DueDateLineOnTime> lines = tlService.getUserTimeLine(1);
		if (lines == null || lines.size() == 0) {
			throw new Exception("No lines at all!");
		}

		DueDateLineOnTime line = lines.get(0);
		System.out.println(line.getTimeLineId());
		List<TimeLineItem> items = tlService.getItemsFromTimeLine(line
				.getTimeLineId());
		long end = System.currentTimeMillis();
		for (TimeLineItem item : items) {
			System.out.println(item.getTimeLine() + " "
					+ item.getDescription() + " " + format.format(item.getDueDate()));
		}
		
		System.out.println(end - start + "ms");
	}

	public void testInsertItem() {
		DueDateLineOnTime timeLine = new DueDateLineOnTime();
		timeLine.setTimeLineName("My First Time Line");
		timeLine.setUserId(1);

		tlService.createNewTimeLine(timeLine);
		List<DueDateLineOnTime> lines = tlDao.getLineByUser(1);

		if (lines != null && lines.size() > 0) {
			timeLine.setTimeLineId(lines.get(0).getTimeLineId());
			System.out.println(tlService.addSystemItemToTimeLine(timeLine));
		}

	}

}
