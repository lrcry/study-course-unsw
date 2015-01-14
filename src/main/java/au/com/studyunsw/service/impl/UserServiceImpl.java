package au.com.studyunsw.service.impl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import au.com.studyunsw.cryption.utils.InfoEncoder;
import au.com.studyunsw.dao.UserDAO;
import au.com.studyunsw.model.User;
import au.com.studyunsw.service.UserService;
import au.com.studyunsw.commons.OprStatus;

/**
 * Implementor of user service<br/>
 * 
 * @author Liren Wang
 *
 */
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDAO userDao;

	private static final DateFormat dateFormat = new SimpleDateFormat(
			"yyyy-MM-dd");

	public int login(User user) {
		// System.out.println(userDao == null);
		// OprStatus status = new OprStatus();
		User userdb = null;
		try {
			userdb = userDao.getUserByName(user.getUsername());// get the saved
																// user object
																// in database
		} catch (Exception e) {
			e.printStackTrace();
			return OprStatus.DAO_EXCEPTION;
		}

		if (userdb == null) {
			return OprStatus.USERNAME_NOT_EXIST;// if the username in database
												// do not exist, return username
												// not exist
		}
		// InfoEncoder encoder = new InfoEncoder();
		String md5password = InfoEncoder.md5Encode(user.getPassword());// encode
																		// input
																		// password
																		// in
																		// md5
		String sha1password = InfoEncoder.sha1Encode(md5password);// encode
																	// encoded
																	// input
																	// password
																	// in sta1
		String userpassword = userdb.getPassword();// get the saved encoded user
													// password
		if (userpassword.equals(sha1password)) {
			return OprStatus.SUCCESS;
		}// compare the encoded passwords, if equals return 1, otherwise return
			// 0.

		return OprStatus.USER_PASSWORD_INCORRECT;
	}

	public int register(User user) {
		// OprStatus status = new OprStatus();
		User userdb = null;
		try {
			userdb = userDao.getUserByName(user.getUsername());// get the saved
																// user object
																// in database
		} catch (Exception e) {
			e.printStackTrace();
			return OprStatus.DAO_EXCEPTION;
		}
		if (userdb != null) {
			return OprStatus.USERNAME_ALREADY_EXIST;// if the username in
													// database exist, return
													// username already exist
		}
		// InfoEncoder encoder = new InfoEncoder;
		String md5password = InfoEncoder.md5Encode(user.getPassword());// encode
																		// input
																		// password
																		// in
																		// md5
		String sha1password = InfoEncoder.sha1Encode(md5password);// encode
																	// encoded
																	// input
																	// password
																	// in sta1
		user.setPassword(sha1password);// reset users password to encoded one

		user.setCreateAt(new Date());
		Date lastLoginAt = null;

		try {
			lastLoginAt = dateFormat.parse("1970-1-1");
		} catch (Exception e) {
			System.out.println("date");
			return OprStatus.DAO_EXCEPTION;
		}
		user.setLastLoginAt(lastLoginAt);
		try {
			userDao.insertNewUser(user);// insert it into database

		} catch (Exception e) {
			e.printStackTrace();
			return OprStatus.DAO_EXCEPTION;
		}
		return OprStatus.SUCCESS;
	}

}
