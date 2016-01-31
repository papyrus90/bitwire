package ro.sci.service;

import java.util.Collection;




import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import ro.sci.dao.UserDao;
import ro.sci.domain.User;


@Service
public class UserService {

	
	@Autowired
	private UserDao userDao;
	
	
	public User saveUser( User user){
		if (userDao.findByEmail(user.getEmail())){
			throw new IllegalArgumentException("not a valid email");
		}
		if(!StringUtils.hasText(user.getEmail())||!StringUtils.hasText(user.getPassword())){
			throw new NullPointerException("not a valid email or password");
		}	
		return userDao.update(user);
	}
	
	public Collection<User>listAll(){
		return userDao.getAll();
	}
	
	public User findById(long id) {
		User user = userDao.findById(id);
		return user;
	}
	
	public boolean delete(long id) {
		User user = userDao.findById(id);
		if (user == null) {
			return false;
		} else {
			return userDao.delete(user);
		}
	}
	
}
