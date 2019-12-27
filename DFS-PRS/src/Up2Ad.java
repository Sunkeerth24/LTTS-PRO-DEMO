import java.io.File;
import java.io.IOException;

import javax.mail.MessagingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import javax.swing.JOptionPane;

import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

@WebServlet("/Up2Ad")
@MultipartConfig(fileSizeThreshold=1024*1024*10, 	// 10 MB 
                 maxFileSize=1024*1024*50,      	// 50 MB
                 maxRequestSize=1024*1024*100)   	// 100 MB
public class Up2Ad extends HttpServlet {
 
    private static final long serialVersionUID = 205242440643911308L;
	
    /**
     * Directory where uploaded files will be saved, its relative to
     * the web application directory.
     */
   // private static final String UPLOAD_DIR = "uploads";
     
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        // gets absolute path of the web application
    	
    	String to = "bsunkeerthkumar.24@gmail.com";

        // Sender's email ID needs to be mentioned
        String from = "allpurposemailing@gmail.com";

       // final String username = "B Sunkeerth Kumar";//change accordingly
        final String password = "silence@24";//change accordingly

        // Assuming you are sending email through relay.jangosmtp.net
       

        Properties props = new Properties();    
        props.put("mail.smtp.host", "smtp.gmail.com");    
        props.put("mail.smtp.socketFactory.port", "465");    
        props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");    
        props.put("mail.smtp.auth", "true");   
        props.put("mail.smtp.port", "465"); 

        // Get the Session object.
        Session session = Session.getInstance(props,
           new javax.mail.Authenticator() {
              protected PasswordAuthentication getPasswordAuthentication() {
                 return new PasswordAuthentication(from, password);
              }
           });

        try {
           // Create a default MimeMessage object.
           Message message = new MimeMessage(session);

           // Set From: header field of the header.
           message.setFrom(new InternetAddress(from));

           // Set To: header field of the header.
           message.setRecipients(Message.RecipientType.TO,
              InternetAddress.parse(to));

           // Set Subject: header field
           message.setSubject("Please Collect Rating of these Users");

           // Create the message part
           BodyPart messageBodyPart = new MimeBodyPart();

           // Now set the actual message
           messageBodyPart.setText("HI,"
           		+ "I've attached the list of users with this mail.\n Please give us their feedBack.\n Thank You.");

           // Create a multipar message
           Multipart multipart = new MimeMultipart();

           // Set text message part
           multipart.addBodyPart(messageBodyPart);

           // Part two is attachment
           messageBodyPart = new MimeBodyPart();
           String filename = "C:\\ECLIPSE-PRO\\DFS-PRS\\WebContent\\C2Ad_DB\\List_Rate.csv";
           DataSource source = new FileDataSource(filename);
           messageBodyPart.setDataHandler(new DataHandler(source));
           messageBodyPart.setFileName(filename);
           multipart.addBodyPart(messageBodyPart);

           // Send the complete message parts
           message.setContent(multipart);

           // Send message
           Transport.send(message);

           System.out.println("Sent message successfully....");
    
        } catch (MessagingException e) {
           throw new RuntimeException(e);
        }
    	
    	
    	
        String applicationPath = "C:\\ECLIPSE-PRO\\DFS-PRS\\WebContent\\Ad2DB";
        // constructs path of the directory to save uploaded file
        String uploadFilePath = applicationPath + File.separator ;
         
        // creates the save directory if it does not exists
        File fileSaveDir = new File(uploadFilePath);
        if (!fileSaveDir.exists()) {
            fileSaveDir.mkdirs();
        }
        System.out.println("Upload File Directory="+fileSaveDir.getAbsolutePath());
        
        //Get all the parts from request and write it to the file on server
        for (Part part : request.getParts()) {
            String fileName = getFileName(part);
            part.write(uploadFilePath + File.separator + fileName);
        }
        JOptionPane.showMessageDialog(null, "Successfuly Sent to Admin");
        request.setAttribute("message", "File uploaded successfully!");
        getServletContext().getRequestDispatcher("/index.jsp").forward(
                request, response);
    }
 
    /**
     * Utility method to get file name from HTTP header content-disposition
     */
    private String getFileName(Part part) {
        String contentDisp = part.getHeader("content-disposition");
        System.out.println("content-disposition header= "+contentDisp);
        String[] tokens = contentDisp.split(";");
        for (String token : tokens) {
            if (token.trim().startsWith("filename")) {
                return token.substring(token.indexOf("=") + 2, token.length()-1);
            }
        }
        
        return "";
    }
}