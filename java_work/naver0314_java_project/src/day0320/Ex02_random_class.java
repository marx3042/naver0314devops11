package day0320;

import java.util.Random;

public class Ex02_random_class {
	public static void main(String[] args) {
		Random r = new Random();
		System.out.println("random class 난수 구하기");
		System.out.println("1. 0~9 random number");
		for(int i = 0; i < 5; i++) {
			int n = r.nextInt(10);
			System.out.printf("%4d", n);
		}
		System.out.println();
		System.out.println("=".repeat(30));
		
		System.out.println("1. 1~10 random number");
		for(int i = 0; i < 5; i++) {
			int n = r.nextInt(10) + 1;
			System.out.printf("%4d", n);
		}
		System.out.println();
		System.out.println("=".repeat(30));
		
		System.out.println("3. 1~100 random number");
		for(int i = 0; i < 5; i++) {
			int n = r.nextInt(100) + 1;
			System.out.printf("%4d", n);
		}
		System.out.println();
		System.out.println("=".repeat(30));
		
		System.out.println("4. A~Z random number");
		for(int i = 0; i < 5; i++) {
			int n = r.nextInt(26) + 65;
			System.out.printf("%4c", (char)n);
		}
		System.out.println();
		System.out.println("=".repeat(30));
		
		System.out.println("5. a~z random number");
		for(int i = 0; i < 5; i++) {
			int n = r.nextInt(26) + 97;
			System.out.printf("%4c", (char)n);
		}
		System.out.println();
		System.out.println("=".repeat(30));
	}
}
