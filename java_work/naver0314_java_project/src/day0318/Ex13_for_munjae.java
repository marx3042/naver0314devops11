package day0318;

import java.util.Scanner;

public class Ex13_for_munjae {
	public static void main(String[] args) {
		System.out.println("지수승 구하기");
		System.out.println("3의 3승은" + (int)Math.pow(3, 3));
		
		Scanner sc = new Scanner(System.in);
		int x, y, result = 1;
		x = sc.nextInt();
		y = sc.nextInt();
		
		
		for (int i = 0; i < y; i++) {
			result *= x;
		}
		System.out.println(result);
		
	}
}
