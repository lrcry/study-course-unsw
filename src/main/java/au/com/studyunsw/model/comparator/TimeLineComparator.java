package au.com.studyunsw.model.comparator;

import java.util.Comparator;

import au.com.studyunsw.model.DueDateLineOnTime;

/**
 * Implementor of the comparator making comparison of two time lines
 * 
 * @author range
 *
 */
public class TimeLineComparator implements Comparator<DueDateLineOnTime> {

	@Override
	public int compare(DueDateLineOnTime o1, DueDateLineOnTime o2) {
		// TODO Auto-generated method stub
		return o1.getCreateAt().compareTo(o2.getCreateAt());
	}

}
