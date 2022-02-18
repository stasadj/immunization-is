package com.immunization.portal.service.email;

import java.io.ByteArrayInputStream;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

import com.immunization.common.model.User;
import com.immunization.common.model.interesovanje.IskazivanjeInteresovanjaZaVakcinaciju;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

import javax.activation.DataSource;
import javax.mail.internet.MimeMessage;
import javax.mail.util.ByteArrayDataSource;

@Service
@AllArgsConstructor
public class PortalEmailService {

    private JavaMailSender javaMailSender;

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
    
    public void sendRegistrationSuccess(User user) {
        String emailBody = "Poštovana/i " + user.getFirstName() + " " + user.getLastName() + ", \n" +
                "Uspešno ste se registrovali na portalu. \n\n" +
                "Vaše korisničko ime je: " + user.getUsername() + " \n";

        EmailContent email = new EmailContent("Uspešna registracija na portal", emailBody);
        email.addRecipient(user.getEmail());
        sendEmail(email);
    }

    public void sendInteresovanjeConfirmation(IskazivanjeInteresovanjaZaVakcinaciju interesovanje,
            String recipientEmail) {
        StringBuilder emailBody =  new StringBuilder();
        emailBody.append("Postovana/i ").append(interesovanje.getPacijent().getPunoIme().getValue()).append(", \n");
        emailBody.append("Vaše interesovanje je uspesno zabeleženo. Očekujte termin vakcinacije u roku od 7 radnih dana. \n\n");

        emailBody.append("Ime pacijenta: ").append(interesovanje.getPacijent().getPunoIme().getValue()).append(" \n");
        emailBody.append("JMBG: ").append(interesovanje.getPacijent().getJmbg().getValue()).append(" \n");
        emailBody.append("Opština vakcinacije: ").append(interesovanje.getZeljenaOpstinaVakcinacije()).append(" \n");

        StringBuilder vaccines = new StringBuilder();
        // interesovanje.getOdabirVakcina().getOpcija().forEach(vaccines::append);
        for (String opcija: interesovanje.getOdabirVakcina().getOpcija()){
            vaccines.append("\n").append(opcija);
        }

        String vaccineString = vaccines.toString();
        if (vaccineString.equals("")){
            vaccineString = "BILO KOJA";
        }

        emailBody.append("Odabrane vakcine: ").append(vaccineString).append(" \n");
        emailBody.append("\n\nOvo je automatski generisan mejl. Molimo Vas da na njega ne odgovarate. ©Team404");

        EmailContent email = new EmailContent("Interesovanje za vakcinaciju uspešno zabeleženo.", emailBody.toString());
        email.addRecipient(recipientEmail);
        sendEmail(email);

    }

    public void sendConfirmation(User user, String certificateUUID, ByteArrayInputStream pdf) throws Exception {
        StringBuilder emailBody = new StringBuilder();
        emailBody.append("Poštovana/i ").append(user.getFirstName()).append(" ").append(user.getLastName()).append(", \n\n");
        emailBody.append("Vaša potvrda o izvršenoj imunizaciji se nalazi u prilogu ove poruke. \n\n");

        emailBody.append("\n\nOvo je automatski generisan mejl. Molimo Vas da na njega ne odgovarate. ©Team404");

        EmailContent email = new EmailContent("Zahtev za izdavanje sertifikata prihvaćen", emailBody.toString());
        email.addRecipient(user.getEmail());

        DataSource attachmentPDF = new ByteArrayDataSource(pdf, "application/octet-stream");
        this.sendEmailWithAttachments(email, certificateUUID, attachmentPDF);
    }

    private void sendEmailWithAttachments(EmailContent content, String documentId, DataSource attachmentPDF) throws Exception {
        String[] emailIds = new String[content.getRecipients().size()];
        for (int i = 0; i < content.getRecipients().size(); i++) {
            emailIds[i] = content.getRecipients().get(i);
        }
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        helper.setSubject(content.getSubject());
        helper.setTo(emailIds);
        helper.setText(content.getBody());
        helper.addAttachment(documentId + ".pdf", attachmentPDF);
        quickService.submit(() -> javaMailSender.send(message));
    }

    public void sendMailAboutAppointment() {

    }

}