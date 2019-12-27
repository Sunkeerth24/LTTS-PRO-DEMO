import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB2Connection {

	public static Connection getConnection() throws SQLException, ClassNotFoundException
	{
			Class.forName("com.mysql.jdbc.Driver");

			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/PRS", "root", "root123");

			return connection;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
			try
	        {
			        getConnection();
	        }
	        catch (SQLException | ClassNotFoundException e)
	        {
			        e.printStackTrace();
	        }
	}

}
