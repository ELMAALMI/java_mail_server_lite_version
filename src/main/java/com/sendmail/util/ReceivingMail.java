package com.sendmail.util;


import com.sendmail.entities.Email;
import com.sendmail.entities.Utilisateur;
import com.sun.mail.pop3.POP3Folder;

import javax.mail.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

public class ReceivingMail {
	
    public List<Email>  receiving(Utilisateur user)  {
        List<Email> emails = new ArrayList<>();
        String MAIL_HOST="192.168.43.29";
        try {
            Properties properties = new Properties();
            Session session;

            properties.put("mail.smtp.host", MAIL_HOST);
            properties.put("mail.smtp.port","25");
            properties.put("mail.smtp.auth","true");
            session = Session.getDefaultInstance(properties,
                    new javax.mail.Authenticator() {
                        protected PasswordAuthentication getPasswordAuthentication() {
                            return new PasswordAuthentication(user.getEmail(),user.getPassword());
                        }
            });
            Store store = session.getStore("pop3");
            store.connect(MAIL_HOST, user.getEmail(),user.getPassword());
            Folder folder = store.getFolder("inbox");

            folder.open(Folder.READ_WRITE);
            Message[] messages = folder.getMessages();

            for(Message message : messages){
                POP3Folder pf = (POP3Folder)folder;
                Email email = new Email();
                //email.setMessage((String) message.getContent());
                email.setFrom(message.getFrom()[0].toString());
                email.setSubject(message.getSubject());
                email.setCreatedAt(message.getSentDate());
                email.setUuid(pf.getUID(message));
                emails.add(email);
            }
            folder.close(true);
            store.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return emails;
    }
}
