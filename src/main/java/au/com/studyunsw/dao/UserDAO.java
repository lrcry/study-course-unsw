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
	List<User> getUsersByName(String userName);

	/**
	 * Create a new user<br />
	 * 
	 * @param user
	 *            user object
	 * @return if the user created successfully
	 */
	boolean insertNewUser(User user);

	/**
	 * Modify the information of a user<br />
	 * 
	 * @param user
	 *            user object
	 * @return if the user modified successfully
	 */
	boolean updateExistUser(User user);

	/**
	 * Remove a user<br />
	 * 
	 * @param user
	 *            user object
	 * @return if the user removed successfully
	 */
	boolean removeUser(User user);

	/**
	 * Clear all user in the database<br />
	 * 
	 * @return if the user cleared successfully
	 */
	boolean removeAllUser();

	/**
	 * Remove a user by its ID<br />
	 * 
	 * @param userId
	 *            user ID
	 * @return if the user removed successfully
	 */
	boolean removeUserById(long userId);

	/**
	 * Remove users which have the name<br />
	 * 
	 * @param userName
	 *            user name
	 * @return if the user removed successfully
	 */
	boolean removeUsersByName(String userName);
}
