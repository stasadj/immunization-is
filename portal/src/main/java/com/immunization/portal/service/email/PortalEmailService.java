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

    public void sendInteresovanjeConfirmation(IskazivanjeInteresovanjaZaVakcinaciju interesovanje,
            String recipientEmail) {

        String emailBody = "Postovana/i " + interesovanje.getPacijent().getPunoIme().getValue() + ", \n";
        emailBody += "Vase interesovanje je uspesno zabelezeno. Ocekujte termin vakcinacije u roku od 7 radnih dana. \n\n";

        emailBody += "Ime pacijenta: " + interesovanje.getPacijent().getPunoIme().getValue() + " \n";
        emailBody += "JMBG: " + interesovanje.getPacijent().getJmbg().getValue() + " \n";
        emailBody += "Opstina vakcinacije: " + interesovanje.getZeljenaOpstinaVakcinacije() + " \n";

        StringBuilder vaccines = new StringBuilder();
        interesovanje.getOdabirVakcina().getOpcija().forEach(opcija -> vaccines.append(opcija));

        String vaccineString = vaccines.toString();
        if (vaccineString.equals("")){
            vaccineString = "BILO KOJA";
        }

        emailBody += "Odabrane vakcine: " + vaccineString + " \n";
        emailBody += "\n\nOvo je automatski generisan mejl. Molimo Vas da na njega ne odgovarate. ©Team404";

        EmailContent email = new EmailContent("Interesovanje za vakcinaciju uspesno zabelezeno.", emailBody);
        email.addRecipient(recipientEmail);
        sendEmail(email);

    }

}