package day0321;

import java.util.Scanner;

public class Ex04_array_alpa_count {
	public static void main(String[] args) {
		/*
		 * 영어문장을 입력하면 알파벳 기준으로 각각의 갯수를 출력하시오
		 */
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("영문 문장을 입력하세요");
		String msg = sc.nextLine();
		int count[] = new int[26];
		
		for (int i = 0; i < msg.length(); i++) {
			char ch = msg.toLowerCase().charAt(i);
			
			if (ch >= 'a' && ch <= 'z') {
				count[ch - 'a']++;				
			}
			
			//			for(int j = 0; j < 26; j++) {
//				if(msg.toLowerCase().charAt(i) == (j + 97)) {
//					count[j]++;
//				}
//			}
		}
		
		for (int i = 0; i < count.length; i++) {
			if(count[i] != 0) {
				System.out.printf("%s : %d\n", (char)(i + 97), count[i]);
			}
		}
		
		
	}
}
