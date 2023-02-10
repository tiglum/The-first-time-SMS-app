

package harar.pharmaceutica.wholesaler;
import java.sql.DriverManager;
import java.sql.Connection;
public class Connect {
	private static Connection connect;
	
	public static Connection getConnect()
	{
		 if(connect== null){          
			                                       
			 try     
		 	 {
				 String url = "jdbc:mysql://localhost:3306/HarardrugDatabase";
				 String username= "root";
				 String password = "root";
				 DriverManager.registerDriver(new com.mysql.jdbc.Driver());
				 connect = DriverManager.getConnection(url, username, password);
			 }
			 catch(Exception ex){
				 System.out.println(ex);
				 
			 }
		
		 }
		 return connect;
	}
	

}
