package day0318;

import java.util.Scanner;

public class Ex06_score_switch {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("점수는?");
		int num = sc.nextInt();
		char result;

		if (num < 1 || num > 100) {
			System.out.println("잘못된 점수 입니다.");
			return;
		}
		
//		switch (num / 10) {
//		case 10: 
//		case 9:
//			result = 'A';
//			break;
//		case 8:
//			result = 'B';
//			break;
//		case 7:
//			result = 'C';
//			break;
//		case 6:
//			result = 'D';
//			break;
//		default:
//			result = 'F';
//		}
		
		if(num >= 90) {
			result = 'A';
		}
		else if (num >= 80) {
			result = 'B';
		}
		else if (num >= 70) {
			result = 'C';
		}
		else if (num > 60) {
			result = 'D';
		}
		else {
			result = 'F';
		}
		
		System.out.println(num + "점은 " + result + "학점 입니다.");
		
	}
}
