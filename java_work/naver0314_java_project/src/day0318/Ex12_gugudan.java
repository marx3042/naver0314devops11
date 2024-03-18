package day0318;

import java.util.Scanner;

public class Ex12_gugudan {
	public static void main(String[] args) {
		/*
		 * 구구단
		 * */
		Scanner sc = new Scanner(System.in);
		
		System.out.print("구구단?");
		int num;
		num = sc.nextInt();
		if (!(num > 2 && num < 10)) {
			System.out.println("잘못된 숫자입니다");
			return;
		}
		
		System.out.printf("** %d단 **\n", num);
		for (int i = 1; i < 10; i++) {
			System.out.printf("%d * %d = %d\n".formatted(num, i, num * i));
		}
	}
}
