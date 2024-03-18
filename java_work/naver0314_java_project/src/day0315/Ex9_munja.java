package day0315;

import java.util.Scanner;

public class Ex9_munja {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int num;
		num = sc.nextInt();
		
		System.out.println("만원 : " + num / 10000);
		System.out.println("천원 : " + num / 1000);
		System.out.println("백원 : " + num / 100);
		System.out.println("십원 : " + num / 10);
		System.out.println("일원 : " + num / 1);
		
	}
}
