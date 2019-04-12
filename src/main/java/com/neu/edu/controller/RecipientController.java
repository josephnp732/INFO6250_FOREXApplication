package com.neu.edu.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.neu.edu.dao.RecipientDao;
import com.neu.edu.exception.LoginException;
import com.neu.edu.exception.PaymentException;
import com.neu.edu.exception.RecipientException;
import com.neu.edu.pojo.Recipient;
import com.neu.edu.pojo.User;

@Controller
@RequestMapping("/userRecipient/*")
public class RecipientController {
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	@Autowired
	RecipientDao recipientDao;

	
	@RequestMapping(value="/recipients", method = RequestMethod.GET)
	public ModelAndView manageRecipient(@ModelAttribute("user") User user, HttpServletRequest request) throws LoginException, RecipientException, PaymentException{
		HttpSession session = request.getSession();
		User u = (User) session.getAttribute("user");
		List<Recipient> recipients = (List<Recipient>) recipientDao.get(u.getUserId());
		
		String option = request.getParameter("option") == null ? "" : request.getParameter("option");
		if(option.equals("delete"))
		{
			int recipientId = (int) Integer.parseInt(request.getParameter("recipientId"));
			try {
				recipientDao.delete(recipientId);
			} catch (Exception e) {
					System.out.println("Hibernate could not delete the Recipient");
				e.printStackTrace();
			}
		}
		return new ModelAndView("manageRecipient","recipients",recipients);
	}
	
	@RequestMapping(value="/delete", method = RequestMethod.GET)
	public ModelAndView deleteRecipient(@ModelAttribute("user") User user, HttpServletRequest request) throws LoginException, RecipientException, PaymentException{	
		String option = request.getParameter("option") == null ? "" : request.getParameter("option");
		if(option.equals("delete"))
		{
			int recipientId = (int) Integer.parseInt(request.getParameter("recipientId"));
			try {
				recipientDao.delete(recipientId);
			} catch (Exception e) {
					System.out.println("Hibernate could not delete the Recipient");
				e.printStackTrace();
			}
		}
		return new ModelAndView("mainPage");
	}
	
	@RequestMapping(value="/add", method = RequestMethod.POST)
	public ModelAndView goToAddRecipient(@ModelAttribute("recipient") Recipient recipient, HttpServletRequest request) throws LoginException{
		return new ModelAndView("addRecipient");
	}
	
	@RequestMapping(value="/create", method = RequestMethod.POST)
	public ModelAndView addRecipient(@Valid @ModelAttribute("recipient") Recipient recipient,
			BindingResult result, HttpServletRequest request) throws LoginException, RecipientException {
		
		if(result.hasErrors())
		{
			new ModelAndView("addRecipient");
		}
		
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		recipient.setUser(user);
		recipientDao.create(recipient);
		return new ModelAndView("mainPage");
	}
}
