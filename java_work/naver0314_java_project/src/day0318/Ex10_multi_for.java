package day0318;

public class Ex10_multi_for {
	public static void main(String[] args) {
		for(int i = 0; i < 5; i++) {
			System.out.println("Hello");
			for(int j = 0; j < 4; j++) {
				System.out.print("\tkitty~");
			}
			System.out.println();
		}
		
		System.out.println("---------------------");
		
		for(int i = 1; i <= 5;i++) {
			for (int j = 1; j <= 3; j++) {
				System.out.printf("i = %d, j == %d\n", i, j);
			}
			System.out.println("------------------");
		}
		
		System.out.println("---------------------");
		
		// 레이블명은 마음대로 준다(대문자 약속)
		Exit123: 
		for(int i = 1; i <= 5;i++) {
			for (int j = 1; j <= 3; j++) {
				System.out.printf("i = %d, j == %d\n", i, j);
				if(j == 2) {
					break Exit123;
				}
			}
			System.out.println("------------------");
		}
		
	}
}
