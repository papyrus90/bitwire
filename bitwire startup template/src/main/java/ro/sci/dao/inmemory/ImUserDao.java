package ro.sci.dao.inmemory;

import java.util.Collection;
import java.util.LinkedList;
import org.springframework.stereotype.Repository;

import ro.sci.dao.UserDao;
import ro.sci.domain.User;


@Repository
public class ImUserDao extends ImBaseDao<User> implements UserDao {

	@Override
	public boolean findByEmail(String email) {
		
		Collection<User>all = new LinkedList<User>(getAll());
		for (User user : all){
			if (email.equals(user.getEmail())){
				return true;
			}	
		}
		return false;
	}
	
}
