package work;

public class Command extends Util {

	static boolean flag = true;
	Service 서비스;
	Member 멤버;
	public Command() {
		this.서비스 = new Service();
		this.멤버 = new Member();
		세션삭제();
	}
	
	public void run() {
		
		while(flag) {
			boolean 세션 = 세션확인();
			if(세션) {
				int 선택 = 로그인메뉴선택();
				로그인실행(선택);
			} else {
				int 선택 = 비로그인메뉴선택();
				비로그인실행(선택);
			}
		}
	}

	private int 로그인메뉴선택() {
		System.out.println();
		System.out.println("[멤버 관리]");
		System.out.print("[1]입금  ");
		System.out.print("[2]이체  ");
		System.out.print("[3]잔액조회  ");
		System.out.print("[4]로그아웃  ");
		System.out.print("[5]탈퇴  ");
		System.out.println("[0]종료");
		return 숫자입력();
	}
	private int 비로그인메뉴선택() {
		System.out.println();
		System.out.println("[멤버 관리]");
		System.out.print("[1]가입  ");
		System.out.print("[2]로그인  ");
		System.out.println("[0]종료");
		return 숫자입력();
	}
	
	private void 로그인실행(int 메뉴선택) {
		switch (메뉴선택) {
		case 1: {
			서비스.입금(멤버);
			break;
		}
		case 2: {
			서비스.이체(멤버);
			break;
		}
		case 3: {
			서비스.잔액조회(멤버);
			break;
		}
		case 4: {
			세션삭제();
			break;
		}
		case 5: {
			서비스.탈퇴(멤버);
			break;
		}
		case 0: {
			flag = false;
			scanner.close();
			break;
		}
		default:
			System.out.println("없는 메뉴입니다.");
		}
	}
	
	private void 비로그인실행(int 메뉴선택) {
		switch (메뉴선택) {
		case 1: {
			서비스.가입(멤버);
			break;
		}
		case 2: {
			서비스.로그인(멤버);
			break;
		}
		case 0: {
			flag = false;
			scanner.close();
			break;
		}
		default:
			System.out.println("없는 메뉴입니다.");
		}
	}
	
}
