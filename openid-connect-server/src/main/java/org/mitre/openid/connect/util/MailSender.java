package org.mitre.openid.connect.util;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

public class MailSender implements Runnable {

	private String emailTo;
	private String body;
	private String subject;
	private JavaMailSender mailSender;

	public MailSender(String emailTo, String subject, String body, JavaMailSender mailSender) {
		this.emailTo = emailTo;
		this.subject = subject;
		this.body = body;
		this.mailSender = mailSender;
	}

	public void run() {
		SimpleMailMessage email = new SimpleMailMessage();
		email.setTo(emailTo);
		email.setSubject(subject);
		email.setText(body);
		mailSender.send(email);
	}

}
