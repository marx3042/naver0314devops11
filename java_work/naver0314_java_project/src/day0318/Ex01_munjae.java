package day0318;

import java.util.Scanner;

public class Ex01_munjae {
	public static void main(String[] args) {
		//score을 입력 후 점수가
		//90, 80, 70, 60, 나머지 abcdf
		//조건 연산자로
		// 점수?
		//89
		
		//89점은 b입니다
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("점수는?");
		int num = sc.nextInt();
		char result;
		
		if (num < 1 || num > 100) {
			System.out.println("잘못된 점수 입니다.");
			return;
		}
		
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
