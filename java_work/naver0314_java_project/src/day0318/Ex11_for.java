package day0318;

import java.util.Scanner;

public class Ex11_for {
	public static void main(String[] args) {
		int sum = 0;

		for(int i = 1; i <= 100; i++) {
			sum += i;
		}
		System.out.println(sum);
		
		sum = 0;
		Scanner sc = new Scanner(System.in);
		int x, y;
		System.out.println("합계를 구할 시작 값");
		x = sc.nextInt();
		System.out.println("합계를 구할 끝 값");
		y = sc.nextInt();

		for (int i = x; i < y; i++) {
			sum += i;
		}
		System.out.printf("%d ~ %d 까지의 합 : %d\n".formatted(x, y, sum));
	}
}
