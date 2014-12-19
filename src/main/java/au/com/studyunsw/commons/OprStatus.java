package au.com.studyunsw.commons;

/**
 * Operation status constants<br/>
 * Contains:<br/>
 * 1. Operation status code<br/>
 * 2. Operation status string for controllers<br/>
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
	
	/* Codes start with 7 indicates user login problem. */
	public static final int USER_NOT_LOGIN_YET = 700;
}
