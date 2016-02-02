package ro.sci.dao;

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

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = BitwireApplication.class)
@WebAppConfiguration
public class SqlDaoTest {
	
	@Autowired
	 SqlDao dao;
	
	@After
	public void tearDown(){
		for (User user:dao.findAll()){
			dao.delete(user.getId());
		}
	}
	
	
	@Test
	public void testSaveNewUser(){
		User user = new User();
		user.setEmail("popa");
		user.setFirstName("alex");
		user.setLastName("ion");
		user.setPassword("password");
		User saved =  dao.save(user);
		
		Assert.assertEquals("popa",saved.getEmail());
		Assert.assertEquals("password", saved.getPassword());
		
	}
	
	@Test
	public void findByEmail(){
		
		
		User user = new User();
		user.setEmail("popaa");
		user.setFirstName("alexaaaaaaaaaaaamdri");
		user.setLastName("ion");
		user.setPassword("password");
		dao.save(user);
		
		User found = dao.findOneByEmail("popaa");
		
		
		Assert.assertEquals(found.getFirstName(),user.getFirstName());
		
	}
}	
