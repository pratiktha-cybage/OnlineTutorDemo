package com.app.dto;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendEmail {
	
	private String userEmail;
	private String hash;
	
	public SendEmail(String userEmail, String hash) {
		super();
		this.userEmail = userEmail;
		this.hash = hash;
	}
	
	public void sendMail()
	{
		String email = "pratikthakare.com@gmail.com"; // sender email
		String password = "Pratik@123"; // sender password
		
		Properties properties = new Properties();
		
		properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.ssl.trust", "smtp.gmail.com");
        
        
        Session session = Session.getDefaultInstance(properties, new javax.mail.Authenticator() 
        {    
            protected PasswordAuthentication getPasswordAuthentication(){
            
                return new PasswordAuthentication(email, password);
            }
        });
        
        try {
        	
        	MimeMessage message = new MimeMessage(session);
        	message.setFrom(new InternetAddress(email));
        	message.addRecipient(Message.RecipientType.TO, new InternetAddress(email));
        	message.setText("Verification Link....");
            message.setText("Click Here :: "+"http://localhost:8080/onlineTutorApp/AccountActivate?key1="+userEmail+"&amp;key2="+hash);
            Transport.send(message);
        	
        }catch(Exception e){
        	
        	System.out.println("SendEmail File Error"+ e);
        }
	}
	
}