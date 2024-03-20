package day0315;

import java.util.Scanner;

public class Ex12_munja {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("점수 입력 : ");
		int score;
		score = sc.nextInt();
		
		String msg = score >= 90 ? "참 잘했어요" : score >= 80 ? "수고했어요" : score >= 70 ? "조금 더 노력하세요" : "재시험입니다.";
		
		System.out.println(msg);
		
		
	}
}
