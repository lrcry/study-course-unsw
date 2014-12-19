package au.com.studyunsw.dao;

import java.util.*;

import au.com.studyunsw.model.*;

/**
 * DAO for users selecting courses<br/>
 * @author range-ubuntu
 *
 */
public interface UserCourseDAO {
	List<UserCourse> getAllUserCourse();
	
	List<UserCourse> getCoursesSelectedByUser(long userId);
	
	List<UserCourse> getUsersInvolvedInCourse(String courseCode);
	
	boolean addUserCourse(UserCourse userCourse);
	
	boolean updateUserCourse(UserCourse userCourse);
	
	boolean removeUserCourse(UserCourse userCourse);
}
