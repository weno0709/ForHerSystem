package javaproject;

import java.util.*;

class User {
    private String name;
    private String nickname;
    private String id;
    private String password;
    private String code;
    private int userAccess;

    public User(String name, String nickname, String id, String password, String code, int userAccess) {
        this.name = name;
        this.nickname = nickname;
        this.id = id;
        this.password = password;
        this.code = code;
        this.userAccess = userAccess;
    }

    public String getName() { return name; }
    public String getNickname() { return nickname; }
    public String getId() { return id; }
    public String getPassword() { return password; }
    public String getCode() { return code; }
    public int getUserAccess() { return userAccess; }
    public void setName(String name) { this.name = name; }
    public void setNickname(String nickname) { this.nickname = nickname; }
    public void setPassword(String password) { this.password = password; }
}

class CamLocation {
    private String location;
    private String details;
    
    public CamLocation(String location, String details) {
        this.location = location;
        this.details = details;
    }
    
    public String getLocation() { return location; }
    public String getDetails() { return details; }
    
    @Override
    public String toString() {
        return "불법촬영구역 위치: " + location + " | 상세위치: " + details;
    }
}

class WomanOnlys {
    private String location;
    private String category;
    private List<String> reviews;
    
    public WomanOnlys(String location, String category) {
        this.location = location;
        this.category = category;
        this.reviews = new ArrayList<>();
    }
    
    public String getLocation() { return location; }
    public String getCategory() { return category; }
    public List<String> getReviews() { return reviews; }
    
    public void addReview(String review) {
        reviews.add(review);
    }

    public String toString() {
        return "[" + category + "] " + location + " (리뷰 " + reviews.size() + "개)";
    }
}

class QandA {
    private int questionNo;
    private String question;
    private String questionNickname;
    private String answer;
    private boolean isAnswered;
    
    public QandA(int questionNo, String question, String questionNickname) {
        this.questionNo = questionNo;
        this.question = question;
        this.questionNickname = questionNickname;
        this.answer = "";
        this.isAnswered = false;
    }
    
    public void setAnswer(String answer) {
        this.answer = answer;
        this.isAnswered = true;
    }
    
    // Getters
    public int getQuestionNo() { return questionNo; }
    public String getQuestion() { return question; }
    public String getQuestionNickname() { return questionNickname; }
    public String getAnswer() { return answer; }
    public boolean isAnswered() { return isAnswered; }
    
    @Override
    public String toString() {
        String status = isAnswered ? "[완료된 답변]" : "[대기 중 답변]";
        String result = status + " Q" + questionNo + ". " + question + " (작성자 닉네임: " + questionNickname + ")";
        if (isAnswered) {
            result += "\n    A: " + answer;
        }
        return result;
    }
}

class Notice {
    private int noticeNo;
    private String content;
    private String date;
    
    public Notice(int noticeNo, String content) {
        this.noticeNo = noticeNo;
        this.content = content;
        this.date = new Date().toString();
    }

    public String toString() {
        return "[***공지*** " + noticeNo + "] " + content + " (" + date + ")";
    }
}

public class ForHerMain {
    private static Scanner sc = new Scanner(System.in);
    private static List<User> users = new ArrayList<>();
    private static List<CamLocation> camLocations = new ArrayList<>();
    private static List<WomanOnlys> womanOnlySpaces = new ArrayList<>();
    private static List<QandA> questions = new ArrayList<>();
    private static List<Notice> notices = new ArrayList<>();
    private static User currentUser = null;
    private static int questionCounter = 1;
    private static int noticeCounter = 1;

    public static void main(String[] args) {
        initializeData();
        
        System.out.println("=".repeat(60));
        System.out.println("                For Her에 오신 것을 환영합니다!");
        System.out.println("              여성을 위한 안전한 공간 정보 시스템");
        System.out.println("=".repeat(60));
        
        // 메인 루프
        while (true) {
            if (currentUser == null) {
                showLoginMenu();
            } else {
                showMainMenu();
            }
        }
    }
    
    private static void initializeData() {
        users.add(new User("관리자", "admin", "admin@forher.com", "admin123", "9001011", 2));

        womanOnlySpaces.add(new WomanOnlys("대구 동구 동부로 777", "헬스장"));
        womanOnlySpaces.add(new WomanOnlys("경북 경산시 대학로 100", "카페"));
        womanOnlySpaces.add(new WomanOnlys("대구 남구 이천로 1길 11", "스터디룸"));
        
        // 기본 불법촬영구역 데이터
        camLocations.add(new CamLocation("대구역 지하도", "3번 출구 근처 화장실"));
        camLocations.add(new CamLocation("동성로", "CGV 근처 공용화장실"));
    }
    
