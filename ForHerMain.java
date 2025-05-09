package javaproject;



import java.util.HashMap;
import java.util.Scanner;
import java.util.StringTokenizer;



public class ForHerMain {

	public static void main(String[] args) {
		String prod=null;
		String cnt = null;
		String name=null;
		String nickname = null;
		int code=null;
		Scanner sc=new Scanner(System.in);
		int select=0;
		HashMap<String,Integer>storage=new HashMap<String,Integer>();
		
		while (select!=4) {
			System.out.println("For Her에 오신 것을 환영합니다! 아래 번호를 먼저 선택해주세요.");
			System.out.println("1. 회원가입 2. 로그인 3. 불법촬영구역 등록 4. 불법촬영구역 조회 5. 여성전용공간 검색");
			System.out.println("6. 여성전용공간 리뷰 7. 질의응답 8. 공지사항 등록 9. 사용자 관리 10. 공지사항 등록 11. 여성전용공간 관리 : ");
			select=sc.nextInt();
			
		switch(select) {
		case 1:
			System.out.print("아이디 : "); prod=sc.next();
			System.out.print("비밀번호 : "); cnt=sc.next();
			System.out.print("이름 : "); name=sc.next();
			System.out.print("닉네임 : "); nickname=sc.next();
			System.out.print("주민번호 앞자리 7글자 : "); code=sc.nextInt();
			
			break;
		case 2:
			System.out.print("아이디 : "); prod=sc.next();
			System.out.print("비밀번호 : "); cnt=sc.next();
			System.out.println(prod+"님의 로그인이 성공적으로 완료되었습니다!");
			break;
		case 3:
			System.out.println("현황처리");
			break;
		case 4:
			System.out.println("종료처리");
			break;
		case 9:
			System.out.println("아이디 : "+prod+"비밀번호 : "+cnt+"이름 : "+name+"닉네임 : "+nickname+"주민번호 앞자리 7글자 :"+code);
			break;
		default : System.out.println("잘못된 입력입니다.");
		}
		
		
		}

	}
}