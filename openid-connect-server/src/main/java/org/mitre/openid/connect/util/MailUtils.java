package org.mitre.openid.connect.util;
import java.io.StringWriter;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailUtils {
	
	@Autowired
	private VelocityEngine velocityEngine;
	
	public void sendEmail(String email, String subject, VelocityContext context, JavaMailSender mailSender) {
		try {
			Template template = velocityEngine.getTemplate("email-template.vm");
			StringWriter writer = new StringWriter();
			template.merge(context, writer);
			MailSender mailSenderObj = new MailSender(email, subject, writer.toString(), mailSender);
			Thread emailThread = new Thread(mailSenderObj);
			emailThread.start();
		} catch (Exception e) {
		}

	}
}