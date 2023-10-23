package com.kh.userVODAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserSelectDAO {
	
	private Connection connection;
	
	public UserSelectDAO(Connection connection) {
		this.connection = connection;
	}
	
	public List<UserSelectVO> userSelect() {
		List<UserSelectVO> user = new ArrayList<>();
		String sql = "SELECT * FROM userinfo";
		try {
			PreparedStatement st = connection.prepareStatement(sql);
			ResultSet result = st.executeQuery();
			
			while(result.next()) {
				UserSelectVO userVo = new UserSelectVO();
				userVo.setUserId(result.getInt("user_id"));
				userVo.setUserName(result.getString("user_name"));
				userVo.setEmail(result.getString("email"));
				userVo.setRegDate(result.getDate("reg_date"));
				user.add(userVo);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}
	
}
