package au.com.studyunsw.model.timelineitem;

public class ExamItem extends SystemItem {
	private long examId;

	public long getExam() {
		return examId;
	}

	public void setExam(long examId) {
		this.examId = examId;
	}
}
