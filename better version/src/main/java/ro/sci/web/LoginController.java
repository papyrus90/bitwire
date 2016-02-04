package ro.sci.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ro.sci.domain.User;
import ro.sci.service.SqlService;

@Controller
public class LoginController {
	
	@Autowired
	 private SqlService service;
	
	@RequestMapping(value = "/login" , method = RequestMethod.GET )
		public ModelAndView getLoginPage( ){
			return new ModelAndView("login" ,"user", new User());
	}
	

}
