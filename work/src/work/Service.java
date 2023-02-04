package work;

import java.util.ArrayList;


public class Service extends Util {

	DAO 데이터베이스;
	ArrayList<String[]> 데이터임시저장소;
	public Service() {
		데이터베이스 = new DAO();
		데이터임시저장소 = new ArrayList<String[]>();
	}
	
	public void 가입(Member 멤버) {
		데이터임시저장소 = 멤버.getMemberDto();
		while(true) {
			String[] 데이터 = new String[4];
			System.out.print("아이디를 입력해주세요 : ");
			데이터[0] = Integer.toString(현재사용자수(멤버.getMemberDto()));
			데이터[1] = 문자열입력();
			if(중복검사(데이터[1], 데이터임시저장소)) {
				continue;
			}
			System.out.print("비밀번호를 입력해주세요 : ");
			데이터[2] = 문자열입력();
			데이터[3] = "0";
			데이터임시저장소.add(현재사용자수(데이터임시저장소), 데이터);
			데이터베이스.가입(멤버, 데이터임시저장소);
			break;
		}
	}

	public void 로그인(Member 멤버) {
		데이터임시저장소 = 멤버.getMemberDto();
		boolean flag = true;
		while(flag) {
			System.out.print("아이디를 입력해주세요 : ");
			String ID = 문자열입력();
			System.out.print("비밀번호를 입력해주세요 : ");
			String PW = 문자열입력();
			for(String[] data : 데이터임시저장소) {
				if(data[1].equals(ID)) {
					if(data[2].equals(PW)) {
						세션생성(data[0]);
						flag = false;
						break;
					} else {
						System.out.println("비밀번호가 다릅니다.");
					}
				} else {
					System.out.println("아이디가 다릅니다.");
				}
			}
		}
	}

	public void 입금(Member 멤버) {
		데이터임시저장소 = 멤버.getMemberDto();
		String[] 사용자정보 = 데이터임시저장소.get(세션번호확인());
		int 잔액 = Integer.parseInt(사용자정보[3]);
		System.out.println("현재 잔액 : " + 잔액);
		while(true) {	
			System.out.print("입금할 금액 : ");
			int 입금금액 = 숫자입력();
			if(빈값확인(입금금액)) {
				System.out.println("잘못된 금액입니다.");
				continue;
			}
			사용자정보[3] = Integer.toString(잔액 + 입금금액);
			데이터임시저장소.set(세션번호확인(), 사용자정보);
			데이터베이스.입금(데이터임시저장소, 멤버, 세션번호확인());
			break;
		}
	}

	public void 이체(Member 멤버) {
		데이터임시저장소 = 멤버.getMemberDto();
		String[] 입금자정보 = 데이터임시저장소.get(세션번호확인());
		int 입금자잔액 = Integer.parseInt(입금자정보[3]);
		int 예금자번호;
		if(빈값확인(입금자잔액)) {
			System.out.println("이체 가능한 최소 금액이 없습니다.");
			return;
		}
		System.out.println("현재 잔액 : " + 입금자잔액);
		while(true) {
			System.out.print("이체할 상대 회원번호 : ");
			예금자번호 = 숫자입력();
			if(예금자번호 > 현재사용자수(데이터임시저장소) || 예금자번호 < 0 || 예금자번호 == 세션번호확인()) {
				System.out.println("잘못된 회원번호입니다.");
				continue;
			}
			break;
		}
		String[] 예금자정보 = 데이터임시저장소.get(예금자번호);
		int 예금자잔액 = Integer.parseInt(예금자정보[3]);
		while(true) {
			System.out.print("이체할 금액 : ");
			int 이체금액 = 숫자입력();
			if(빈값확인(이체금액)) {
				System.out.println("금액을 입력해주세요.");
				continue;
			}
			입금자정보[3] = Integer.toString(입금자잔액 - 이체금액);
			예금자정보[3] = Integer.toString(예금자잔액 + 이체금액);
			데이터임시저장소.set(세션번호확인(), 입금자정보);
			데이터임시저장소.set(예금자번호, 예금자정보);
			데이터베이스.이체(데이터임시저장소, 멤버, 세션번호확인(), 예금자번호);
			break;
		}
	}

	public void 잔액조회(Member 멤버) {
		데이터임시저장소 = 멤버.getMemberDto();
		String[] 사용자정보 = 데이터임시저장소.get(세션번호확인());
		int 잔액 = Integer.parseInt(사용자정보[3]);
		System.out.println("현재 잔액 : " + 잔액);
	}

	public void 탈퇴(Member 멤버) {
		데이터임시저장소 = 멤버.getMemberDto();
		데이터임시저장소.remove(세션번호확인());
		데이터베이스.탈퇴(데이터임시저장소, 멤버);
		세션삭제();
	}
}
