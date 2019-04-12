package com.neu.edu.controller;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.neu.edu.dao.PaymentDao;
import com.neu.edu.exception.LoginException;
import com.neu.edu.exception.PaymentException;
import com.neu.edu.exception.RecipientException;
import com.neu.edu.exception.UserException;
import com.neu.edu.pojo.Payment;
import com.neu.edu.pojo.User;

@Controller
@RequestMapping("/userPayment/*")
public class PaymentController {
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	@Autowired
	PaymentDao paymentDao;
	
	@RequestMapping(value="/payments", method = RequestMethod.GET)
	public ModelAndView managePayment(@ModelAttribute("user") User user, HttpServletRequest request) throws LoginException, UserException{
		HttpSession session = request.getSession();
		User u = (User) session.getAttribute("user");
		List<Payment> payments = (List<Payment>) paymentDao.get(u.getUserId());
		return new ModelAndView("managePayment","payments",payments);
	}
	
	@RequestMapping(value="/delete", method = RequestMethod.GET)
	public ModelAndView deletePayment(@ModelAttribute("user") User user, HttpServletRequest request) throws LoginException, RecipientException, PaymentException{	
		String option = request.getParameter("option") == null ? "" : request.getParameter("option");
		if(option.equals("delete"))
		{
			int paymentId = (int) Integer.parseInt(request.getParameter("paymentId"));
			try {
				paymentDao.delete(paymentId);
			} catch (Exception e) {
					System.out.println("Hibernate could not delete the Payment Card");
				e.printStackTrace();
			}
		}
		return new ModelAndView("mainPage");
	}
	
	
	@RequestMapping(value="/add", method = RequestMethod.POST)
	public ModelAndView goToAddPayment(@ModelAttribute("payment") Payment payment, HttpServletRequest request) throws LoginException{
		HashMap<String, Object> map = new HashMap<String, Object>();
		
		List<String> cardTypes = new LinkedList<String>();
		cardTypes.add("Visa");
		cardTypes.add("Master Card");
		cardTypes.add("Discover");
		cardTypes.add("American Express");
		map.put("cardTypes",cardTypes);
		List<Integer> months = new LinkedList<Integer>();
		for(int i = 1; i <= 12; i++)
		{
			months.add(i);
		}
		map.put("months", months);
		List<Integer> years = new LinkedList<Integer>();
		for(int i=2019; i <= 2030; i++)
		{
			years.add(i);
		}
		map.put("years", years);
		return new ModelAndView("addPayment","map",map);
	}
	
	@RequestMapping(value="/create", method = RequestMethod.POST)
	public ModelAndView addPayment(@ModelAttribute("payment")  Payment payment, HttpServletRequest request) throws LoginException, PaymentException{
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		payment.setUser(user);
		paymentDao.create(payment);
		return new ModelAndView("mainPage");
	}
}
