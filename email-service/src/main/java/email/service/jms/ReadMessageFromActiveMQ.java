package email.service.jms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import email.service.tosend.ServiceToSendEmail;

@Component
public class ReadMessageFromActiveMQ {
	
	@Autowired
	private ServiceToSendEmail serviceToSendEmail;
	
	
    //TODO - the name queue must be configured in application.properties
	
	@JmsListener(destination = "email", containerFactory = "myFactory")
	public void receiveMessage(String emailTo) {
		try {
		System.out.println("Received ##################################### <" + emailTo + ">");
		System.out.println("Send Email");
		serviceToSendEmail.sendMail(emailTo);
		}catch(Exception ex) {
			System.out.println("Error");
		}
	}

}