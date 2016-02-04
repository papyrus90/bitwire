package ro.sci.domain;





@SuppressWarnings("serial")
public class CurrentUser extends org.springframework.security.core.userdetails.User{
	
	 private User user;
	 


	public CurrentUser(User user) {
		super(user.getEmail(),user.getPassword(), null);
		this.user = user;
	}
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}


}
