package ro.sci.dao;




import ro.sci.domain.User;

public interface UserDao extends BaseDao<User>  {
	
	boolean findByEmail(String email);
}
