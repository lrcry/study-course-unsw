package au.com.studyunsw.dao.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import au.com.studyunsw.dao.UserDAO;
import au.com.studyunsw.model.User;
import au.com.studyunsw.service.UserService;

public class UserDaoTest {
	@Autowired
	private static UserService userService;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				new String[] {
						"classpath:conf/spring.xml",
						"classpath:conf/spring-mybatis.xml"
				});
		
		userService = (UserService) context.getBean("userServiceImpl");
	}

	@Test
	public void test() {
		
		
		User user = new User();
		user.setUsername("testname");
		user.setPassword("testpswd");
		user.setCreateAt(new Date());
		userService.register(user);
		
		userService.login(user);
	}

}
