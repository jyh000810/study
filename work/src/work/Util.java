package work;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Util {
	
	Scanner scanner;
	
	public Util() {
		this.scanner = new Scanner(System.in);
	}
	
	public boolean 빈값확인(String 값) {
		if(값 == null || 값 == "") {
			return true;
		}
		return false;
	}
	
	public boolean 빈값확인(int 값) {
		if(값 <= 0) {
			return true;
		}
		return false;
	}
	
	public String 문자열입력() {
		String 값 = scanner.next();
		return 값;
	}
	
	public int 숫자입력() {
		int 값 = scanner.nextInt();
		scanner.nextLine();
		return 값;
	}
	
	public boolean 중복검사(String 문자열입력, ArrayList<String[]> 데이터임시저장소) {
		for(String[] 데이터 : 데이터임시저장소) {
			if(문자열입력.equals(데이터[1])) {
				System.out.println("중복된 데이터입니다.");
				return true;
			}
		}
		return false;
	}
	
	public int 현재사용자수(ArrayList<String[]> 데이터임시저장소) {
		return 데이터임시저장소.size();
	}
	
	public void 세션생성(String ID) {
		File file = new File("C:\\Users\\Administrator\\session.txt");
		if(!file.exists()) {
			try {
				if(file.createNewFile()) {
					BufferedWriter writer = new BufferedWriter(new FileWriter(file, true));
					writer.write(ID);
					writer.close();
					System.out.println("세션 생성");
				}
			} catch (IOException e) {
				System.out.println("세션 생성 불가");
			}
		} else {
			if (file.delete()) {
				try {
					if(file.createNewFile()) {
						System.out.println("세션 생성");
					}
				} catch (IOException e) {
					System.out.println("세션 생성 불가");
				}
			} else {
				System.out.println("세션 생성 불가");
			}
		}
				
	}
	
	public void 세션삭제() {
		File file = new File("C:\\Users\\Administrator\\session.txt");
		if(file.exists()) {
			if(file.delete()) {
				System.out.println("세션을 삭제했습니다.");
			} else {
				System.out.println("세션 삭제 불가");
			}
		}
	}
	
	public boolean 세션확인() {
		File file = new File("C:\\Users\\Administrator\\session.txt");
		if(file.exists()) {
			System.out.println("로그인 된 사용자입니다.");
			return true;
		} else {
			System.out.println("로그인 안된 사용자입니다.");
		}
		return false;
	}
	
	public int 세션번호확인() {
		File file = new File("C:\\Users\\Administrator\\session.txt");
		if(file.exists()) {
			try {
				BufferedReader reader = new BufferedReader(new FileReader(file));
				try {
					String ID = reader.readLine();
					reader.close();
					return Integer.parseInt(ID);
				} catch (IOException e) {
					System.out.println("세션에 저장된 아이디가 없습니다.");
				} 
			} catch (FileNotFoundException e) {
				System.out.println("세션 확인 불가");
			}
		}
		return -1;
	}
}
