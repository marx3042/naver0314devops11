package day0326;

import java.util.Scanner;

public class Ex13_exception {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.println("두 수를 입력하세요");
			String s1 = sc.nextLine();
			String s2 = sc.nextLine();
			if(s1.equals("x") || s2.equals("x2")) {
				break;
			}

			//숫자형태의 문자열을 숫자로 반화
			//숫자 변환시 문자가 섞여있으면 NumberFormatException이 발생
			try {
				int n1 = Integer.parseInt(s1);
				int n2 = Integer.parseInt(s2);
				int sum = n1 + n2;
				System.out.printf("%d + %d = %d\n", n1, n2, sum);
			} catch (NumberFormatException e) {
				// TODO: handle exception
				System.out.println("문자가 입력되었어요:" + e.getMessage());
				
			}
			

		}
	}
}
