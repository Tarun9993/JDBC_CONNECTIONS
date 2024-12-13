package CrudOperations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class delete {
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
			System.out.println("Enter Table Name: ");
			String sql ="delete from "+sc.next() +" where id = ?";
			pmst = conn.prepareStatement(sql);
			System.out.println("Enter id: ");
			pmst.setInt(1, sc.nextInt());
			int i = pmst.executeUpdate();
			if(i > 0) {
				System.out.println("Successfully deleted");
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
