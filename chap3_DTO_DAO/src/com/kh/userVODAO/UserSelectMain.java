package com.kh.userVODAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class UserSelectMain {

	public static void main(String[] args) {
		
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String dbUserName = "khcafe";
		String dbPassWord = "khcafe";
		
		try {
			Connection connection = DriverManager.getConnection(url, dbUserName, dbPassWord);
			UserSelectDAO userSelectDAO = new UserSelectDAO(connection);
			
			UserSelectVO selectUser = new UserSelectVO();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
