package javaproject;



import java.util.HashMap;
import java.util.Scanner;
import java.util.StringTokenizer;



public class ForHerMain {

	public static void main(String[] args) {
		String id=null;
		String passwords = null;
		String name=null;
		String nickname = null;
		int code=null;
		String camlocation;
		String details;
		Scanner sc=new Scanner(System.in);
		int select=0;
		HashMap<String,Integer>storage=new HashMap<String,Integer>();
		String womanonly;
		String ask;
		int num=null;
		String answer;
		String notice;
		womanonly.add(new WomanOnlys("대구 동구 동부로 777");
		womanonly.add(new WomanOnlys("경북 경산시 대학로 100");
		womanonly.add(new WomanOnlys("대구 남구 이천로 1길 11");
		
		while (select!=4) {
			System.out.println("For Her에 오신 것을 환영합니다! 아래 번호를 먼저 선택해주세요.");
			System.out.println("1. 회원가입 2. 로그인 3. 불법촬영구역 등록 4. 불법촬영구역 조회 5. 여성전용공간 검색");
			System.out.println("6. 여성전용공간 리뷰 7. 질의응답 8. 공지사항 등록 9. 사용자 관리 10. 공지사항 등록 11. 여성전용공간 관리 : ");
			select=sc.nextInt();
			
		switch(select) {
		case 1:
			System.out.print("아이디 : "); id=sc.next();
			System.out.print("비밀번호 : "); passwords=sc.next();
			System.out.print("이름 : "); name=sc.next();
			System.out.print("닉네임 : "); nickname=sc.next();
			System.out.print("주민번호 앞자리 7글자 : "); code=sc.nextInt();
			
			break;
		case 2:
			System.out.print("아이디 : "); id=sc.next();
			System.out.print("비밀번호 : "); passwords=sc.next();
			System.out.println(id+"님의 로그인이 성공적으로 완료되었습니다!");
			break;
		case 3:
			System.out.print("불법촬영구역 위치 : "); camlocation=sc.next();
			System.out.print("상세 위치 : "); details=sc.next();
			System.out.println("불법촬영구역이 등록되었습니다.");
			break;
		case 5:
			for(WomanOnlys w)
			    System.out.print("- ("+w.location+")");
			break;
		case 7:
			System.out.println("1. Q: "); ask=sc.next();
			System.out.println("응답할 질의 : "); num=sc.nextInt();
			System.out.println("응답 : "); answer=sc.next();
			break;	
		case 8:
			System.out.println("공지사항 내용: "); notice.next();
			break;			
		case 9:
			System.out.println("아이디 : "+prod+"비밀번호 : "+cnt+"이름 : "+name+"닉네임 : "+nickname+"주민번호 앞자리 7글자 :"+code);
			break;
		default : System.out.println("잘못된 입력입니다.");
		}
		
		
		}

	}
}
