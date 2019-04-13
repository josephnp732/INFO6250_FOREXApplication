package com.neu.edu.controller;

import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.sun.mail.smtp.SMTPTransport;

public class EmailSender {

	private static final String password = "test123";
	private static final String emailAddress = "postmaster@sandboxbc6e859c0aed47dab79566be71a6af00.mailgun.org";
	
	public EmailSender(String toEmail, String name) throws Exception {
		this.sendEmail(toEmail, name);
	}

    private void sendEmail(String toEmail, String name) throws Exception {

        Properties props = System.getProperties();
        props.put("mail.smtps.host", "smtp.mailgun.org");
        props.put("mail.smtps.auth", "true");

        Session session = Session.getInstance(props, null);
        Message msg = new MimeMessage(session);
        msg.setFrom(new InternetAddress("josephnp732@gmail.com"));

        InternetAddress[] addrs = InternetAddress.parse(toEmail, false);
        msg.setRecipients(Message.RecipientType.TO, addrs);

        msg.setSubject("New FOREX Account");
        msg.setText("Hi " + name + ", \n \n" + "Welcome to your FOREX account \n \n" + "Regards, \nFOREX Team");
        msg.setSentDate(new Date());

        SMTPTransport t =
            (SMTPTransport) session.getTransport("smtps");
        t.connect("smtp.mailgun.org", emailAddress, password);
        t.sendMessage(msg, msg.getAllRecipients());

        System.out.println("Response: " + t.getLastServerResponse());

        t.close();
    }
}
