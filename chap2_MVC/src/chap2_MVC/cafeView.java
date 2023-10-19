package chap2_MVC;

import java.util.Scanner;

public class cafeView {
	//cafeModel 이라는 클래스는 가지고 오기 위해 멤버변수로 카페 모델을 추가함
	public cafeModel model;
	//model 매개변수를 받을 수 있는 생성자를 만들어줘야함
	public cafeView(cafeModel model) {
		this.model = model;
	}
	//cname,address,phone_number,operating_hours
	public void addCafeName() {
		Scanner sc = new Scanner(System.in);
		System.out.println("카페 정보를 입력하세요.");
		
		System.out.println("상호명 : ");
		String name = sc.nextLine();
		
		System.out.println("카페 주소 : ");
		String address = sc.nextLine();
		
		System.out.println("카페 연락처 : ");
		String phoneNumber = sc.nextLine();
		
		System.out.println("운영 시간 : ");
		String operatingHours = sc.nextLine();
		
		//카페 모델에서 inserCafe 라는 메서드를 가지고 와야함
		model.insertCafe(name, address, phoneNumber, operatingHours);
		System.out.println("카페가 성공적으로 추가되었습니다.");
	}

	public void updateMenu() {
		Scanner sc = new Scanner(System.in);
		System.out.println("메뉴 설명을 업데이트하세요.");

		System.out.println("카페 ID : ");
		int cafeId = sc.nextInt();
		
		System.out.println("메뉴 ID : ");
		int menuId = sc.nextInt();
		
		sc.nextLine();
		System.out.println("수정할 메뉴 설명 : ");
		String description = sc.next();
 
		//model 에 있는 UpdateMenu를 가지고와서
		//사용자가 작성한수정 내용 추가하기
		model.UpdateMenu(description, menuId, cafeId);
		System.out.println("메뉴 설명이 업데이트 되었습니다.");
	}

	//사용자가 운영시간 수정할 화면 Scanner 이용해서 만들기
	public void updateCafe() {
		//model.UpdateCafe(설정한 파라미터 값에 맞춰 스캐너 값 넣기);
		Scanner sc = new Scanner(System.in);
		System.out.println("카페 ID를 입력 후 운영시간을 업데이트하세요.");
		
		System.out.println("카페 ID : ");
		int cafeId = sc.nextInt();
		
		System.out.println("운영 시간 : ");
		String operatingHours = sc.next();
		
		model.UpdateCafe(cafeId,operatingHours);
		System.out.println("운영 시간이 업데이트 되었습니다.");
		
		
	}

	public void deleteCafe() {
		Scanner sc = new Scanner(System.in);
		System.out.println("카페를 삭제하겠습니다.");
		System.out.println("삭제할 카페의 ID를 입력하세요.");
		int cafeId = Integer.parseInt(sc.next());  //String으로 변경할 때(예, 010에서 0 사라질 때)
		//int cafeId_other = sc.nextInt(); // 2가지 방법
		
		model.deleteCafe(cafeId);
		System.out.println("삭제가 완료되었습니다.");
	}

	public void deleteMenu() {
		Scanner sc = new Scanner(System.in);
		System.out.println("메뉴 삭제를 하겠습니다.");
		System.out.println("삭제할 메뉴의 ID를 입력하세요.");
		int menuId = Integer.parseInt(sc.next());
		
		model.DeleteMenu(menuId);
		System.out.println("메뉴가 삭제되었습니다.");
	}
	
	public void deleteOrder() {
		Scanner sc = new Scanner(System.in);
		System.out.println("삭제할 주문 ID를 입력해주세요.");
		int orderId = Integer.parseInt(sc.nextLine());
		
		model.DeleteOrder(orderId);
	}
}
