package day0315;

public class Ex4_main_args {
	public static void main(String[] args) {
		// args 설정 : run옆 화살표 -> Run configuration -> Argument -> Program argument
		System.out.println(args[0]);
		System.out.println(args[1]);
		
		System.out.println(args[2] + args[3]);
		int s1 = Integer.parseInt(args[2]);	//"10"이 정수 10으로 변환 / wrapper class의 용도
		int s2 = Integer.parseInt(args[3]);
		System.out.println(s1 + s2);
		
	}
}
