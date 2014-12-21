package au.com.studyunsw.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import au.com.studyunsw.dao.UserDAO;
import au.com.studyunsw.model.User;
import au.com.studyunsw.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDAO userDao;

	public boolean login(User user) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean register(User user) {
		// TODO Auto-generated method stub
		return false;
	}

}
