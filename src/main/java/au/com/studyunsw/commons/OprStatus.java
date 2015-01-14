package au.com.studyunsw.commons;

/**
 * Operation status constants<br/>
 * Contains:<br/>
 * 1. Operation status code<br/>
 * 2. Operation status string for controllers<br/>
 * 
 * @author range-ubuntu
 *
 */
public class OprStatus {
	/* 1 defines successful operation. */
	public static final int SUCCESS = 1;

	/* Codes start with 9 indicates DAO and DB problems. */
	public static final int DAO_EXCEPTION = 900;

	/* Codes start with 8 indicates incorrect data. */
	public static final int DATA_OBJECT_NULL = 800;
	public static final int DATA_FK_CONSTRAINT_UNSATISFY = 801;
	public static final int COURSE_WITHOUT_ASGT_EXAM = 802;
	public static final int NO_SUCH_ASGT = 803;
	public static final int NO_SUCH_EXAM = 804;
	public static final int NO_ARRANGEMENT_IN_ALL_COURSES_AND_EXAMS = 805;
	public static final int NO_DUEDATE_IN_ITEM = 810;

	/* Codes start with 7 indicates user problem. */
	public static final int USER_NOT_LOGIN_YET = 700;
	public static final int USERNAME_NOT_EXIST = 701;
	public static final int USER_PASSWORD_INCORRECT = 702;
	public static final int USERNAME_ALREADY_EXIST = 703;
	public static final int USER_NO_COURSE_SELECTED = 704;
}
