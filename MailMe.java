package prof;

import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;

/**
 *
 * @author Ankul
 */
public class MailMe {
    
    private static String USER_NAME = "profappiiitn@gmail.com";  // GMail user name (just the part before "@gmail.com")
    private static String PASSWORD = "qwerty654321!!@@"; // GMail password
    private static String RECIPIENT = "rinishagedam@gmail.com";

    public static void main(String [] args) {
        String from = USER_NAME;
        String pass = PASSWORD;
        String[] to = { RECIPIENT ,"prachitakotangale@gmail.com","tushtgsingh.05@gmail.com","tejutidke@gmail.com",
            "amanalphakumar@gmail.com",
            "sakshiiiitngp@gmail.com","imnilaybhatt@gmail.com",
            "vaidehighime@gmail.com",
            "anushreeladdha7@gmail.com",
            "k.divyasri12@gmail.com",
            "aayes1998@gmail.com","sravanthi_chede@yahoo.com",
            "kumarbrajkishor96@gmail.com", "arun9948089348@gmail.com",
            "sreecharan0311@gmail.com","shivagedela@gmail.com",
            "dineshchevvakula24@gmail.com","dubeysaurav.98@gmail.com",
            "parthwazurkar@gmail.com",
            "mrselukar@gmail.com","kunal17058@gmail.com",
            "sunnydhoke22@gmail.com","22sanketkale@gmail.com",
            "vaibhavagasti@gmail.com","atharvcd@gmail.com","sanketsinha2211@gmail.com"}; // list of recipient email addresses
        String subject = args[0];
        String body = args[1];

        sendFromGMail(from, pass, to, subject, body);
    }

    private static void sendFromGMail(String from, String pass, String[] to, String subject, String body) {
        
        
        Properties props = System.getProperties();
        String host = "smtp.gmail.com";
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.user", from);
        props.put("mail.smtp.password", pass);
        props.put("mail.smtp.port", "465");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");

        
        Session session = Session.getDefaultInstance(props);
        //session.setDebug(true);
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

            message.setSubject(subject);
            message.setText(body);
            
            System.out.println("g");
            
            
            Transport transport = session.getTransport("smtp");
            transport.connect(host, from, pass);
            
            System.out.println("h");
            
            
            transport.sendMessage(message, message.getAllRecipients());
            
            System.out.println("i");
            
            
            transport.close();
        }
        catch (AddressException ae) {
            ae.printStackTrace();
        }
        catch (MessagingException me) {
            me.printStackTrace();
        }
    }
    
    
    
    
}
