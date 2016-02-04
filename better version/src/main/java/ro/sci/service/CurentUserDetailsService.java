package ro.sci.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


import ro.sci.domain.CurrentUser;
import ro.sci.domain.User;

@Service
public class CurentUserDetailsService implements UserDetailsService{

	@Autowired
	SqlService dao;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		User user;
		if (dao.getUserByEmail(email)!= null){
			user = dao.getUserByEmail(email);
			return new CurrentUser(user);
		}
			else throw new UsernameNotFoundException(String.format("User with email=%s was not found"));
		
	}
}
