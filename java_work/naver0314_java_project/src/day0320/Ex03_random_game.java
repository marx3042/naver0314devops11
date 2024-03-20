package day0320;

import java.util.Random;
import java.util.Scanner;

public class Ex03_random_game {
	public static void main(String[] args) {
		/*
		 * 1. 1 ~ 100사이의 난수를 발생한 후 숫자 알아맞추기
		 * 2. 숫자 입력 시 앞에 횟수 출력
		 * 3. 숫자 n 이 난수보다 크면 (n보다 작습니다)
		 * 4. 드디어 숫자를 맞췄을 경우 (횟수와 정답을 출력 후)
		 * 5. 계속 맞추기 게임을 하시겠습니까? (Y/N)
		 * 6. y를 누르면 다시 난수 발생 후 숫자 맞추기 시작
		 * 7. y가 아니면 게임 종료
		 */
		
		Random n = new Random();
		Scanner sc = new Scanner(System.in);
		int count;
		
		Exit:
		while(true) {
			int result = n.nextInt(100) + 1;
			count = 0;
			
			while(true) {
				System.out.printf("숫자 입력 : ");
				int num = sc.nextInt();
				if (result < num) {
					System.out.println("n보다 큽습니다");
				}
				else if(result > num) {
					System.out.println("n보다 작습니다");
				}
				else {
					System.out.printf("횟수 : %d\n정답 : %d\n", count, result);
					System.out.printf("계속 맞추기 게임을 하시겠습니까? (Y/N) : ");
					String nextC = sc.next();
					if(nextC.toLowerCase().charAt(0) == 'y') {		//nextC.equalsIgoreCase("y")
						continue Exit;	//break;
					}
					else {
						break Exit;
					}
				}
				count++;
			}
		}
		System.out.println("게임을 종료합니다");
		
	}
}
