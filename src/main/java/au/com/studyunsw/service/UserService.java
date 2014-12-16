package au.com.studyunsw.service;

import au.com.studyunsw.model.*;

/**
 * Service managing users<br />
 * @author range-ubuntu
 *
 */
public interface UserService {
	/**
	 * User login<br />
	 * @param user user object
	 * @return if login successful
	 */
	boolean login(User user);
	
	/**
	 * User registration<br />
	 * @param user user object
	 * @return if registration successful
	 */
	boolean register(User user);
}
