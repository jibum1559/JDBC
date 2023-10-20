package com.kh.dtoSample;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CafeModel {
	
	private Connection connection;
	
	public CafeModel(Connection connection) {
		this.connection = connection;
	}
	
	//자료형 자리에 List<CafeDTO>를 씀으로써 모든 자료형을 담겠다는 의미. 메모리 구조의 관계 확인하기. 최하단에 get에 대한 return을 넣어준다.
	public List<CafeDTO> getCafes() {  
		List<CafeDTO> cafes = new ArrayList<>();
		String query = "SELECT * FROM cafes";
		try {
			PreparedStatement st = connection.prepareStatement(query);
			ResultSet result = st.executeQuery(query);
			while(result.next()) {
				//기존에는 예약어나 참조어를 사용해서 넣어줄 값을 작성했지만 
				//예를들어 int cafeId = result.getInt("cafe_id");
				//이제는 DTO를 활용하여 예약어나 참조어를 캡슐화(보호) 하여 따로 DTO로 작성해준다.
				//그리고 DTO로 작성해준 객체를 인스턴스화하여 객체 안에 있는 멤버 변수를 호출한
				CafeDTO cafe = new CafeDTO();
				
				cafe.setCafeId(result.getInt("cafe_id"));
				cafe.setCafeName(result.getString("name"));
				cafe.setAddress(result.getString("address"));
				cafe.setPhoneNumber(result.getString("phone_number"));
				cafe.setOperatingHours(result.getString("operating_hours"));
				cafes.add(cafe); // 위 32~36 값을 다 더한다는 의미
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cafes;
	}

}
