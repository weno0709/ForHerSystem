import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

class User {
    private String name;
    private String nickname;
    private String id; 
    private String password;
    private int rrn;
    private int userAccess; 
    
    public User(String name, String nickname, String id, String password, int rrn) {
        this.name = name;
        this.nickname = nickname;
        this.id = id;
        this.password = password;
        this.rrn = rrn;
        this.userAccess = 0; 
    }
    
    public String getName() { return name; }
    public String getNickname() { return nickname; }
    public String getId() { return id; }
    public String getPassword() { return password; }
    public int getRrn() { return rrn; }
    public int getUserAccess() { return userAccess; }
    public void setNickname(String nickname) { this.nickname = nickname; }
    public void setUserAccess(int access) { this.userAccess = access; }
}


class WomanOnly {
    private String womanOnlyName;
    private String womanOnlyLocation;
    private String womanOnlyCategory;
    
    public WomanOnly(String name, String location, String category) {
        this.womanOnlyName = name;
        this.womanOnlyLocation = location;
        this.womanOnlyCategory = category;
    }
    
    public String getName() { return womanOnlyName; }
    public String getLocation() { return womanOnlyLocation; }
    public String getCategory() { return womanOnlyCategory; }
}


class Cam {
    private String camLocation;
    private String camLocationDetail;
    
    public Cam(String location, String details) {
        this.camLocation = location;
        this.camLocationDetail = details;
    }
    
    public String getLocation() { return camLocation; }
    public String getDetails() { return camLocationDetail; }
}


class QandA {
    private static int questionCounter = 1;
    private int questionNo;
    private String questionContents;
    private String questionNickname;
    private String answer;
    private boolean answerState;
    
    public QandA(String contents, String nickname) {
        this.questionNo = questionCounter++;
        this.questionContents = contents;
        this.questionNickname = nickname;
        this.answer = "";
        this.answerState = false;
    }
    
    public int getQuestionNo() { return questionNo; }
    public String getContents() { return questionContents; }
    public String getNickname() { return questionNickname; }
    public String getAnswer() { return answer; }
    public boolean isAnswered() { return answerState; }
    
    public void setAnswer(String answer) {
        this.answer = answer;
        this.answerState = true;
    }
}


class Notice {
    private static int noticeCounter = 1;
    private int noticeNo;
    private String noticeContents;
    
    public Notice(String contents) {
        this.noticeNo = noticeCounter++;
        this.noticeContents = contents;
    }
    
    public int getNoticeNo() { return noticeNo; }
    public String getContents() { return noticeContents; }
}

public class ForHer {

    static ArrayList<User> users = new ArrayList<>();
    static User currentUser = null;
    static Scanner sc = new Scanner(System.in);

    static ArrayList<WomanOnly> womanOnlySpaces = new ArrayList<>();
    static ArrayList<Cam> camLocations = new ArrayList<>();
    static ArrayList<QandA> qnaList = new ArrayList<>();
    static ArrayList<Notice> notices = new ArrayList<>();

 
    public static void registration() {
        System.out.println("ForHer₊_______________________________\n"
        		+ "                  ⿴    회원가입 。\n");

        
        System.out.print("아이디: ");
        String id = sc.next();
        

        if (alreadyId(id)) {
            System.out.println("이미 등록되어 있는 아이디입니다. 다른 아이디를 사용해주세요.");
            return;
        }
        
        System.out.print("비밀번호: ");
        String password = sc.next();
        System.out.print("이름: ");
        String name = sc.next();
        System.out.print("닉네임: ");
        String nickname = sc.next();
        System.out.print("주민번호 앞자리 7 자리: ");
        int rrn = sc.nextInt();
        System.out.println("(단순히 여성 인증을 위해 주민번호를 사용하는 것일뿐 이외의 용도로 사용하지 않을 것을 약속드립니다.)");
        

        if (alreadyRegistration(name, rrn)) {
            System.out.println("현재 등록된 회원입니다.");
            return;
        }
        
        if (femaleMemberCheck(rrn)) {
            User newUser = new User(name, nickname, id, password, rrn);
            users.add(newUser);
            System.out.println("회원가입이 성공적으로 완료되었습니다!");
            System.out.println("For Her에 오신 것을 환영합니다, " + name + "님!");
        } else {
            System.out.println("죄송합니다. 여성인증에 실패하였습니다. 본 시스템은 여성 회원만 이용 가능합니다.");
        }
    }
    
    public static boolean alreadyId(String id) {
        for (User user : users) {
            if (user.getId().equals(id)) {
                return true;
            }
        }
        return false;
    }
    
    public static boolean alreadyRegistration(String name, int rrn) {
        for (User user : users) {
            if (user.getName().equals(name) && user.getRrn()==rrn) {
                return true;
            }
        }
        return false;
    }


