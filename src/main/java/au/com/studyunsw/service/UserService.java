package au.com.studyunsw.service;

import au.com.studyunsw.model.*;

/**
 * Service managing users<br />
 * 
 * @author range-ubuntu
 *
 */
public interface UserService {
	/**
	 * User login<br />
	 * 
	 * @param user
	 *            user object
	 * @return operation status code
	 */
	int login(User user);

	/**
	 * User registration<br />
	 * 
	 * @param user
	 *            user object
	 * @return operation status code
	 */
	int register(User user);
}
