package CrudOperations;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;
public class createDB {
   private static final String Driver = "com.mysql.cj.jdbc.Driver";
   private static final String url = "jdbc:mysql://localhost:3306/";
   private static final String userName = "root";
   private static final String password = "root";
   private static Connection conn;
   private static PreparedStatement pmst;
	  public static void main(String[] args) {
			try {
			  Scanner sc = new Scanner(System.in);
				Class.forName(Driver);
				System.out.println("Enter Dtabase Name: ");
				conn=DriverManager.getConnection(url,userName,password);
				String sql="create database "+sc.next();
				pmst=conn.prepareStatement(sql);
				int i = pmst.executeUpdate();
				if(i > 0) {
					System.out.println("SuccessFully Created");
				}
				else {
					System.out.println("Error.!!");
				}
				pmst.close();
				conn.close();
			} catch (Exception e) {
				System.out.println("DataBase already exist");
			}
		}
}
