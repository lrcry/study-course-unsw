package au.com.studyunsw.dao;

import java.util.*;

import au.com.studyunsw.model.*;

/**
 * DAO for users selecting courses<br/>
 * 
 * @author range-ubuntu
 * 
 */
public interface UserCourseDAO {
	List<UserCourse> getAllUserCourse();

	List<UserCourse> getCoursesSelectedByUser(long userId);

	List<UserCourse> getUsersInvolvedInCourse(String courseCode);

	void addUserCourse(UserCourse userCourse);

	void updateUserCourse(UserCourse userCourse);

	void removeUserCourse(UserCourse userCourse);
}
