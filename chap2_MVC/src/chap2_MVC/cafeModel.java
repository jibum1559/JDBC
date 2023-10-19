package chap2_MVC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class cafeModel {
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String username = "khcafe";
	String password = "khcafe";
	
	public void insertCafe(String cname, String address, String phone_number, String operating_hours) {
		try {
			Connection con = DriverManager.getConnection(url, username, password);
			System.out.println("데이터베이스 연결 성공!");
			String sql = "INSERT INTO oldcafe (cname,address,phone_number,operating_hours)"
					+ "VALUES(?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, cname);
			ps.setString(2, address);
			ps.setString(3, phone_number);
			ps.setString(4, operating_hours);
			ps.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void UpdateMenu(String description, int menuId, int cafeId) {
		try {
			Connection con = DriverManager.getConnection(url, username, password);
			System.out.println("데이터베이스 연결 성공!");
			String sql = "UPDATE oldmenu SET description = ? WHERE menu_id = ? AND cafe_id = ?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, description);
			st.setInt(2, menuId);
			st.setInt(3, cafeId);
			st.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	//카페 운영시간 수정하기
	public void UpdateCafe(int cafe_id, String operating_hours) {
		try {
			Connection con = DriverManager.getConnection(url, username, password);
			System.out.println("데이터베이스 연결 성공!");
			String sql = "UPDATE oldcafe SET operating_hours = ? WHERE cafe_id = ?";
			PreparedStatement st2 = con.prepareStatement(sql);
			st2.setString(1, operating_hours);
			st2.setInt(2, cafe_id);
			st2.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void deleteCafe(int cafeId) {
		try {
			Connection con = DriverManager.getConnection(url, username, password);
			String sql = "DELETE FROM oldcafe WHERE cafe_id = ?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, cafeId);
			st.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void DeleteMenu(int menuId) {
		try {
			Connection con = DriverManager.getConnection(url, username, password);
			System.out.println("데이터베이스 연결 성공!");
			String sql = "DELETE FROM menu WHERE menu_id = ?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, menuId);
			st.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void DeleteOrder(int order_id) {
		try {
			Connection con = DriverManager.getConnection(url, username, password);
			System.out.println("데이터베이스 연결 성공");
			String sql = "DELETE FROM orders WHERE order_id";
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, order_id);
			st.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
