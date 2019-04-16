package com.neu.edu.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.neu.edu.dao.UserLoginDao;
import com.neu.edu.exception.LoginException;
import com.neu.edu.pojo.User;

@Controller
@RequestMapping("/updateDetails/*")
public class UpdateDetails {
	
	@Autowired
	UserLoginDao userDao;
	
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	@RequestMapping(value = "/updateUserDetails", method = RequestMethod.POST)
	public ModelAndView UpdateUserDetails(@ModelAttribute("user") User user, HttpServletRequest request) throws LoginException {
		return new ModelAndView("updateUserDetails");
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public ModelAndView Update(@ModelAttribute("user") User user, HttpServletRequest request) throws LoginException {
		userDao.update(user);
		return new ModelAndView("myDetails");
	}

}
