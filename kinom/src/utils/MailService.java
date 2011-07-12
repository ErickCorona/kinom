package utils;

import java.util.ArrayList;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.*;

public class MailService {

		private ArrayList<String> toEmail;
		private String subject;
		private String cuerpo;
		private ArrayList<String> files;
		
		public MailService(){
			this.toEmail=new ArrayList<String>();
			this.subject=" ";
			this.cuerpo=" ";
		}
		
		 public void setter(ArrayList<String> tE,String s,String c, ArrayList<String> files){
			this.toEmail= tE;
			this.subject=s;
			this.cuerpo=c;
			this.files = files;
		}
		
		public boolean enviarCorreo() throws Exception{
	        try
	        {
	            Properties props = new Properties();
	            props.setProperty("mail.smtp.host", "smtp.gmail.com");
	            props.setProperty("mail.smtp.starttls.enable", "true");
	            props.setProperty("mail.smtp.port", "587");
	            props.setProperty("mail.smtp.user", "kinomlabs@gmail.com");
	            props.setProperty("mail.smtp.auth", "true");

	            Session session = Session.getDefaultInstance(props);

	            MimeMessage message = new MimeMessage(session);
	            message.setFrom(new InternetAddress("kinomlabs@gmail.com"));
	            for(String tE:toEmail)
	            	message.addRecipient(Message.RecipientType.TO,new InternetAddress(tE));
	            message.setSubject(this.subject);
	            
	            BodyPart messageBodyPart = new MimeBodyPart(); 
	            Multipart multipart = new MimeMultipart(); 
	            
	            messageBodyPart.setContent(this.cuerpo, "text/html");
	            multipart.addBodyPart(messageBodyPart); 
	            
	            for(String file:files){
	            	messageBodyPart = new MimeBodyPart(); 
		            DataSource source = new FileDataSource(file); 
		            messageBodyPart.setDataHandler(new DataHandler(source)); 
		            messageBodyPart.setFileName(file); 
		            multipart.addBodyPart(messageBodyPart); 
	            }
	            message.setContent(multipart); 
	            
	            Transport t = session.getTransport("smtp");
	            t.connect("smtp.gmail.com","kinomlabs@gmail.com", "ombeje123");
	            t.sendMessage(message, message.getAllRecipients());

	            t.close();
				return true;
	        }
	        catch (Exception e)
	        {
	            throw e;
	        }
	    }
		
		public void setToEmail(ArrayList<String> tE){
			this.toEmail = tE;
		}
		
		public void setSubject(String s){
			this.subject = s;
		}
		
		public void setCuerpo(String c){
			this.cuerpo = c;
		}

		public void setFiles(ArrayList<String> files) {
			this.files = files;
		}

		public static void main(String args[]){
			MailService em = new MailService();
			em.setter(new ArrayList<String>(),"prueba","prueba",new ArrayList<String>());
			try {
				em.enviarCorreo();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		public void addRecipient(String mail) {
			toEmail.add(mail);
		}
		
		public static void send(String subject, String body, ArrayList<String> arc){
			MailService m = new MailService();
			m.setSubject(subject);
			m.setCuerpo(body);
			m.setFiles(arc);
			m.addRecipient("betobs26@hotmail.com");
			//m.addRecipient("jsus.159@gmail.com");
			try {
				m.enviarCorreo();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
}
