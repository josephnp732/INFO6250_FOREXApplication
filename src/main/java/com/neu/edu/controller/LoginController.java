package com.neu.edu.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.neu.edu.dao.UserLoginDao;
import com.neu.edu.exception.LoginException;
import com.neu.edu.pojo.User;

//https://o7planning.org/en/10601/spring-mvc-form-handling-and-hibernate-tutorial

@Controller
@RequestMapping("/*")
public class LoginController {

	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

	@Autowired
	UserLoginDao userDao;
	
	@RequestMapping(value = "/mydetails", method = RequestMethod.GET)
	public ModelAndView MyDetails(@ModelAttribute("user") User user, HttpServletRequest request) throws LoginException {
		return new ModelAndView("myDetails");
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView displayLogin(@ModelAttribute("user") User user, HttpServletRequest request)
			throws LoginException {
		return new ModelAndView("home");
	}

//	@RequestMapping(value="/", method = RequestMethod.GET)
//	public String displayLogin(Model model) { 
//	    model.addAttribute("user", new User()); 
//	    return "home"; 
//	}

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String goToHome(Model model) {
		model.addAttribute("user", new User());
		return "mainPage";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView mainPage(@ModelAttribute("user") User user, HttpServletRequest request) throws LoginException {
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		User u = (User) userDao.get(userName, password);
		if(u == null)
		{
			return new ModelAndView("home","validate",79);
		}
		HttpSession session = request.getSession();
		session.setAttribute("user", u);
		return new ModelAndView("mainPage");
	}

	@RequestMapping(value = "/welcome", method = RequestMethod.POST)
	public String createUser(Model model) {
		model.addAttribute("user", new User());
		return "addUser";
	}

//	@RequestMapping("/add")
//	public String createUser(Model model) { 
//	   model.addAttribute("user", new User()); 
//	    return "addUser"; 
//	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ModelAndView createUser(@Valid @ModelAttribute("user") User user, 
			@RequestParam String email,
			@RequestParam String name,
			BindingResult result,
			HttpServletRequest request) throws Exception {
		if(result.hasErrors())
		{
			return new ModelAndView("addUser");
		}
		else
		{
			EmailSender newEmail = new EmailSender(email,name);
			userDao.create(user);
			return new ModelAndView("home");
		}
	}
}
