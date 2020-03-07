package email.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class ReadMessageFromActiveMQ {
	
	@Autowired
	private ServiceToSendEmail serviceToSendEmail;

	@JmsListener(destination = "email", containerFactory = "myFactory")
	public void receiveMessage(String teste) {
		System.out.println("Received ##################################### <" + teste + ">");
		System.out.println("Envio o email");
		
		serviceToSendEmail.sendMail();

	}

}