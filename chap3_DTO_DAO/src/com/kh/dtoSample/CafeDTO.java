package com.kh.dtoSample;
//CafeDTO : 데이터 전송 객체
public class CafeDTO {
	//model sql 열 형식에 맞춰 데이터를 캡슐화하고 getter setter를 활용하여 데이터를 저장하고 내보내는 공간
	
	//필드 멤버변수 작성
	private int CafeId;
	private String cafeName;
	private String address;
	private String phoneNumber;
<<<<<<< HEAD
	private String operatingHours;  

	//생성자
	//1.기본 생성자
	public CafeDTO () { 
=======
	private String operatingHours;

	//생성자
	//1.기본 생성자
	public CafeDTO () {
>>>>>>> d1e7d1f1dfd893a9d4dcf23294771f5b54c2013e
		
	}
	//2.파라미터 값을 받을 생성자
	public CafeDTO (int cafeId, String cafeName, String address, String phoneNumber, String operatingHours) {
		this.CafeId = cafeId;
		this.cafeName = cafeName;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.operatingHours = operatingHours;
	}
	//3.Getter Setter 메서드
	public int getCafeId() {
		return CafeId;
	}
	public void setCafeId(int cafeId) {
<<<<<<< HEAD
		this.CafeId = cafeId;
=======
		CafeId = cafeId;
>>>>>>> d1e7d1f1dfd893a9d4dcf23294771f5b54c2013e
	}
	
	public String getCafeName() {
		return cafeName;
	}
	public void setCafeName(String cafeName) {
		this.cafeName = cafeName;
	}
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public String getOperatingHours() {
		return operatingHours;
	}
	public void setOperatingHours(String operatingHours) {
		this.operatingHours = operatingHours;
	}
	
	
	//@Override를 활용한 toString 메서드 추가
	@Override
	public String toString() {
		return "CafeDTO";
		
	}
}
