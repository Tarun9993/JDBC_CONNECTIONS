package CrudOperations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class DropDataBase {
	private static final String Driver = "com.mysql.cj.jdbc.Driver";
	  private static final String url = "jdbc:mysql://localhost:3306/";
	  private static final String user = "root";
	  private static final String password = "root";
	  private static Connection conn;
	  private static PreparedStatement pmst;
  public static void main(String[] args) {
	  
	  try {
		  Scanner sc = new Scanner(System.in);
		  System.out.println("Enter Database:");
		  String sql = "drop database "+sc.next();
		  Class.forName(Driver);
		   conn = DriverManager.getConnection(url,user,password); 
		   pmst = conn.prepareStatement(sql);
		  int i = pmst.executeUpdate();
		  if(i == 0) {
			  System.out.println("Successfully Delete the db");
		  }
		  else {
			  System.out.println("Eroor..!");
		  }
		  pmst.close();
		  conn.close();
	  }catch(Exception e) {
		  e.printStackTrace();
	  }
}
}
