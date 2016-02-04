package ro.sci.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ro.sci.service.SqlService;

@Controller
public class UsersController {
	
	@Autowired
	SqlService service;
	
	@RequestMapping("/users")
	public ModelAndView getUsersPage(){
		return new ModelAndView("user_list" ,"users" ,service.getAllUsers());
	}
}
