package au.com.studyunsw.service.test;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import au.com.studyunsw.dao.TimeLineDAO;
import au.com.studyunsw.model.User;
import au.com.studyunsw.service.TimeLineService;
import au.com.studyunsw.service.UserService;
import au.com.studyunsw.service.impl.UserServiceImpl;

public class UserServiceTest {
	@Autowired
	private static UserService us;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				new String[] { "classpath:conf/spring.xml",
						"classpath:conf/spring-mybatis.xml" });

		us = (UserService) context.getBean("userServiceImpl");
	}

	@Test
	public void testLogin() {
		User user = new User();
		user.setUsername("range");
		user.setPassword("admin1009");
		
		int sts = us.login(user);
		System.out.println(sts);
	}

//	@Test
	public void testRegister() {
		User user = new User();
		user.setUsername("range");
		user.setPassword("admin1009");
		
		int sts = us.register(user);
		System.out.println(sts);
	}

}
