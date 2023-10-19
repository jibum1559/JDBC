package chap2_MVC;

import java.util.Scanner;

public class cafeView {
	//cafeModel �̶�� Ŭ������ ������ ���� ���� ��������� ī�� ���� �߰���
	public cafeModel model;
	//model �Ű������� ���� �� �ִ� �����ڸ� ����������
	public cafeView(cafeModel model) {
		this.model = model;
	}
	//cname,address,phone_number,operating_hours
	public void addCafeName() {
		Scanner sc = new Scanner(System.in);
		System.out.println("ī�� ������ �Է��ϼ���.");
		
		System.out.println("��ȣ�� : ");
		String name = sc.nextLine();
		
		System.out.println("ī�� �ּ� : ");
		String address = sc.nextLine();
		
		System.out.println("ī�� ����ó : ");
		String phoneNumber = sc.nextLine();
		
		System.out.println("� �ð� : ");
		String operatingHours = sc.nextLine();
		
		//ī�� �𵨿��� inserCafe ��� �޼��带 ������ �;���
		model.insertCafe(name, address, phoneNumber, operatingHours);
		System.out.println("ī�䰡 ���������� �߰��Ǿ����ϴ�.");
	}

	public void updateMenu() {
		Scanner sc = new Scanner(System.in);
		System.out.println("�޴� ������ ������Ʈ�ϼ���.");

		System.out.println("ī�� ID : ");
		int cafeId = sc.nextInt();
		
		System.out.println("�޴� ID : ");
		int menuId = sc.nextInt();
		
		sc.nextLine();
		System.out.println("������ �޴� ���� : ");
		String description = sc.next();
 
		//model �� �ִ� UpdateMenu�� ������ͼ�
		//����ڰ� �ۼ��Ѽ��� ���� �߰��ϱ�
		model.UpdateMenu(description, menuId, cafeId);
		System.out.println("�޴� ������ ������Ʈ �Ǿ����ϴ�.");
	}

	//����ڰ� ��ð� ������ ȭ�� Scanner �̿��ؼ� �����
	public void updateCafe() {
		//model.UpdateCafe(������ �Ķ���� ���� ���� ��ĳ�� �� �ֱ�);
		Scanner sc = new Scanner(System.in);
		System.out.println("ī�� ID�� �Է� �� ��ð��� ������Ʈ�ϼ���.");
		
		System.out.println("ī�� ID : ");
		int cafeId = sc.nextInt();
		
		System.out.println("� �ð� : ");
		String operatingHours = sc.next();
		
		model.UpdateCafe(cafeId,operatingHours);
		System.out.println("� �ð��� ������Ʈ �Ǿ����ϴ�.");
		
		
	}

	public void deleteCafe() {
		Scanner sc = new Scanner(System.in);
		System.out.println("ī�並 �����ϰڽ��ϴ�.");
		System.out.println("������ ī���� ID�� �Է��ϼ���.");
		int cafeId = Integer.parseInt(sc.next());  //String���� ������ ��(��, 010���� 0 ����� ��)
		//int cafeId_other = sc.nextInt(); // 2���� ���
		
		model.deleteCafe(cafeId);
		System.out.println("������ �Ϸ�Ǿ����ϴ�.");
	}

	public void deleteMenu() {
		Scanner sc = new Scanner(System.in);
		System.out.println("�޴� ������ �ϰڽ��ϴ�.");
		System.out.println("������ �޴��� ID�� �Է��ϼ���.");
		int menuId = Integer.parseInt(sc.next());
		
		model.DeleteMenu(menuId);
		System.out.println("�޴��� �����Ǿ����ϴ�.");
	}
	
	public void deleteOrder() {
		Scanner sc = new Scanner(System.in);
		System.out.println("������ �ֹ� ID�� �Է����ּ���.");
		int orderId = Integer.parseInt(sc.nextLine());
		
		model.DeleteOrder(orderId);
	}
}
