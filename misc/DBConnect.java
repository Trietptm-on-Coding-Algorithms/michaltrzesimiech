package integration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBConnect {

//	https://www.ntu.edu.sg/home/ehchua/programming/java/JDBC_Basic.html
	
	private Connection con;
	private Statement st;
	private ResultSet rs;

	public DBConnect() {

		try {
			Class.forName("com.mysql.jdbc.Driver");

			con = DriverManager
					.getConnection(
							"jdbc:mysql://www.impossiblearn.com:3306/impossiblearn",
//							"jdbc:mysql://131753.console.dc2.gpaas.net:3306/impossiblearn",

							"root", "");
			st = con.createStatement();

		} catch (Exception ex) {
			System.out.println("Error: " + ex);
		}
	}

//	public void getData() {
//		try {
//
//			String query = "select * from *";
//			rs = st.executeQuery(query);
//			System.out.println("Records from DB: ");
//			while (rs.next()) {
//				String name = rs.getString("name");
//				String age = rs.getString("age");
//				System.out.println(name + age);
//			}
//
//		} catch (Exception ex) {
//			System.out.println("Error");
//		}
//	}
}
