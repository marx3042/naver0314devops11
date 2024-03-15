package day0315;

public class Ex1_data_type {
	public static void main(String[] args) {
		byte a = 127;
		System.out.println(a);
		
		//cast연산자 : 강제로 형변환, 값 손실
		byte b = (byte)200;
		System.out.println(b);	//값손실이 발생 할 경우 내부적으로 2의 보수로 계산하여 출력
		
		float f1 = 123.567891234f;	//f를 붙여야 4바이트 float로 저장
		double f2 = 123.567891234;
		
		System.out.println(f1 + "\n" + f2);	//f1은 보통 8자리, f2는 보통 15자리까지 정확히 나온다
		
		//문자열 지정 방법
		String str1 = new String("hello");
		String str2 = "hi";

		//JDK 15부터 가능, 텍스트 블럭
		String str3 = """
				나는 오늘도 자바를 공부한다..
				오늘은 즐거운 금요일
				궁시렁 궁시렁
				""";
		
		System.out.println(str1);
		System.out.println();
		System.out.println(str2);
		System.out.println();
		System.out.println(str3);	//"""은 자동 줄바꿈 해줌
		
		
	}
}
