package day0318;

import java.util.Scanner;

public class Ex04_switch_string {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String color;
		color = sc.next();
		
		//swith에서 문자열도 가능(JDK8 부터)
		switch(color) {
		// break가 없으면 그 다음 case가 실행
		case "RED":
		case "red":
			System.out.println("빨강색");
			 break;
		case "green":
			System.out.println("초록색");
			break;
		case "pink":
			System.out.println("분홍색");
			break;
		default:
			System.out.println("빨강, 초록, 분홍 이외의 색");
		}
		
	}
}
