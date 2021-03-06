package com.immunization.trustee.service.email;

import java.util.concurrent.Executors;

import java.util.concurrent.ScheduledExecutorService;

import javax.activation.DataSource;
import javax.mail.internet.MimeMessage;
import javax.mail.util.ByteArrayDataSource;

import com.immunization.common.model.User;
import com.immunization.trustee.service.DigitalniSertifikatService;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class TrusteeEmailService {

    private final JavaMailSender javaMailSender;

    private final DigitalniSertifikatService sertifikatService;

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

    public void sendEmailWithAttachments(EmailContent content, String certificateUUID, DataSource attachmentPDF,
            DataSource attachmentXHTML) throws Exception {
        String[] emailIds = new String[content.getRecipients().size()];
        for (int i = 0; i < content.getRecipients().size(); i++) {
            emailIds[i] = content.getRecipients().get(i);
        }

        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        helper.setSubject(content.getSubject());
        helper.setTo(emailIds);
        helper.setText(content.getBody());
        helper.addAttachment(certificateUUID + ".pdf", attachmentPDF);
        helper.addAttachment(certificateUUID + ".xhtml", attachmentXHTML);
        quickService.submit(() -> javaMailSender.send(message));
    }

    public void sendCertificateRequestRejected(String reason, User user) {
        StringBuilder emailBody = new StringBuilder();
        emailBody.append("Po??tovana/i ").append(user.getFirstName()).append(" ").append(user.getLastName())
                .append(", \n\n");
        emailBody.append("Va?? zahtev za izdavanje digitalnog zelenog sertifikata nije prihva??en. \n\n");

        emailBody.append("Razlog odbijanja: ").append(reason);

        emailBody.append("\n\nOvo je automatski generisan mejl. Molimo Vas da na njega ne odgovarate. ??Team404");

        EmailContent email = new EmailContent("Zahtev za izdavanje sertifikata odbijen", emailBody.toString());
        email.addRecipient(user.getEmail());
        sendEmail(email);
    }

    public void sendCertificateRequestAccepted(User user, String certificateUUID) throws Exception {
        StringBuilder emailBody = new StringBuilder();
        emailBody.append("Po??tovana/i ").append(user.getFirstName()).append(" ").append(user.getLastName())
                .append(", \n\n");
        emailBody.append(
                "Va?? zahtev za izdavanje digitalnog zelenog sertifikata je prihva??en. Dokument se nalazi u prilogu ove poruke. \n\n");

        emailBody.append("\n\nOvo je automatski generisan mejl. Molimo Vas da na njega ne odgovarate. ??Team404");

        EmailContent email = new EmailContent("Zahtev za izdavanje sertifikata prihva??en", emailBody.toString());
        email.addRecipient(user.getEmail());

        DataSource attachmentPDF = new ByteArrayDataSource(sertifikatService.generatePdf(certificateUUID),
                "application/octet-stream");
        DataSource attachmentXHTML = new ByteArrayDataSource(sertifikatService.generateXhtml(certificateUUID),
                "application/octet-stream");
        this.sendEmailWithAttachments(email, certificateUUID, attachmentPDF, attachmentXHTML);
    }
}