package day0321;

import java.util.Scanner;

public class Ex06_array_lotto {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int lotto[] = new int[6];
		int money;
		/*
		 * money를 입력하면 해당 횟수 만큼 로또 구하기
		 * 로또 : 1 ~ 45 까지의 중복되지 않은 숫자
		 * 로또 금액 입력 : 800
		 * 	금액이 부족합니다
		 * 로또 금액 입력 : 0
		 * 	종료합니다
		 */
		while(true) {
			System.out.print("로또 금액 입력 : ");
			money = sc.nextInt();

			if(money == 0) {
				System.out.println("종료합니다.");
				break;
			}
			if(money < 1000) {
				System.out.println("금액이 부족합니다");
				continue;
			}

			for(int i = 0; i < money / 1000; i++) {
				Loop:
					for(int j = 0; j < lotto.length; j++) {
						int num = (int)(Math.random() * 45) + 1;
						lotto[j] = num;
						for(int k = 0; k < j; k++) {
							if(lotto[j] == lotto[k]) {
								j--;
								continue Loop;
							}
						}
					}

				System.out.print(i+1 + "회 : ");
				for(int m : lotto) {
					System.out.print(m + " ");
				}
				System.out.println();

			}		
		}
	}
}
