package au.com.studyunsw.model.comparator;

import java.util.Comparator;

import au.com.studyunsw.model.timelineitem.TimeLineItem;

/**
 * Compare two items in a time line by their due dates<br/>
 * 
 * @author range-ubuntu
 *
 */
public class TimeLineItemComparator implements Comparator<TimeLineItem> {

	@Override
	public int compare(TimeLineItem o1, TimeLineItem o2) {
		return o1.getDueDate().compareTo(o2.getDueDate());
	}

}
