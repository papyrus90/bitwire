/*package ro.sci.web;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import ro.sci.dao.SqlDao;
import ro.sci.domain.User;



@Controller
@RequestMapping("/")
public class UserController {


	@Autowired
	private SqlDao sql;

	
	

	@RequestMapping("/users")
	public ModelAndView list(){
		ModelAndView view = new ModelAndView("user_list");
		view.addObject("users", sql.findAll());
		return view;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView saveUser( User user,BindingResult bindingResult) {
		ModelAndView result = list();
		try{
			
			sql.save(user);
		}catch(Exception e){
			result = renderEditPage(user.getId());
			bindingResult.addError(new ObjectError("user",e.getMessage()));
		}
		return result;
	}

	@RequestMapping("/register")
	public ModelAndView renderEditPage(Long id) {
		ModelAndView result = new ModelAndView("register");
		User user = new User();
		if (id != null) {
			user = sql.findOne(id);			
		}
		result.addObject("user", user);
		return result;
	}
	  @RequestMapping("/create")
	  @ResponseBody
	  public String create(String email, String password) {
	    String userId = "";
	    try {
	      User user = new User(email, password);
	      sql.save(user);
	      userId = String.valueOf(user.getId());
	    }
	    catch (Exception ex) {
	      return "Error creating the user: " + ex.toString();
	    }
	    return "User succesfully created with id = " + userId;
	  }
	  
	  @RequestMapping("/delete")
	  @ResponseBody
	  public String delete(String email){
		  if (sql.findOneByEmail(email)!= null){
			  User user = sql.findOneByEmail(email);
			  sql.delete(user);
			  return ("User with email " + email +  " succesfully deleted"); 
		  }
		  return ("user not found");
	  }
	
	
	
}
*/