    private static void showLoginMenu() {
        System.out.println("\n" + "=".repeat(40));
        System.out.println("           로그인 / 회원가입");
        System.out.println("=".repeat(40));
        System.out.println("1. 로그인");
        System.out.println("2. 회원가입");
        System.out.println("3. 프로그램 종료");
        System.out.print("선택: ");
        
        int choice = getIntInput();
        
        switch (choice) {
            case 1:
                login();
                break;
            case 2:
                register();
                break;
            case 3:
                System.out.println("For Her를 이용해주셔서 감사합니다!");
                System.exit(0);
                break;
            default:
                System.out.println("잘못된 입력입니다...");
        }
    }
    
    public static void register() {
        System.out.println("\n" + "=".repeat(50));
        System.out.println("                   회원가입");
        System.out.println("=".repeat(50));
        
        System.out.print("이메일: ");
        String email = sc.nextLine();
        
        if (isEmailExists(email)) {
            System.out.println("이미 존재하는 이메일입니다!");
            return;
        }
        
        System.out.print("비밀번호: ");
        String pw = sc.nextLine();
        System.out.print("이름: ");
        String name = sc.nextLine();
        System.out.print("닉네임: ");
        String nickname = sc.nextLine();
        System.out.print("주민번호 앞자리 7글자: ");
        String code = sc.nextLine();
        
        if (code.length() != 7) {
            System.out.println("주민번호 앞자리 7글자를 올바르게 입력하셔야 합니다!");
            return;
        }
        
        if (femaleMemberCheck(code)) {
            users.add(new User(name, nickname, email, pw, code, 1));
            System.out.println("\n 감사합니다! 여성인증과 함께 회원가입이 성공적으로 완료되었습니다.");
            System.out.println("  For Her에 오신 것을 환영합니다, " + name + "님!");
        }
    }
    
    public static boolean femaleMemberCheck(String code) {
        char genderDigit = code.charAt(6);
        if (genderDigit == '0' || genderDigit == '2' || genderDigit == '4' || genderDigit == '6' || genderDigit == '8') {
            return true;
        } else {
            System.out.println("죄송합니다... 여성인증에 실패하였습니다. For Her 시스템은 여성 회원님에 한해 운영 중입니다. 이용에 불편을 끼쳐 드려 죄송합니다.");
            return false;
        }
    }
    
    public static void login() {
        System.out.println("\n" + "=".repeat(40));
        System.out.println("                 로그인");
        System.out.println("=".repeat(40));
        
        System.out.print("이메일: ");
        String email = sc.nextLine();
        System.out.print("비밀번호: ");
        String pw = sc.nextLine();
        
        User user = authenticateUser(email, pw);
        if (user != null) {
            currentUser = user;
            System.out.println("\n✓ " + user.getName() + "님이 로그인에 성공했습니다!");
            if (user.getUserAccess() == 2) {
                System.out.println("  관리자 권한으로 접속하였습니다.");
            }
        } else {
            System.out.println("이메일 또는 비밀번호가 올바르지 않습니다!");
        }
    }
    
    private static void showMainMenu() {
        System.out.println("\n" + "=".repeat(60));
        System.out.println("                    For Her 메인 메뉴");
        System.out.println("                   현재 사용자: " + currentUser.getName() + "님");
        if (currentUser.getUserAccess() == 2) {
            System.out.println("                     [관리자 모드]");
        }
        System.out.println("=".repeat(60));
        
        System.out.println("*** 불법촬영구역 ***");
        System.out.println("  1. 불법촬영구역 등록");
        System.out.println("  2. 불법촬영구역 조회");
        
        System.out.println("\n*** 여성전용공간 ***");
        System.out.println("  3. 여성전용공간 검색");
        System.out.println("  4. 여성전용공간 리뷰 작성");
        
        System.out.println("\n*** 커뮤니티 ***");
        System.out.println("  5. 질의응답");
        System.out.println("  6. 공지사항 등록");
        System.out.println("  7. 공지사항 조회");
        
        if (currentUser.getUserAccess() == 2) {
            System.out.println("\n*** 관리자 전용 ***");
            System.out.println("  8. 사용자 관리");
            System.out.println("  9. 여성전용공간 관리");
            System.out.println("  10. 질의응답 관리");
        }
        
        System.out.println("\n  0. 로그아웃");
        System.out.print("\n선택: ");
        
        int select = getIntInput();
        handleMenuSelection(select);
    }
    
