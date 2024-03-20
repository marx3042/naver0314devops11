package day0318;

public class Ex02_ascii_code {
	public static void main(String[] args) {
		// char는 내부적으로 int 타입으로 인식
		char a = 'A';
		char b = 65;
		System.out.println(a + "," + b);
		System.out.println(a + 3);
		System.out.println((char)(a + 3));
		
		char c = '7';
		System.out.println(c + 2);
		System.out.println(c - '0' + 2);
		System.out.println((c - 48) + 2);
	}
}
