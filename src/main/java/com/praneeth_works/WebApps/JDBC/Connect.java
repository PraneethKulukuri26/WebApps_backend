package com.praneeth_works.WebApps.JDBC;

import java.sql.*;


//@Component
public class Connect {
	
	private Connection con;
	private Statement st;
	
	public  Connect() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://135.181.247.221:3306/webapps", "praneeth", "Q0MJsX4yA@^H");
		st=con.createStatement();
		System.out.println("connected");
	}
	
	public ResultSet getData(String query) throws SQLException {
		return st.executeQuery(query);
	}
	
	public int insertData(String query) throws SQLException {
		return st.executeUpdate(query);
	}
	
	public void closeCon() throws SQLException {
		st.close();
		con.close();
		System.out.println("closed");
	}
}