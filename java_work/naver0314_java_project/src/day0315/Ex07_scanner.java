package day0315;

import java.util.Scanner;

public class Ex07_scanner {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int kor, eng;
		String name;
		System.out.println("국어 점수는?");
		kor = Integer.parseInt(sc.nextLine());
		System.out.println("영어 점수는?");
		eng = Integer.parseInt(sc.nextLine());
		
		// sc.nextLine();	//버퍼에서 엔터입력를 비워주기 위해 사용
		
		System.out.println("이름은?");
		name = sc.nextLine();	//정수 입력 후 엔터를 입력하면 엔터를 버퍼에서 읽어와 입력 불가
		
		System.out.println("이름 : " + name);
		System.out.printf("국어점수 %d점, 영어점수 %d점\n", kor, eng);
		// System.out.printf("총점 : %d점, 평균 %d점", kor+eng, (kor+eng)/2);
		System.out.printf("총점 : %d점, 평균 %.2f점", kor+eng, (kor+eng)/2.0);	//묵시적 형변환 integer / double로 인해 double
	}
}
