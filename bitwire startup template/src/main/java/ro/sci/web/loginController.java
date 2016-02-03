package ro.sci.web;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ro.sci.dao.SqlDao;
import ro.sci.domain.User;

@Controller
@RequestMapping("/login")
public class loginController {
	
	@Autowired
	private SqlDao sql;
	
	@RequestMapping(value = "")
	public ModelAndView logIn(String email){
		ModelAndView result = new ModelAndView("login");
		User user = new User();
		result.addObject("user",user);
		return result;
	}
	@RequestMapping(method=RequestMethod.POST)
	public ModelAndView getIn(User user){
		ModelAndView view = congrats(user);
		if (sql.findOneByEmail(user.getEmail()) != null){
			view.addObject("user", user);
			return view;
			}else
				throw new IllegalArgumentException("not a valid email");
	}

	@RequestMapping ("/user" )
	public ModelAndView congrats(User user){	
		ModelAndView view = new ModelAndView("users","user",user);
		return view;
		
	}
	
	@RequestMapping("/users")
	public ModelAndView list(){
		ModelAndView view = new ModelAndView("user_list");
		view.addObject("users", sql.findAll());
		return view;
	}

}
