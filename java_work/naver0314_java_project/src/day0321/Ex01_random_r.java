package day0321;

import java.lang.reflect.Array;

public class Ex01_random_r {
	public static void main(String[] args) {
		/*
		 * 1~30까지 난수 10개를 발생하는데 중복처리하기
		 */
		
		int rand[] = new int[10];
		
		Loop:
		for(int i = 0; i < rand.length; i++) {
			int n = (int)(Math.random() * 30) + 1;
			rand[i] = n;
			
			for(int j = 0; j < i; j++) {
				if(rand[i] == rand[j]) {
					i--; 	//다시 제자리로 가기 위해서 일단 1을 빼고 이동
					continue Loop;
				}
			}
		}
		
		//순차적 정렬(오름차순)
		
		
		System.out.println("1~30까지 중복되지 않는 난수 구하기");
		
		for(int i = 0; i < rand.length; i++) {
			System.out.printf("%4d", rand[i]);
		}
		
	}
}
