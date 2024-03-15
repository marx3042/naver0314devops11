package day0315;

import java.util.Scanner;

public class Ex5_scanner {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String msg = "";
		System.out.print("메세지를 입력하세요 : ");
		msg = sc.nextLine();
		
		System.out.println("입력한 문자열은\""+ msg + "\"입니다.");
		
		int age;
		
		age = Integer.parseInt(sc.nextLine());
		System.out.println("내 나이는" + age + "입니다.");
		
	}
}