    public static boolean femaleMemberCheck(int rrn) {
    	String rrnStringVersion=String.valueOf(rrn);
        if (rrnStringVersion.length() >= 7) {
            char genderDigit = rrnStringVersion.charAt(6);
            return (genderDigit == '0' || genderDigit == '2' || genderDigit == '4' || genderDigit == '6' || genderDigit == '8');
        }
        return true; 
    }

    public static void login() {
        if (users.isEmpty()) {
            System.out.println("시스템을 이용을 위해 우선 회원가입을 진행해주세요.");
            return;
        }
        
        System.out.print("아이디: ");
        String inputId = sc.next();
        System.out.print("비밀번호: ");
        String inputPassword = sc.next();
        
        if (loginCheck(inputId, inputPassword)) {
            for (User user : users) {
                if (user.getId().equals(inputId) && user.getPassword().equals(inputPassword)) {
                    currentUser = user;
                    System.out.println(user.getName() + "님의 로그인이 성공적으로 완료되었습니다! 환영합니다!");
                    break;
                }
            }
        } else {
            System.out.println("로그인 정보가 일치하지 않습니다...");
        }
    }
    public static boolean loginCheck(String id, String password) {
        for (User user : users) {
            if (user.getId().equals(id) && user.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }

    public static void registerCam() {
        if (currentUser == null) {
            System.out.println("로그인이 필요합니다.");
            return;
        }
        
        System.out.print("불법촬영구역 위치: ");
        String location = sc.next();
        System.out.print("상세 위치(다른 사용자들을 위해 정확한 위치를 공유해주세요!): ");
        String details = sc.next();
        
        Cam newCam = new Cam(location, details);
        camLocations.add(newCam);
        System.out.println("감사합니다. 불법촬영구역이 성공적으로 등록되었습니다.");
    }

    public static void showCamLocations() {
        if (camLocations.isEmpty()) {
            System.out.println("등록된 불법촬영구역이 없습니다...");
        } else {
            System.out.println("ForHer₊_______________________________\n"
            		+ "                  ⿴    불법촬영구역 현황 。\n");

            for (int i = 0; i < camLocations.size(); i++) {
                Cam cam = camLocations.get(i);
                System.out.println((i+1) + ". " + cam.getLocation() + " (" + cam.getDetails() + ")");
            }
        }
    }


    public static void searchWomanOnlySpaces() {
        System.out.println("ForHer₊________________________________\n"
        		+ "                  ⿴   여성전용공간 검색  。\n");

        System.out.println("1. 모두 조회");
        System.out.println("2. 카테고리별 검색");
        System.out.print("항목 번호 선택: ");
        
        int choice = sc.nextInt();
        
        if (choice == 1) {
            showWomanOnlyList();
        } else if (choice == 2) {
            System.out.print("카테고리 입력 (헬스장/휴게실/기타): ");
            String category = sc.next();
            browseCategories(category);
        }
    }
    
    public static void showWomanOnlyList() {
        if (womanOnlySpaces.isEmpty()) {
            System.out.println("등록된 여성전용공간이 없습니다...");
        } else {
            System.out.println("ForHer₊_______________________________\n"
            		+ "                  ⿴   여성전용공간 목록  。\n");

            for (int i = 0; i < womanOnlySpaces.size(); i++) {
                WomanOnly space = womanOnlySpaces.get(i);
                System.out.println((i+1) + ". " + space.getName() + " - " + space.getLocation() + " [" + space.getCategory() + "]");
            }
        }
    }
    

    public static void browseCategories(String category) {
        System.out.println("ForHer₊_______________________________\n"
        		+ "                  ⿴  "+category+" 검색 결과  。\n");

        boolean found = false;
        for (WomanOnly space : womanOnlySpaces) {
            if (space.getCategory().contains(category)) {
                System.out.println("- " + space.getName() + " (" + space.getLocation() + ")");
                found = true;
            }
        }
        if (!found) {
            System.out.println("해당 카테고리의 여성전용공간이 없습니다...");
        }
    }

    public static void registerQnA() {
        if (currentUser == null) {
            System.out.println("로그인이 필요합니다...");
            return;
        }
        
        System.out.print("Q: ");
        sc.nextLine(); 
        String question = sc.nextLine();
        
        QandA newQnA = new QandA(question, currentUser.getNickname());
        qnaList.add(newQnA);
        System.out.println("질의 등록이 완료되었습니다 (질문번호: " + newQnA.getQuestionNo() + ")");
    }
    public static void showQnAList() {
        if (qnaList.isEmpty()) {
            System.out.println("등록된 질의가 없습니다...");
        } else {
            System.out.println("ForHer₊_______________________________\n"
            		+ "                  ⿴   질의응답 목록   。\n");

            for (QandA qna : qnaList) {
                System.out.println("[Q" + qna.getQuestionNo() + "] " + qna.getNickname() + ": " + qna.getContents());
                if (qna.isAnswered()) {
                    System.out.println("[A] " + qna.getAnswer());
                } else {
                    System.out.println("[A] 답변 대기중... ");
                }
                System.out.println("_____");
            }
        }
    }
    public static void registerNotice() {
        if (currentUser == null) {
            System.out.println("로그인이 필요합니다...");
            return;
        }
        System.out.println("ForHer₊_______________________________\n"
        		+ "                  ⿴   공지사항   。\n");

        sc.nextLine(); 
        String content = sc.nextLine();
        
        Notice newNotice = new Notice(content);
        notices.add(newNotice);
        System.out.println("공지사항이 성공적으로 등록되었습니다. (공지번호: " + newNotice.getNoticeNo() + ")");
    }

    public static void showNoticeList() {
        if (notices.isEmpty()) {
            System.out.println("등록된 공지사항이 없습니다...");
        } else {
            System.out.println("ForHer₊__________________\n"
            		+ "                  ⿴ 공지 목록 。\n");

            for (Notice notice : notices) {
                System.out.println("[공지" + notice.getNoticeNo() + "] " + notice.getContents());
            }
        }
    }
    public static void showUserInfo() {
        if (currentUser == null) {
            System.out.println("로그인이 필요합니다...");
            return;
        }
        System.out.println("ForHer₊_______________________________\n"
        		+ "                  ⿴ 사용자 정보 。\n");

        System.out.println("아이디: " + currentUser.getId());
        System.out.println("이름: " + currentUser.getName());
        System.out.println("닉네임: " + currentUser.getNickname());
        System.out.println("주민번호 앞자리: " + currentUser.getRrn());
        System.out.println("권한: " + (currentUser.getUserAccess() == 0 ? "일반사용자" : "관리자"));
    }
    
    public static void logout() {
        if (currentUser != null) {
            System.out.println(currentUser.getName() + "님이 로그아웃되었습니다.");
            currentUser = null;
        } else {
            System.out.println("현재 로그인 상태가 아닙니다...");
        }
    }

    public static void main(String[] args) {

        initializeData();
        
        System.out.println("For Her에 오신 것을 환영합니다!");
        
        int select = -1;
        while (select != 0) {
            
            System.out.println("\n\n"+
            		"*★ Welcome to ★* 。 • ˚ ˚ ˛ ˚ ˛ •* \n"+
                    " ˛ ˚ * •  ˚•。★ For Her ★ 。* 。\n"+
                    "° 。 ° ˚* _Π_____*。*˚* \n"+
                    "˚ ˛ •˛•*/______/~＼。˚ ˚ ˛* \n"+
                    "˚ ˛ •˛• ｜ 田田｜門｜ ˚ We support women's everyday lives!\n"
            		);
            System.out.println("\n╭──────────.★..─╮");
            System.out.println("\n For Her  ");
            System.out.println("\n╰─..★.──────────╯");
            System.out.println("\n 이용을 원하시는 항목의 번호를 입력해주세요!");
            System.out.println("1. 회원가입");
            System.out.println("2. 로그인");
            System.out.println("3. 불법촬영구역 등록");
            System.out.println("4. 불법촬영구역 조회");
            System.out.println("5. 여성전용공간 검색");
            System.out.println("6. 질의응답 등록");
            System.out.println("7. 질의응답 조회");
            System.out.println("8. 공지사항 등록");
            System.out.println("9. 공지사항 조회");
            System.out.println("10. 사용자 정보 조회");
            System.out.println("11. 로그아웃");
            System.out.println("0. 종료");
            System.out.print("선택: ");
            
            select = sc.nextInt();

            switch(select) {
                case 1: registration(); break;
                case 2: login(); break;
                case 3: registerCam(); break;
                case 4: showCamLocations(); break;
                case 5: searchWomanOnlySpaces(); break;
                case 6: registerQnA(); break;
                case 7: showQnAList(); break;
                case 8: registerNotice(); break;
                case 9: showNoticeList(); break;
                case 10: showUserInfo(); break;
                case 11: logout(); break;
                case 0: System.out.println("For Her를 이용해주셔서 감사합니다! 오늘도 좋은 하루 보내세요."); break;
                default: System.out.println("잘못된 입력입니다... 다시 입력해주세요.");
            }
        }
        
        sc.close();
    }
    
    private static void initializeData() {

        womanOnlySpaces.add(new WomanOnly("여성전용헬스장", "대구 동구 동부로 777", "헬스장"));
        womanOnlySpaces.add(new WomanOnly("여성휴게실", "경북 경산시 대학로 100", "휴게실"));
        womanOnlySpaces.add(new WomanOnly("여성전용주차장", "대구 남구 이천로 1길 11", "주차장"));
    }
}
