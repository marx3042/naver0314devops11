package day0315;

import java.util.Scanner;

public class Ex11_operater {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int num1, num2, num3;
		System.out.println("3걔의 숫자 입력");
		num1 = sc.nextInt();
		num2 = sc.nextInt();
		num3 = sc.nextInt();
		
		int max = (num1 > num2 && num1 > num3) ? num1 : (num2 > num3 ? num2 : num3);
		
	}
}
