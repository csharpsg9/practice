package com.tools.investing;

import java.io.*;
import java.util.Map;
import java.util.Properties;
import java.util.TreeMap;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.AddressException;

public class EmailInformation 
{
	public EmailInformation(){}
	
	public static void emailStockReport(){
		String from = "gilltest199@gmail.com";
		String pass = "awesome999!";
		String RECIPIENT = "javakid99@yahoo.com";
		String[] to = { RECIPIENT }; // list of recipient email addresses
		
		Properties props = System.getProperties();
        String host = "smtp.gmail.com";
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.user", from);
        props.put("mail.smtp.password", pass);
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");

        Session session = Session.getDefaultInstance(props);
        MimeMessage message = new MimeMessage(session);

        try {
            message.setFrom(new InternetAddress(from));
            InternetAddress[] toAddress = new InternetAddress[to.length];

            // To get the array of addresses
            for( int i = 0; i < to.length; i++ ) {
                toAddress[i] = new InternetAddress(to[i]);
            }

            for( int i = 0; i < toAddress.length; i++) {
                message.addRecipient(Message.RecipientType.TO, toAddress[i]);
            }

            message.setSubject("hi");
            message.setText("there");
            Transport transport = session.getTransport("smtp");
            transport.connect(host, from, pass);
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();
        }
        catch (AddressException ae) {
            ae.printStackTrace();
        }
        catch (MessagingException me) {
            me.printStackTrace();
        }	
	}
	

	public static void emailStockReport2()
	{
		TreeMap<Integer, String> fileList = new TreeMap<Integer, String>();
		final String username = "gilltest199@gmail.com";
        final String password = "awesome999!";
        Properties props = new Properties();
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props,
        new javax.mail.Authenticator() 
        {
            protected PasswordAuthentication getPasswordAuthentication() 
            {
                return new PasswordAuthentication(username, password);
            }
        });

        try {
        	StringBuilder fileContent = new StringBuilder();
        	String oneLine;
        	
        	/*InternetAddress[] toAddress = new InternetAddress[2];
        	toAddress[0] = new InternetAddress("gilltest199@gmail.com");
        	toAddress[1] = new InternetAddress("shuaibg77@gmail.com");
        	*/
        	
        	InternetAddress[] toAddress = new InternetAddress[1];
        	toAddress[0] = new InternetAddress("shuaibg77@gmail.com");
 
        	Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("gilltest199@gmail.com"));
            message.setRecipients(Message.RecipientType.TO, toAddress);
            message.setSubject("Stock Analysis Report");
            
            fileList = Utils.getStockFileList();
            
            for (Map.Entry<Integer, String> entry : fileList.entrySet()) {	
    			Integer key = entry.getKey();
    			String fileName = entry.getValue();
    			System.out.println(fileName);
    			try{
    				FileInputStream fstream = new FileInputStream("C://Users//shuai_000//Desktop//stocks//" + fileName);
    				DataInputStream in = new DataInputStream(fstream);
    				BufferedReader br = new BufferedReader(new InputStreamReader(in));
            	
    				if(fileContent.length() == 0){
    					fileContent.insert(0, br.readLine() + "\n");
    				}
    				while((oneLine = br.readLine()) != null){
    					fileContent.append(oneLine + "\n");
    				}
    				System.out.println(fileContent);
    				in.close();
    			}catch(Exception e){
    				System.out.println("error - " + e.getMessage());
            
    			}
    			
    			fileContent.append("\n");
            }
            
    		message.setText(fileContent.toString());
            //System.out.println(message);
    		Transport.send(message);

            System.out.println("Done");

        } catch (MessagingException e) 
        {
            System.out.println("**** ERROR ****");
        	throw new RuntimeException(e);
        }
	}
}
