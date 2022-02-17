package com.immunization.trustee.service.email;

import java.util.concurrent.Executors;

import java.util.concurrent.ScheduledExecutorService;

import com.immunization.common.model.User;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class TrusteeEmailService {

	private final JavaMailSender javaMailSender;

	private static final int NUM_OF_QUICK_SERVICE_THREADS = 10;

	private final ScheduledExecutorService quickService = Executors
			.newScheduledThreadPool(NUM_OF_QUICK_SERVICE_THREADS);

	public void sendEmail(EmailContent content) {
		String[] emailIds = new String[content.getRecipients().size()];
		for (int i = 0; i < content.getRecipients().size(); i++) {
			emailIds[i] = content.getRecipients().get(i);
		}

		SimpleMailMessage email = new SimpleMailMessage();
		email.setTo(emailIds);
		email.setSubject(content.getSubject());
		email.setText(content.getBody());
		quickService.submit(() -> javaMailSender.send(email));
	}

	public void sendCertificateRequestRejected(String reason, User user) {
		StringBuilder emailBody = new StringBuilder();
		emailBody.append("Poštovana/i ").append(user.getFirstName()).append(" ").append(user.getLastName())
				.append(", \n\n");
		emailBody.append("Vaš zahtev za izdavanje digitalnog zelenog sertifikata nije prihvaćen. \n\n");

		emailBody.append("Razlog odbijanja: ").append(reason);

		emailBody.append("\n\nOvo je automatski generisan mejl. Molimo Vas da na njega ne odgovarate. ©Team404");

		EmailContent email = new EmailContent("Zahtev za izdavanje sertifikata odbijen", emailBody.toString());
		email.addRecipient(user.getEmail());
		sendEmail(email);
	}

	public void sendCertificateRequestAccepted(User user) {
		StringBuilder emailBody = new StringBuilder();
		emailBody.append("Poštovana/i ").append(user.getFirstName()).append(" ").append(user.getLastName())
				.append(", \n\n");
		emailBody.append(
				"Vaš zahtev za izdavanje digitalnog zelenog sertifikata je prihvaćen. Dokument se nalazi se u prilogu ove poruke. \n\n");

		emailBody.append("\n\nOvo je automatski generisan mejl. Molimo Vas da na njega ne odgovarate. ©Team404");

		EmailContent email = new EmailContent("Zahtev za izdavanje sertifikata prihvaćen", emailBody.toString());
		email.addRecipient(user.getEmail());
		sendEmail(email);
	}

}