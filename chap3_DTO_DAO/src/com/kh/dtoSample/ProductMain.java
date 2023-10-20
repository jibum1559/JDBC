package com.kh.dtoSample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ProductMain {

	public static void main(String[] args) {
		String jdbc_oracle_url = "jdbc:oracle:thin:@localhost:1521:xe";
		String username = "khcafe";
		String password = "khcafe";
		
		try {
			Connection con = DriverManager.getConnection(jdbc_oracle_url, username, password);
			
			ProductView view = new ProductView();
			
			ProductController controller = new ProductController(con, view);
			
			controller.displayALLProducts();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
