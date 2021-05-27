package manga.SendEmail;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendEmail {

	public void Send(String to) {

		String from = "bismark@gmail.com";
		String host = "0.0.0.0:1025";

		Properties properties = new Properties();
		properties.setProperty("mail.smtp.host", host);
		Session session = Session.getDefaultInstance(properties, null);

		try {
			
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(from)); 
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to,false));
			message.setSubject("HELLO");
			message.setText("bienvenu Bismark");
			//send
			Transport.send(message);

			System.out.println("message recu");
		} catch (MessagingException mex) {
			mex.printStackTrace();
		}

	}

}
