package com.immunization.portal.service.email;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

import com.immunization.common.model.interesovanje.IskazivanjeInteresovanjaZaVakcinaciju;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;


@Service
@AllArgsConstructor
public class PortalEmailService {

	private JavaMailSender javaMailSender;	
	
	private static final int NUM_OF_QUICK_SERVICE_THREADS = 10;

    private final ScheduledExecutorService quickService = Executors.newScheduledThreadPool(NUM_OF_QUICK_SERVICE_THREADS);

    public void sendEmail(EmailContent content){
    	String[] emailIds = new String[content.getRecipients().size()];
    	for(int i = 0; i <content.getRecipients().size(); i++) {
    		emailIds[i] = content.getRecipients().get(i);
    	}
    	
        SimpleMailMessage email = new SimpleMailMessage();
        email.setTo(emailIds);
        email.setSubject(content.getSubject());
        email.setText(content.getBody());
        quickService.submit(() -> javaMailSender.send(email));
    }
    
    public void sendInteresovanjeConfirmation(IskazivanjeInteresovanjaZaVakcinaciju interesovanje, String recipientEmail) {

		String emailBody = "Dear " + interesovanje.getPacijent().getPunoIme().getValue() + ", \n";
        emailBody += "Your Interesovanje has been successully sent. Please wait for up to 7 business days for an appointment";
        
        //TODO ADD XML TO HTML FOR EMAIL BODY 
		
		emailBody += "\n\nThis is an automatically generated email – please do not reply to it. ©Team404";
		
		EmailContent email = new EmailContent("Interesovanje created!", emailBody);
		email.addRecipient(recipientEmail);
	    sendEmail(email);
		
	}

}