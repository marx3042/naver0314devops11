package day0320;

public class Ex01_math_random {
	public static void main(String[] args) {
		System.out.println("Math.Random() 을 이용한 난수 구하기");
		
		System.out.println("1. random first\n");
		for(int i = 0; i < 10; i++) {
			double d = Math.random();	//0.0 <= r < 1.0
			System.out.println(d);
		}
		System.out.println("=".repeat(30));
		
		System.out.println("2. 0 ~ 9 number\n");
		for(int i = 0; i < 10; i++) {
			int n = (int)(Math.random() * 10);	//0.0 <= r < 1.0
			System.out.printf("%4d", n);
		}
		System.out.println();
		System.out.println("=".repeat(30));
		
		System.out.println("3. 1 ~ 10 number\n");
		for(int i = 0; i < 10; i++) {
			int n = (int)(Math.random() * 10) + 1;	//0.0 <= r < 1.0
			System.out.printf("%4d", n);
		}
		System.out.println();	
		System.out.println("=".repeat(30));
		
		System.out.println("4. 1 ~ 100 number\n");
		for(int i = 0; i < 10; i++) {
			int n = (int)(Math.random() * 100) + 1;	//0.0 <= r < 1.0
			System.out.printf("%4d", n);
		}
		System.out.println();	
		System.out.println("=".repeat(30));
		
		System.out.println("5. A ~ Z char\n");
		for(int i = 0; i < 10; i++) {
			char c = (char)((Math.random() * 26) + 65);	//0.0 <= r < 1.0
			System.out.printf("%4c", c);
		}
		System.out.println();	
		System.out.println("=".repeat(30));
		
		System.out.println("6. a ~ z char\n");
		for(int i = 0; i < 10; i++) {
			int c2 = (int)(Math.random() * 26) + 97;	//0.0 <= r < 1.0
			System.out.printf("%4c", (char)c2);
		}
		System.out.println();	
		System.out.println("=".repeat(30));
	}
}
