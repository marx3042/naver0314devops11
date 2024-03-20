package day0318;

public class Ex09_for {
	public static void main(String[] args) {
		for(int i = 0; i <= 10; i++) {
			if(i % 2 == 0) {
				continue;
			}
			System.out.printf("%3d", i);
		}
	}
}
