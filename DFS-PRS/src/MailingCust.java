import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
//import java.util.List;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class MailCust
 */
@WebServlet("/MailingCust")
public class MailingCust extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		ArrayList<String> too = new ArrayList<String>();
		String temp="";
		int a_size=0;
		int i=0;

		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/PRS","root","root123"); 
			Statement stmt = con.createStatement();	
			ResultSet rs= stmt.executeQuery("select Email from Customer_Details_ToRate");
			//int i=stmt.executeUpdate("select * from AdminReg ");
			while (rs.next()) {
				temp = rs.getString("Email");
				too.add(temp);
				//++i;
			}
			a_size = too.size();
			
		}catch(Exception e1){
			System.out.println(e1);
		}
		
		String from="allpurposemailing@gmail.com";
 		String password="silence@24";
 		String sub="Thanks for Using Our Product";

 		Properties props = new Properties();    
        props.put("mail.smtp.host", "smtp.gmail.com");    
        props.put("mail.smtp.socketFactory.port", "465");    
        props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");    
        props.put("mail.smtp.auth", "true");   
        props.put("mail.smtp.port", "465"); 

        Session sessions = Session.getInstance(props,    
           new javax.mail.Authenticator() {    
           protected PasswordAuthentication getPasswordAuthentication(){    
           return new PasswordAuthentication(from,password);  
           }    
          });
       for(i=0;i<a_size;i++) {
	        try {    
	           MimeMessage message = new MimeMessage(sessions);    
	           message.addRecipient(Message.RecipientType.TO,new InternetAddress(too.get(i)));    
	           message.setSubject(sub);    
	           message.setText("hi this is your link:  http://localhost:8080/DFS-Pro/login.jsp");    
	           //send message  
	           Transport.send(message);    
	           System.out.println("message sent successfully");    
	          } catch (MessagingException e) {throw new RuntimeException(e);}
       }
       
       getServletContext().getRequestDispatcher("/index.jsp").forward(
               request, response);
	}
}
