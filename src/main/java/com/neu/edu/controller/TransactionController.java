package com.neu.edu.controller;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import javax.validation.Validator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

import com.neu.edu.dao.PaymentDao;
import com.neu.edu.dao.RecipientDao;
import com.neu.edu.dao.TransactionDao;
import com.neu.edu.exception.LoginException;
import com.neu.edu.exception.RecipientException;
import com.neu.edu.exception.TransactionException;
import com.neu.edu.exception.UserException;
import com.neu.edu.pojo.Payment;
import com.neu.edu.pojo.Recipient;
import com.neu.edu.pojo.Transaction;
import com.neu.edu.pojo.User;
import com.tunyk.currencyconverter.BankUaCom;
import com.tunyk.currencyconverter.api.Currency;
import com.tunyk.currencyconverter.api.CurrencyConverter;
import com.tunyk.currencyconverter.api.CurrencyConverterException;

//https://www.codejava.net/frameworks/spring/spring-web-mvc-with-pdf-view-example-using-itext-5x

@Controller
@RequestMapping("/userTransaction/*")
public class TransactionController {

	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

	@Autowired
	PaymentDao paymentDao;

	@Autowired
	RecipientDao recipientDao;

	@Autowired
	TransactionDao transactionDao;

	private Validator validator;

	@RequestMapping(value = "/begin", method = RequestMethod.GET)
	public ModelAndView goToAddTransaction(@ModelAttribute("transaction") Transaction transaction,
			HttpServletRequest request)
			throws LoginException, RecipientException, UserException, CurrencyConverterException {
		HashMap<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		User u = (User) session.getAttribute("user");
		int userId = u.getUserId();
		List<Payment> payments = (List<Payment>) paymentDao.get(userId);
		List<Recipient> recipients = (List<Recipient>) recipientDao.get(userId);
		List<String> currencies = Currencies();
		map.put("payments", payments);
		map.put("recipients", recipients);
		map.put("currencies", currencies);
		CurrencyConverter currencyConverter = new BankUaCom(Currency.USD, Currency.EUR);
		return new ModelAndView("transactionPage", "map", map);
	}

	@RequestMapping(value = "/viewTransactions", method = RequestMethod.GET)
	public ModelAndView viewtransactions(@ModelAttribute("transaction") Transaction transaction,
			HttpServletRequest request) throws TransactionException {
		HttpSession session = request.getSession();
		User u = (User) session.getAttribute("user");
		List<Transaction> transactions = (List<Transaction>) transactionDao.get(u.getUserId());
		return new ModelAndView("viewTransactionsPage", "transactions", transactions);
	}

	@RequestMapping(value = "/downloadPDF.pdf", method = RequestMethod.GET)
	public ModelAndView downloadPDF(@ModelAttribute("transaction") Transaction transaction, HttpServletRequest request)
			throws TransactionException {
		HttpSession session = request.getSession();
		User u = (User) session.getAttribute("user");
		List<Transaction> transactions = (List<Transaction>) transactionDao.get(u.getUserId());

		View view = new PDFBuilder();
		return new ModelAndView(view, "transactions", transactions);
	}

	private static List<String> Currencies() {
		List<String> currencies = new LinkedList<String>();
		currencies.add("AUD");
		currencies.add("CAD");
		currencies.add("RUB");
		currencies.add("GBP");
		currencies.add("SGD");
		currencies.add("SEK");
		currencies.add("EUR");
		currencies.add("PLN");
		currencies.add("AZM");
		currencies.add("BYR");
		currencies.add("CHF");
		currencies.add("CNF");
		currencies.add("DKK");
		currencies.add("HUF");
		currencies.add("ISK");
		currencies.add("TMM");
		currencies.add("UAH");
		currencies.add("UZS");
		return currencies;
	}

	@RequestMapping(value = "/transact", method = RequestMethod.POST)
	public ModelAndView Transact(@Valid @ModelAttribute("transaction") Transaction transaction, BindingResult result,
			@RequestParam("transactionAmount") String transactionAmount,
			@RequestParam("transactionCurrency") String transactionCurrency, HttpServletRequest request)
			throws CurrencyConverterException, TransactionException, UserException, RecipientException {

		if (result.hasErrors()) {
			HashMap<String, Object> map = new HashMap<String, Object>();
			HttpSession session = request.getSession();
			User u = (User) session.getAttribute("user");
			int userId = u.getUserId();
			List<Payment> payments = (List<Payment>) paymentDao.get(userId);
			List<Recipient> recipients = (List<Recipient>) recipientDao.get(userId);
			List<String> currencies = Currencies();
			map.put("payments", payments);
			map.put("recipients", recipients);
			map.put("currencies", currencies);
			CurrencyConverter currencyConverter = new BankUaCom(Currency.USD, Currency.EUR);
			return new ModelAndView("transactionPage", "map", map);
		}

		HttpSession session = request.getSession();

		CurrencyConverter currencyConverter = new BankUaCom(Currency.USD, Currency.EUR);
		User u = (User) session.getAttribute("user");
		float convertedAmount = currencyConverter.convertCurrency(Float.parseFloat(transactionAmount), Currency.USD,
				Currency.fromString(transactionCurrency));

		transaction.setTransactionAmount(convertedAmount);
		transaction.setTransactionDateTime(new java.util.Date());
		transaction.setUser(u);
		transactionDao.create(transaction);
		return new ModelAndView("mainPage");
	}

}
