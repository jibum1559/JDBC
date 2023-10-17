package com.kh.db.oraclesample;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBConnection {

	public static void main(String[] args) {
		
		//selectBank();
		//selectKhcafe();
		//selectIf();
		//selectWhere();
		selectIntWhere();
	}		
	static void selectBank() {
		//1. 드라이버 연결 :          Oracle JDBC  드라이버    클래스 이름
				//String driver = "oracle.jdbc.driver.OracleDriver"; 밑에 url 을 쓰면 안써도 됨.
				//2. 오라클 내 컴퓨터 연결 : 데이터베이스 연결 정보
				//								 나의IP주소:port번호
				String url = "jdbc:oracle:thin:@localhost:1521:xe"; // thin은 driver 역할을 함. 또다른 하나는 oci가 있음
				String user = "KHBANK";
				String password = "KHBANK";
				Connection con = null;
				try {
					//연결을 사용하여 쿼리 실행 또는 데이터베이스 작업 수행
					con = DriverManager.getConnection(url, user, password);
					System.out.println("데이터베이스 연결 성공!");
					
					//SELECT 쿼리
					String selectQuery = "SELECT * FROM BANK";
					PreparedStatement selectState = con.prepareStatement(selectQuery);
					ResultSet result = selectState.executeQuery();
					//result.next() : result 객체에서 다음 행(row)으로 이동. 다음 행이 있으면 true 반환, 그렇지 않으면 false 반환
					while(result.next()) {
						//KHBANK에 있는 BANK 테이블 = 결과집합에서 account_id를 가져옴
						int accountID = result.getInt("account_id");
						// 1. 함께해보기 : accountNumber 
						String accountNumber = result.getString("account_number");
						String accountName = result.getString("account_name");
						double balance = result.getDouble("balance");
						
						// 2. 함께해보기 : branchName
						String branchName = result.getString("branch_name");
						
						// 3. 함께해보기 : java.sql import Date lastTransactionDate 가져오기 // 날짜 
						Date lastTransactionDate = result.getDate("Last_Transaction_Date");
						System.out.println("ACCOUNT_ID : " + accountID + ", ACCOUNT_NAME : " + accountName + ", BALANCE : " + balance + 
										   ", ACCOUNT_NUMBER : " + accountNumber + ", BRANCH_NAME : " + branchName + ", LAST_TRANSACTION_DATE : " + lastTransactionDate);
						}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	}
	static void selectKhcafe() {
		//메뉴랑 오더랑 카페 가져오기
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "khcafe";
		String password = "khcafe";
		Connection con = null;
		try {
			con = DriverManager.getConnection(url, user, password);
			System.out.println("카페 데이터베이스 연결 성공!!");
			
			String selectQuery = "SELECT * FROM MENU order by menu_id";
			PreparedStatement selectState = con.prepareStatement(selectQuery);
			ResultSet result = selectState.executeQuery();
			

			while(result.next()) {
				int menuID = result.getInt("menu_id");
				int cafeID = result.getInt("cafe_id");
				String menuName = result.getString("menu_name");
				int price = result.getInt("price");
				String description = result.getString("description");
				System.out.println("MENU_ID : " + menuID + ", CAFE_ID : " + cafeID + ", MENU_NAME : " + menuName + ", PRICE : " + price + ", DESCRIPTION : " + description);
			
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	static void selectIf() {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "KHBANK";
		String password = "KHBANK";
		Connection con = null;
		
		try {
			con = DriverManager.getConnection(url, user, password);
			//where절 사용해서 조건 추가
			String selectQuery = "SELECT * FROM BANK WHERE account_id=?";
			PreparedStatement selectState = con.prepareStatement(selectQuery);
			
			//여기에 원하는 조건의 account_id 설정
			int targetAID = 9; //AID == account_id 값을 해당 숫자로 가져오기
			
			//조건 설정
			selectState.setInt(1, targetAID); // 1은 값의 위치
			
			ResultSet result = selectState.executeQuery();
			if (result.next()) {
				int a = result.getInt("account_id");       //원래 a 변수명은 좋지 않음
				String b = result.getString("account_number");
				String c = result.getString("account_name");
				double d = result.getDouble("balance");
				String e = result.getString("branch_name");
				Date f = result.getDate("last_transaction_date");
				System.out.println("ACCOUNT_ID : " + a + ", ACCOUNT_NUMBER : " + b + ", ACCOUNT_NAME : " + c + ", BALANCE : " + d + 
									", BRANCH_NAME : " + e + ", LAST_TRANSACTION_DATE : " + f);
			} else {
				System.out.println("조건에 해당하는 데이터가 없습니다.");
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	static void selectWhere() {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "KHBANK";
		String password = "KHBANK";
		Connection con = null;
		
		try {
			con = DriverManager.getConnection(url, user, password);
			//where절 사용해서 조건 추가
			String selectQuery = "SELECT * FROM BANK WHERE account_number in(?,?,?) order by LAST_TRANSACTION_DATE "; //order by 순서가 기준이되어 출력
			PreparedStatement selectState = con.prepareStatement(selectQuery);
			
			//조건 설정
			String[] targetAN = {"1234567890","5555666777","4444555566"};
			selectState.setString(1, targetAN[0]); //여기에 앞 숫자는 위 쿼리문 in 내부 순서. 단, 숫자가 어떻든 값의 순서는 바뀌지 않음
			selectState.setString(2, targetAN[1]);	
			selectState.setString(3, targetAN[2]);	
			ResultSet result = selectState.executeQuery();
			
			//값 존재 여부, while문에 값이 안나오는 경우가 있을 수 있음. 그럴 때 값이 있는지 없는지 해당 if문을 사용하여 확인 가능
			if (!result.isBeforeFirst()) {
				System.out.println("데이터 없음"); 
			}
			while (result.next()) {
				int a = result.getInt("account_id");      	 //원래 a,b, 등.. 변수명은 좋지 않음
				String b = result.getString("account_number");
				String c = result.getString("account_name");
				double d = result.getDouble("balance");
				String e = result.getString("branch_name");
				Date f = result.getDate("last_transaction_date");
				System.out.println("ACCOUNT_ID : " + a + ", ACCOUNT_NUMBER : " + b + ", ACCOUNT_NAME : " + c + ", BALANCE : " + d + 
									", BRANCH_NAME : " + e + ", LAST_TRANSACTION_DATE : " + f);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	static void selectIntWhere() {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "KHBANK";
		String password = "KHBANK";
		Connection con = null;
		
		try {
			con = DriverManager.getConnection(url, user, password);
			System.out.println("KHBANK 연결에 성공하였습니다.");
			
			String selectQuery = "SELECT * FROM BANK WHERE account_id in (?,?)";	
			PreparedStatement selecState = con.prepareStatement(selectQuery);
			
			int[] targetAID = {1,2};
			
			selecState.setInt(1, targetAID[0]);
			selecState.setInt(2, targetAID[1]);
			ResultSet result = selecState.executeQuery();
			
			while(result.next()) {
				int a = result.getInt("account_id");
				String b = result.getString("account_number");
				String c = result.getString("account_name");
				double d = result.getDouble("balance");
				String e = result.getString("branch_name");
				Date f = result.getDate("last_transaction_date");
				System.out.println("ACCOUNT_ID : " + a + ", ACCOUNT_NUMBER : " + b + ", ACCOUNT_NAME : " + c + ", BALANCE : " + d + 
									", BRANCH_NAME : " + e + ", LAST_TRANSACTION_DATE : " + f);
			}
				
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
