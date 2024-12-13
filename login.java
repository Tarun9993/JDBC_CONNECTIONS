package CrudOperations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class login {
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
			System.out.println("Enter Email");
			String username = sc.next();
			System.out.println("Enter password");
			String password = sc.next();
			String sql ="select * from crudtable where email = ? and password = ?";
			pmst = conn.prepareStatement(sql);
			pmst.setString(1, username);
			pmst.setString(2, password);
			ResultSet rs = pmst.executeQuery();
			if(rs.next()) {
				System.out.println("Login successfully..");
			}
			else {
				System.out.println("Invalid Usser!!");
			}
			conn.close();
			pmst.close();
			sc.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	}
