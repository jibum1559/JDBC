package com.kh.dtoSample;
//CafeDTO : ������ ���� ��ü
public class CafeDTO {
	//model sql �� ���Ŀ� ���� �����͸� ĸ��ȭ�ϰ� getter setter�� Ȱ���Ͽ� �����͸� �����ϰ� �������� ����
	
	//�ʵ� ������� �ۼ�
	private int CafeId;
	private String cafeName;
	private String address;
	private String phoneNumber;
<<<<<<< HEAD
	private String operatingHours;  

	//������
	//1.�⺻ ������
	public CafeDTO () { 
=======
	private String operatingHours;

	//������
	//1.�⺻ ������
	public CafeDTO () {
>>>>>>> d1e7d1f1dfd893a9d4dcf23294771f5b54c2013e
		
	}
	//2.�Ķ���� ���� ���� ������
	public CafeDTO (int cafeId, String cafeName, String address, String phoneNumber, String operatingHours) {
		this.CafeId = cafeId;
		this.cafeName = cafeName;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.operatingHours = operatingHours;
	}
	//3.Getter Setter �޼���
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
	
	
	//@Override�� Ȱ���� toString �޼��� �߰�
	@Override
	public String toString() {
		return "CafeDTO";
		
	}
}
