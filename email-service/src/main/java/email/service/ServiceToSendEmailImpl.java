package email.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

@Service
public class ServiceToSendEmailImpl implements ServiceToSendEmail {
	
	@Autowired 
	private JavaMailSender mailSender;

	@Override
	public String sendMail() {
		
		 SimpleMailMessage message = new SimpleMailMessage();
	        message.setText("Hello from Spring Boot Application");
	        message.setTo("susanabrancodias@gmail.com");
	        message.setFrom("susanabrancodias@gmail.com");

	        try {
	            mailSender.send(message);
	            return "Email enviado com sucesso!";
	        } catch (Exception e) {
	            e.printStackTrace();
	            return "Erro ao enviar email.";
	        }
	}

}
