package day0320;


import java.util.Date;
import java.util.Scanner;

public class Ex04_my_calander {
	public static void main(String[] args) {
		/*
		 * 년도와 월을 입력하면 해당 달력을 출력하시오
		 * 
		 * 만년 달력을 만들기 위해 알아야할 사항 2가지
		 * 1. 내가 입력한 년도 - 월의 1일이 무슨 요일인가
		 * 2. 내가 입력한 년도 - 월이 몇일까지 있는가?
		 */
		
		Scanner sc = new Scanner(System.in);
		int year, month, week, endday;
		System.out.println("달력을 조회할 년도와 월을 입력하세요");
		year = sc.nextInt();
		month = sc.nextInt();
		
		if(month < 1 || month > 12) {
			System.out.println("잘못된 숫자 입니다.");
			return;
		}
		
		System.out.printf("%10d년 %d월 달력\n\n", year, month);
		System.out.println("=".repeat(50));
		System.out.println("일\t월\t화\t수\t목\t금\t토");
		System.out.println("=".repeat(50));
		
		//1. 내가 입력한 년도-월의 1일이 무슨 요일인가
		Date date = new Date(year - 1900, month - 1, 1);
		week = date.getDay();
		// System.out.println(week);
		
		//2. 내가 입력한 년도-월이 몇일까지 있는가
//		if( month == 2) {
//			endday = (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) ? 29 : 28;
//		}
//		else if ((month < 8 && month % 2 != 0) || (month >= 8 && month %2 == 0)) {
//			endday = 31;
//		}
//		else {
//			endday = 30;
//		}
		
		switch (month) {
		case 2: 
			endday = (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) ? 29 : 28;
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			endday = 30;
			break;
		default:
			endday = 31;
		}
		
		for(int i = 1; i <= week; i++) {
			System.out.print("\t");
		}
		
		//1일부터 endday까지 출력
		//조건 : 토요일은 출력 후 \n
		for(int i = 1; i <= endday; i++) {
			System.out.printf("%2d\t", i);
			++week;	//토요일이 되면 7의 배수가 된다
			if(week % 7 == 0) {
				System.out.println("\n");
			}
		}
	}
}
