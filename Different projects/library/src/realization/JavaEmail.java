package realization;

import java.util.Properties;

import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class JavaEmail {

    Properties emailProperties;
    Session mailSession;
    MimeMessage emailMessage;

    public void setMailServerProperties() {

        String emailPort = "587";//gmail's smtp port

        emailProperties = System.getProperties();
        emailProperties.put("mail.smtp.port", emailPort);
        emailProperties.put("mail.smtp.auth", "true");
        emailProperties.put("mail.smtp.starttls.enable", "true");

    }

    private void createEmailMessageForAdmin(String newBook) throws AddressException,
            MessagingException {
        setMailServerProperties();
        String[] toEmails = { "lesha.and.android@gmail.com" };
        String emailSubject = "New book";
        String emailBody = newBook;

        mailSession = Session.getDefaultInstance(emailProperties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("ajavatest1@gmail.com", "123123125");
            }
        });
        emailMessage = new MimeMessage(mailSession);

        for (int i = 0; i < toEmails.length; i++) {
            emailMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(toEmails[i]));
        }

        emailMessage.setSubject(emailSubject);
        //emailMessage.setContent(emailBody, "text/html");//for a html email
        emailMessage.setText(emailBody);// for a text email

    }

    public void sendEmailForAdmin(String newBook) throws AddressException, MessagingException {
        createEmailMessageForAdmin(newBook);
        String emailHost = "smtp.gmail.com";
        String fromUser = "ajavatest1";//just the id alone without @gmail.com
        String fromUserEmailPassword = "123123125";

        Transport transport = mailSession.getTransport("smtp");

        transport.connect(emailHost,587, fromUser, fromUserEmailPassword);
        transport.sendMessage(emailMessage, emailMessage.getAllRecipients());
        transport.close();
        System.out.println("Email sent successfully.");
    }

}