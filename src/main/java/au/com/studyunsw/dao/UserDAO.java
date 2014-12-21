package au.com.studyunsw.dao;

import java.util.*;

import au.com.studyunsw.model.User;

/**
 * DAO of User and user table<br />
 * 
 * @author range-ubuntu
 * 
 */
public interface UserDAO {
	/**
	 * Retrieve all users in the database<br />
	 * 
	 * @return user list
	 */
	List<User> getAllUsers();

	/**
	 * Get the user by its userId<br />
	 * 
	 * @param userId
	 *            user ID
	 * @return user object
	 */
	User getUserById(long userId);

	/**
	 * Retrieve all users that have the name<br />
	 * 
	 * @param userName
	 *            user name
	 * @return user list
	 */
	User getUserByName(String userName); // username is a unique key

	/**
	 * Create a new user<br />
	 * 
	 * @param user
	 *            user object
	 */
	void insertNewUser(User user);

	/**
	 * Modify the information of a user<br />
	 * 
	 * @param user
	 *            user object
	 */
	void updateExistUser(User user);

	/**
	 * Remove a user<br />
	 * 
	 * @param user
	 *            user object
	 */
	void removeUser(User user);

	/**
	 * Clear all user in the database<br />
	 */
	void removeAllUser();

	/**
	 * Remove users which have the name<br />
	 * 
	 * @param userName
	 *            user name
	 */
	void removeUserByName(String userName);
}
