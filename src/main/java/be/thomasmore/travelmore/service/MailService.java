package be.thomasmore.travelmore.service;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MailService {
    private static MailService mailService = null;

    private static Session mailSession;

    //mail settings
    private static final String HOST = "smtp.gmail.com";
    private static final int PORT = 587;
    private static final String USER = "travelmore1.thomasmore";
    private static final String PASSWORD = "TravelMore123";
    private static final String FROM = "TravelMore <travelmore1.thomasmore@gmail.com>";

    private MailService(){
        Properties properties = System.getProperties();

        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.port", "587");

        mailSession = Session.getInstance(properties);
        mailSession.setDebug(true);
    }

    public static void sendMail(String recipient, String subject, String message) throws MessagingException {
        if(mailService == null){
            mailService = new MailService();
        }

        MimeMessage mimeMessage = new MimeMessage(mailSession);

        mimeMessage.setSubject(subject);
        mimeMessage.setContent(message, "text/html");
        System.out.println(message);
        System.out.println(recipient);

        mimeMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(recipient));

        Transport transport = mailSession.getTransport("smtp");
        transport.connect(HOST, USER, PASSWORD);

        transport.sendMessage(mimeMessage, mimeMessage.getRecipients(Message.RecipientType.TO));
        transport.close();
    }
}