package email.service.tosend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class ServiceToSendEmailImpl implements ServiceToSendEmail {
	
	@Autowired 
	private JavaMailSender mailSender;
	
	@Value("${spring.mail.username}")
	private String emailApp;

	@Override
	public String sendMail(String emailTo) {
		
		 SimpleMailMessage message = new SimpleMailMessage();
	        message.setText("Hello!! Do you have a new subscription");
	        message.setTo(emailTo);
	        message.setFrom(emailApp);

	        try {
	            mailSender.send(message);
	            return "Email send sucessfully!";
	        } catch (Exception e) {
	            e.printStackTrace();
	            return "Error in send the email.";
	        }
	}

}
