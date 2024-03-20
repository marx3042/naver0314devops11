package day0318;

import java.util.Scanner;

public class Ex07_munjae {
	public static void main(String[] args) {
		/*
		 * 이름(name), 기본급(gibon), 가족수(familysu)를 키보드로 입력 후 
		 * 가족 수가 3인 이상이면 기본급 + (가족수 *50000)으로 실 수령액을 구하고 
		 * 가족수가 3인 미만이면 기본급 + 30000원으로 실 수령액을 출력 출력
		 * 출력은
		 * 이름
		 * 기본급
		 * 가족수
		 * 실수령액
		 */
		
		Scanner sc = new Scanner(System.in);
		String name;
		int gibon, familysu, result;
		System.out.println("이름?");
		name = sc.nextLine();
		System.out.println("기본급?");
		gibon = sc.nextInt();
		System.out.println("가족수?");
		familysu = sc.nextInt();
		
		if(familysu >= 3) {
			result = gibon + (familysu * 50000);
		}
		else {
			result = gibon + 30000;
		}
		
		System.out.printf("이름 : %s\n기본급 : %d\n가족수 : %d\n실수령액 : %d", name, gibon, familysu, result);
		
		sc.close();
	}
}
