package ro.sci.services;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import ro.sci.BitwireApplication;
import ro.sci.domain.User;
import ro.sci.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = BitwireApplication.class)
@WebAppConfiguration
public class UserServicetTest {
	
	@Autowired
	private UserService service;
	
	@After
	public void tearDown(){
		for (User user:service.listAll()){
			service.delete(user.getId());
		}
	}
	
	@Test
	public void testSaveNewUser(){
		User user = new User();
		user.setEmail("popa");
		user.setPassword("alex");
		User savedUser = service.saveUser(user);
		Assert.assertEquals("popa",savedUser.getEmail());
		Assert.assertEquals("alex", savedUser.getPassword());
	}
	@Test (expected = IllegalArgumentException.class)
	public void testSaveUsersWithIdenticalEmail(){
		User user = new User();
		user.setEmail("popa");
		user.setPassword("alex");
		User savedUser = service.saveUser(user);
		User savedUser2 = service.saveUser(user);
		
	}
	@Test (expected = NullPointerException.class)
	public void testSaveUserWithNoPassword(){
		User user = new User();
		user.setEmail("popa");
		user.setPassword("    ");
		User savedUser = service.saveUser(user);
		Assert.assertEquals("popa",savedUser.getEmail());
		
	}
	@Test (expected = NullPointerException.class)
	public void testSaveUserWithNoEmail(){
		User user = new User();
		user.setEmail("");
		user.setPassword("sdada");
		User savedUser = service.saveUser(user);
		Assert.assertEquals("sdada",savedUser.getPassword());
		
	}
}
