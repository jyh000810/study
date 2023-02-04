package work;

import java.util.ArrayList;

public class DAO extends Util{

	public void 가입(Member 멤버, ArrayList<String[]> 데이터임시저장소) {
		멤버.setMemberDto(데이터임시저장소);
		String[] data = 멤버.MemberDto.get(현재사용자수(데이터임시저장소)-1);
		System.out.println(data[1] + "님 가입 축하드립니다.");
	}

	public void 입금(ArrayList<String[]> 데이터임시저장소, Member 멤버, int 세션번호) {
		멤버.setMemberDto(데이터임시저장소);
		String[] 자기정보 = 멤버.MemberDto.get(세션번호);
		System.out.println("잔액 : " + 자기정보[3] + "원");
	}

	public void 이체(ArrayList<String[]> 데이터임시저장소, Member 멤버, int 입금자번호, int 예금자번호) {
		멤버.setMemberDto(데이터임시저장소);
		String[] 입금자 = 멤버.MemberDto.get(입금자번호);
		System.out.println("입금자 잔액 : " + 입금자[3] + "원");
		String[] 예금자 = 멤버.MemberDto.get(예금자번호);
		System.out.println("예금자 잔액 : " + 예금자[3] + "원");
	}

	public void 탈퇴(ArrayList<String[]> 데이터임시저장소, Member 멤버) {
		멤버.setMemberDto(데이터임시저장소);
		System.out.println("회원탈퇴 완료했습니다.");
	}
}