    private static void handleMenuSelection(int select) {
        switch (select) {
            case 1:
                registerCamLocation();
                break;
            case 2:
                viewCamLocations();
                break;
            case 3:
                searchWomanOnlySpaces();
                break;
            case 4:
                writeReview();
                break;
            case 5:
                handleQandA();
                break;
            case 6:
                registerNotice();
                break;
            case 7:
                viewNotices();
                break;
            case 8:
                if (currentUser.getUserAccess() == 2) {
                    manageUsers();
                } else {
                    System.out.println("관리자 권한이 필요합니다.");
                }
                break;
            case 9:
                if (currentUser.getUserAccess() == 2) {
                    manageWomanOnlySpaces();
                } else {
                    System.out.println("관리자 권한이 필요합니다.");
                }
                break;
            case 10:
                if (currentUser.getUserAccess() == 2) {
                    manageQandA();
                } else {
                    System.out.println("관리자 권한이 필요합니다.");
                }
                break;
            case 0:
                currentUser = null;
                System.out.println("로그아웃되었습니다.");
                break;
            default:
                System.out.println("잘못된 입력입니다.");
        }
    }
    
    private static void registerCamLocation() {
        System.out.println("\n" + "=".repeat(50));
        System.out.println("              불법촬영구역 등록");
        System.out.println("=".repeat(50));
        
        System.out.print("불법촬영구역 위치: ");
        String location = sc.nextLine();
        System.out.print("상세 위치: ");
        String details = sc.nextLine();
        
        camLocations.add(new CamLocation(location, details));
        System.out.println("\n 불법촬영구역이 등록되었습니다.");
        System.out.println("  오늘도 여성들의 안전을 위해 힘써주셔서 감사합니다.");
    }
    
    private static void viewCamLocations() {
        System.out.println("\n" + "=".repeat(50));
        System.out.println("              불법촬영구역 조회");
        System.out.println("=".repeat(50));
        
        if (camLocations.isEmpty()) {
            System.out.println("등록된 불법촬영구역 정보가 없습니다.");
        } else {
            System.out.println("⚠️  현재 등록된 불법촬영 의심구역:");
            for (int i = 0; i < camLocations.size(); i++) {
                System.out.println("  " + (i + 1) + ". " + camLocations.get(i));
            }
        }
    }
    
    private static void searchWomanOnlySpaces() {
        System.out.println("\n" + "=".repeat(50));
        System.out.println("              여성전용공간 검색");
        System.out.println("=".repeat(50));
        
        if (womanOnlySpaces.isEmpty()) {
            System.out.println("등록된 여성전용공간이 없습니다.");
            return;
        }
        
        System.out.println(" 현재 등록된 여성전용공간:");
        for (int i = 0; i < womanOnlySpaces.size(); i++) {
            WomanOnlys space = womanOnlySpaces.get(i);
            System.out.println("  " + (i + 1) + ". " + space);
            
            if (!space.getReviews().isEmpty()) {
                System.out.println("     최근 리뷰: " + space.getReviews().get(space.getReviews().size() - 1));
            }
        }
    }
    
    private static void writeReview() {
        System.out.println("\n" + "=".repeat(50));
        System.out.println("           여성전용공간 리뷰 작성");
        System.out.println("=".repeat(50));
        
        if (womanOnlySpaces.isEmpty()) {
            System.out.println("리뷰를 작성할 여성전용공간이 없습니다.");
            return;
        }
        

        System.out.println("리뷰를 작성할 공간을 선택하세요:");
        for (int i = 0; i < womanOnlySpaces.size(); i++) {
            System.out.println("  " + (i + 1) + ". " + womanOnlySpaces.get(i).getLocation());
        }
        
        System.out.print("선택: ");
        int choice = getIntInput() - 1;
        
        if (choice >= 0 && choice < womanOnlySpaces.size()) {
            System.out.print("리뷰 내용: ");
            String review = sc.nextLine();
            
            womanOnlySpaces.get(choice).addReview("[" + currentUser.getNickname() + "] " + review);
            System.out.println("\n 리뷰가 등록되었습니다!");
        } else {
            System.out.println("잘못된 선택입니다...");
        }
    }
    
    private static void handleQandA() {
        System.out.println("\n" + "=".repeat(50));
        System.out.println("                  질의응답");
        System.out.println("=".repeat(50));
        
        System.out.println("1. 질문 등록");
        System.out.println("2. 질의응답 목록 보기");
        System.out.print("선택: ");
        
        int choice = getIntInput();
        
        switch (choice) {
            case 1:
                System.out.print("질문 내용: ");
                String question = sc.nextLine();
                questions.add(new QandA(questionCounter++, question, currentUser.getNickname()));
                System.out.println("\n 감사합니다. 질문이 성공적으로 등록되었습니다. 관리자의 답변을 기다려주세요...");
                break;
            case 2:
                viewQandA();
                break;
            default:
                System.out.println("잘못된 입력입니다.");
        }
    }
    
