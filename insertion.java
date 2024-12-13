package CrudOperations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class insertion {
  private static final String Driver = "com.mysql.cj.jdbc.Driver";
  private static final String user = "root";
  private static final String password = "root";
  private static final String url = "jdbc:mysql://localhost:3306/crud";
  private static  Connection conn;
  private static PreparedStatement pmst;
  
  public static void main(String[] args) {
	 
	  try {
		Scanner sc = new Scanner(System.in);
		Class.forName(Driver);
		conn = DriverManager.getConnection(url, user, password);
		String sql ="insert into crudtable (name,email,password) values(?,?,?)";
		pmst = conn.prepareStatement(sql);
		System.out.println("Enter Name: ");
		pmst.setString(1, sc.next());
		System.out.println("Enter email: ");
		pmst.setString(2, sc.next());
		System.out.println("Enter password: ");
		pmst.setString(3, sc.next());
		int i = pmst.executeUpdate();
		
		if(i > 0) {
			System.out.println("Data is inserted");
		}
		else {
			System.out.println("error");
		}
		conn.close();
		pmst.close();
		sc.close();
	} catch (Exception e) {
		e.printStackTrace();
	}
}
}
