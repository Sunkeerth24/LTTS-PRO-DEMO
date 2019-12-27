

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.opencsv.CSVReader;

/**
 * Servlet implementation class Insert2DB
 */
@WebServlet("/Insert2DB")
public class Insert2DB extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static void readCsv()
	{
		

			try (CSVReader reader = new CSVReader(new FileReader("List_Rate.csv"), ','); Connection connection = DB2Connection.getConnection();)
			{
					String insertQuery = "Insert into Customer_Details_ToRate (Cust_ID,P_ID,Name,Email,DOP) values (?,?,?,?,?)";
					PreparedStatement pstmt = connection.prepareStatement(insertQuery);
					String[] rowData = null;
					
					int i = 0;
					
					while((rowData = reader.readNext()) != null){
						
					for (String data : rowData)
					{
						
							pstmt.setString((i % 3) + 1, data);

							if (++i % 3 == 0)
									pstmt.addBatch();// add batch

						//	if (i % 30 == 0)// insert when the batch size is 10
							//		pstmt.executeBatch();
					}}
					System.out.println("Data Successfully Uploaded");
			}
			catch (Exception e)
			{
					e.printStackTrace();
			}

	}
	
	public static void readCsvUsingLoad()
	{
			try (Connection connection = DB2Connection.getConnection())
			{

					String loadQuery = "LOAD DATA LOCAL INFILE '" + "C://ECLIPSE-PRO/DFS-PRS/WebContent/Ad2DB/List_Rate.csv" + "' INTO TABLE Customer_Details_ToRate FIELDS TERMINATED BY ','"
									+ " LINES TERMINATED BY '\n' (Cust_ID,P_ID,Name,Email,DOP) ";
					System.out.println(loadQuery);
					Statement stmt = connection.createStatement();
					stmt.execute(loadQuery);
			}
			catch (Exception e)
			{
					e.printStackTrace();
			}
	}
	

	 protected void doPost(HttpServletRequest request,
	            HttpServletResponse response) throws ServletException, IOException {
		 
		 	readCsv();
			readCsvUsingLoad();
			//response.sendRedirect("http://www.google.com");
			getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
	 }

}
