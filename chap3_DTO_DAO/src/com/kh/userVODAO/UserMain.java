package com.kh.userVODAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class UserMain {

	public static void main(String[] args) {
		UserMain um = new UserMain();
		//um.selectAll();
		//um.insertRun();
		um.selectScanner();
	}
		
		public boolean checkEmail(String email) throws SQLException {
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String dbUserName = "khcafe";
			String dbPassWord = "khcafe";
			Connection cc = DriverManager.getConnection(url, dbUserName, dbPassWord);
			
			String sql = "SELECT COUNT(*) FROM USERINFO WHERE email=?";
			PreparedStatement st = cc.prepareStatement(sql);
			st.setString(1, email);
			ResultSet rs = st.executeQuery();
			if(rs.next()) {
				int count = rs.getInt(1);
				return count > 0; //1�̻��̸� true
			}
			return false;
		}
		public boolean checkId(int userId) throws SQLException {
		//1.DB����
		//2.SQL
		//3.if Ȱ���ؼ� Result.next()
		//return > 0 1�̻��̸� ��ġ
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String dbUserName = "khcafe";
		String dbPassWord = "khcafe";
		Connection cc = DriverManager.getConnection(url, dbUserName, dbPassWord);
			
			String sql = "SELECT count(*) FROM userinfo WHERE user_id = ?";
			PreparedStatement st = cc.prepareStatement(sql);
			
			st.setInt(1, userId);
			
			ResultSet rs = st.executeQuery();
			
			if(rs.next()) { //���࿡ ���� ���� �ִٸ�
				int id = rs.getInt(1);
				return id > 0; // 1 �̻��̸� true
			}
			// return > 0 1�̻��̸� ��ġ
			return false; //��ġ���� ���� ��
	}
	public void selectScanner() {
		//1.DB ���� URL, USERNAME, PASSWORD
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String dbUserName = "khcafe";
		String dbPassWord = "khcafe";

		try {
			Connection cc = DriverManager.getConnection(url, dbUserName, dbPassWord);
			Scanner sc = new Scanner(System.in);
			
			while(true) {
				
				System.out.println("User ID�� �Է����ּ���.");
				String inputID = sc.nextLine();
				
				//���࿡ e�� �Է��ߴٸ� 
				//if("e" == input || "e" == input) {
				if("e".equalsIgnoreCase(inputID)) {//e �Ǵ� E �Ѵ� ������� �� equalsIgnoreCase
					System.out.println("�����ϰڽ��ϴ�.");
					break; //break�� ������ ������� �ʰ� �����ϰڽ��ϴ�. ��� ������ ��� ��
				}

				int userId = Integer.parseInt(inputID);
				System.out.println("Email�� �Է����ּ���.");
				
				String inputEmail = sc.nextLine();
				String email = inputEmail;
				//select �� ����ϱ�
				String sql = "SELECT * FROM userinfo WHERE user_id = ? and email = ?";
				PreparedStatement st = cc.prepareStatement(sql);
				st.setInt(1, userId);
				st.setString(2, email);
				ResultSet rs = st.executeQuery();
			
				
				//selectOne if
				if(rs.next()) {
					System.out.println("user ID : " +  rs.getInt("user_id"));
					System.out.println("UserName : " + rs.getString("user_name"));
					System.out.println("Email : " + rs.getString("email"));
					System.out.println("Registration Date : " + rs.getDate("reg_date"));
					System.out.println();
				} else {
					//boolean ID or Email �ϳ��� ��ġ���� �ʴ� ��� ó��
					boolean idTrue = checkId(userId);
					boolean emailTrue = checkEmail(email);
					if(!idTrue && emailTrue) {
						System.out.println("��ġ���� �ʴ� User ID �Դϴ�.");
					} else if (idTrue && !emailTrue) {
						System.out.println("��ġ���� �ʴ� User Email �Դϴ�.");
						System.out.println();
					} else {
						System.out.println(idTrue);
						System.out.println("��ġ�ϴ� User Id�� email�� ã�� �� �����ϴ�.");
						System.out.println();
					}
					System.out.println("�����ϰ� �ʹٸ� Ư������ ���� [e] �Է�");
					System.out.println();
				}
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void selectAll() {
		//1.DB ���� URL, USERNAME, PASSWORD
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String dbUserName = "khcafe";
		String dbPassWord = "khcafe";
		
		try {
			Connection connection = DriverManager.getConnection(url, dbUserName, dbPassWord);
			UserDAO userDAO = new UserDAO(connection);
			List<UserVO> users = userDAO.getAllUsers();
			for(UserVO u : users) {
				System.out.println("User ID : " + u.getUserId());
				System.out.println("User Name : " + u.getUserName());
				System.out.println("Email : " + u.getEmail());
				System.out.println("Reg_Date : " + u.getRegDate());
				System.out.println();
			}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void insertRun() {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String dbUserName = "khcafe";
		String dbPassWord = "khcafe";
		
		try {
			Connection connection = DriverManager.getConnection(url, dbUserName, dbPassWord);
			
			UserDAO userDao = new UserDAO(connection);
			
			Scanner sc = new Scanner(System.in);
			System.out.println("UserID : ");
			int userId = sc.nextInt();
			
			System.out.println("���̵� �Է� ���ּ��� : ");
			String userName = sc.next();
			
			System.out.println("ȸ�������� ���� �� �������ϴ�.");
			System.out.println("���������� �̸��� �ۼ����ּ���.");
			String email = sc.next();
			
			Date regDate = new Date(); //util date import, ���� ��¥�� �ð��� ����Ѵٴ� �ǹ�
			
			//DB�� ��� ���� �ν��Ͻ� ���� �� �ۼ� ���� ���� �����ϱ�
			UserVO newUser = new UserVO();
			newUser.setUserId(userId);
			newUser.setUserName(userName);
			newUser.setEmail(email);
			newUser.setRegDate(regDate);
			
			//�����Ͱ� ���������� ������ boolean�� ����ؼ� Ȯ��
			
			if(userDao.createUser(newUser)) { //true
				System.out.println("������ ���������� ��ϵǾ����ϴ�.");
			} else {
				System.out.println("���� ��Ͽ� �����Ͽ����ϴ�.");
			}
			
			//���� �ݱ�
			connection.close();
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	
}