    private static void viewQandA() {
        if (questions.isEmpty()) {
            System.out.println("등록된 질문이 없습니다.");
        } else {
            System.out.println("\n 질의응답 목록:");
            for (QandA q : questions) {
                System.out.println("  " + q);
                System.out.println();
            }
        }
    }
    
    private static void registerNotice() {
        System.out.println("\n" + "=".repeat(50));
        System.out.println("               공지사항 등록");
        System.out.println("=".repeat(50));
        
        System.out.print("공지사항 내용: ");
        String content = sc.nextLine();
        
        notices.add(new Notice(noticeCounter++, content));
        System.out.println("\n 공지사항이 등록되었습니다.");
    }
    
    private static void viewNotices() {
        System.out.println("\n" + "=".repeat(50));
        System.out.println("               공지사항 조회");
        System.out.println("=".repeat(50));
        
        if (notices.isEmpty()) {
            System.out.println("등록된 공지사항이 없습니다.");
        } else {
            System.out.println("📢 공지사항:");
            for (Notice notice : notices) {
                System.out.println("  " + notice);
                System.out.println();
            }
        }
    }
    
    private static void manageUsers() {
        System.out.println("\n" + "=".repeat(50));
        System.out.println("               사용자 관리");
        System.out.println("=".repeat(50));
        
        System.out.println("등록된 사용자 목록:");
        for (int i = 0; i < users.size(); i++) {
            User user = users.get(i);
            String role = user.getUserAccess() == 2 ? "[관리자]" : "[일반사용자]";
            System.out.println("  " + (i + 1) + ". " + role + " " + user.getName() + 
                             " (" + user.getNickname() + ") - " + user.getId());
        }
    }
    
    private static void manageWomanOnlySpaces() {
        System.out.println("\n" + "=".repeat(50));
        System.out.println("            여성전용공간 관리");
        System.out.println("=".repeat(50));
        
        System.out.println("1. 여성전용공간 추가");
        System.out.println("2. 여성전용공간 목록 보기");
        System.out.print("선택: ");
        
        int choice = getIntInput();
        
        switch (choice) {
            case 1:
                System.out.print("공간 위치: ");
                String location = sc.nextLine();
                System.out.print("카테고리: ");
                String category = sc.nextLine();
                
                womanOnlySpaces.add(new WomanOnlys(location, category));
                System.out.println("\n✓ 여성전용공간이 추가되었습니다.");
                break;
            case 2:
                searchWomanOnlySpaces();
                break;
            default:
                System.out.println("잘못된 입력입니다.");
        }
    }
    
    private static void manageQandA() {
        System.out.println("\n" + "=".repeat(50));
        System.out.println("             질의응답 관리");
        System.out.println("=".repeat(50));
        
        // 미답변 질문만 표시
        List<QandA> unansweredQuestions = new ArrayList<>();
        for (QandA q : questions) {
            if (!q.isAnswered()) {
                unansweredQuestions.add(q);
            }
        }
        
        if (unansweredQuestions.isEmpty()) {
            System.out.println("답변할 질문이 없습니다.");
            return;
        }
        
        System.out.println(" 미답변 질문 목록:");
        for (int i = 0; i < unansweredQuestions.size(); i++) {
            System.out.println("  " + (i + 1) + ". " + unansweredQuestions.get(i).getQuestion() + 
                             " (작성자: " + unansweredQuestions.get(i).getQuestionNickname() + ")");
        }
        
        System.out.print("답변할 질문 번호: ");
        int choice = getIntInput() - 1;
        
        if (choice >= 0 && choice < unansweredQuestions.size()) {
            System.out.print("답변 내용: ");
            String answer = sc.nextLine();
            
            unansweredQuestions.get(choice).setAnswer(answer);
            System.out.println("\n 답변이 등록되었습니다.");
        } else {
            System.out.println("잘못된 선택입니다.");
        }
    }
    

    private static boolean isEmailExists(String email) {
        return users.stream().anyMatch(user -> user.getId().equals(email));
    }
    
    private static User authenticateUser(String email, String password) {
        return users.stream()
                .filter(user -> user.getId().equals(email) && user.getPassword().equals(password))
                .findFirst()
                .orElse(null);
    }
    
    private static int getIntInput() {
        try {
            int result = sc.nextInt();
            sc.nextLine(); 
            return result;
        } catch (Exception e) {
            sc.nextLine();
            return -1;
        }
    }
}
