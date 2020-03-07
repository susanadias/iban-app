package email.service;

import org.springframework.mail.javamail.JavaMailSender;

public interface ServiceToSendEmail {
	
	public String sendMail();

}
