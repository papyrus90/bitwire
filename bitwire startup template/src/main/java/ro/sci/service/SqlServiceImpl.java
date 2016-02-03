package ro.sci.service;

import java.util.Calendar;
import java.util.Collection;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import ro.sci.dao.SqlDao;
import ro.sci.domain.User;
import ro.sci.domain.UserCreateForm;

@Service
public class SqlServiceImpl implements SqlService {
	
	@Autowired
	SqlDao dao;
	
	public User saveUser(User user){
		User saved =  dao.save(user);
		return saved;
	}
	
	@Override
	public User getUserById(long id) throws NullPointerException {
		return dao.findOne(id);
	}

	@Override
	public User getUserByEmail(String email) throws NullPointerException {
		return dao.findOneByEmail(email);
	}

	@Override
	public Collection<User> getAllUsers() {
		return (Collection<User>) dao.findAll();
		
	}

	@Override
	public User create(UserCreateForm form) {
		User user = new User();
		Calendar cal = Calendar.getInstance();
		Date utilDate = cal.getTime();
		java.sql.Date sqlDate = (java.sql.Date) new Date(utilDate.getTime());
		user.setEmail(form.getEmail());
		user.setFirstName(form.getFirstName());
		user.setLastName(form.getLastName());
		user.setPassword(new BCryptPasswordEncoder().encode(form.getPassword()));
		
		return dao.save(user);
	}
}
