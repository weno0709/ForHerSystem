package javaproject;
import java.util.HashMap;
import java.util.Scanner;
import java.util.StringTokenizer;

public void register() {
			System.out.println(" \n\n
____                    __ \r\n"+
"/\  _`\                 /\ \/\ \      \r\n"+             
"\ \ \L\_\  ___    _ __  \ \ \_\ \      __    _ __  \r\n"+
" \ \  _\/ / __`\ /\`'__\ \ \  _  \   /'__`\ /\`'__\ \r\n"+
"  \ \ \/ /\ \L\ \\ \ \/   \ \ \ \ \ /\  __/ \ \ \/ \r\n"+
"   \ \_\ \ \____/ \ \_\    \ \_\ \_\\ \____\ \ \_\ \r\n"+
"    \/_/  \/___/   \/_/     \/_/\/_/ \/____/  \/_/ \r\n");
			 System.out.print("이메일 : "); eMail=sc.next();
			System.out.print("비밀번호 : "); pw=sc.next();
			System.out.print("이름 : "); name=sc.next();
			System.out.print("닉네임 : "); nickname=sc.next();
			System.out.print("주민번호 앞자리 7글자 : "); code=sc.nextInt();
		}

public static boolean femaleMemeberCheck(code){
			char femaleNum=code.charAt(6);
			if(femaleNum=='0'||femaleNum=='2'||femaleNum=='4'||femaleNum=='6'||femaleNum=='8'){
				System.out.println("감사합니다. 여성인증과 함께 회원가입이 성공적으로 완료되었습니다.\n For Her에 오신 것을 환영합니다!"+name+"님");
			else {
				System.out.println("죄송합니다. 여성인증에 실패하였습니다. 본 시스템은 여성 회원님에 한해 운영 중입니다...");
				return false;
			}
public vodi login{
	System.out.print("이메일 : "); eMail=sc.next();
	System.out.print("비밀번호 : "); pw=sc.next();
	System.out.println(id+"님의 로그인이 성공적으로 완료되었습니다! ");

}


public class ForHerMain {

	public static void main(String[] args) {
		String id=null;
		String pw = null;
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
			
                                                   

			System.out.println("For Her에 오신 것을 환영합니다!\n"+"현재 시스템을 이용하기 위해 회원가입이 필요합니다.\n"+"회원가입을 진행하시겠습니까?\n"+"(예) Y / (아니오) N  입력해주세요.\n");
			System.out.println("1. 불법촬영구역 등록 2. 불법촬영구역 조회 3. 여성전용공간 검색 4. 여성전용공간 리뷰 5. 질의응답 \n 6. 공지사항 등록 7. 사용자 관리 8. 공지사항 등록 9. 여성전용공간 관리 : ");
			select=sc.nextInt();


                                                   
				
		switch(select) {
		case 1:
			
			
			break;
		case 2:

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
