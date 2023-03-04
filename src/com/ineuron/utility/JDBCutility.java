package com.ineuron.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCutility {

	private JDBCutility() {

	}

	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
	}
	public static Connection getConnection() {
		Connection conn=null;
		String url="jdbc:mysql:///inuron";
		String userName="root";
		String passWord="root";
		try {
			conn=DriverManager.getConnection(url,userName,passWord);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;

	}

}
