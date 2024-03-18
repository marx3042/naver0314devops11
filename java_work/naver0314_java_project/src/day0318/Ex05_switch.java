package day0318;

import java.util.Scanner;

public class Ex05_switch {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int year, month, days;
		
		System.out.println("년도를 입력하세요");
		year = sc.nextInt();
		
		boolean flag = year % 4 == 0 && year % 100 != 0  || year % 400 == 0;
		
		if(flag) {
			System.out.println(year + "년은 윤년입니다.");
		}
		else {
			System.out.println(year + "년은 평년입니다.");
		}
		
		//1보다 작거나 12보다 크면 "잘못 입력했어요" 출력 후 메인함수 종료
		System.out.println("월을 입력하세요");
		month = sc.nextInt();
		if(month < 1 || month > 12) {
			System.out.println("잘못 입력했어요");
			sc.close();
			return;
		}
		
//		switch (month) {
//		case 2: {
//			days = flag ? 29 : 28;
//			break;
//		}
//		case 4:
//		case 6:
//		case 9:
//		case 11:
//			days = 30;
//			break;
//		default:
//			days = 31;
//		}
		
		if(month == 2) {
			days = flag ? 29 : 28;
		}
		else if ((month < 8 && month % 2 != 0) || (month >= 8 && month % 2 == 0)) {
			days = 31;
		}
		else {
			days = 30;
		}
		
		System.out.println(year + "년 " + month + "월은 " + days + "일까지 있습니다");
		
		sc.close();
	}
}
