package day0321;

import java.util.Scanner;

public class Book199_9 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int score_list[] = null;
		String input = "";
		int count = 0, student = 0;
		double avg;
		
		Loop:
			while(true) {
				System.out.println("-".repeat(45));
				System.out.println("1. 학생수 | 2. 점수입력 | 3. 점수리스트 | 4. 분석 | 5. 종료");
				System.out.println("-".repeat(45));
				System.out.print("선택> ");
				input = sc.nextLine();


				switch (input) {
				case "1": 
					System.out.print("학생 수 : ");
					student = sc.nextInt();
					sc.nextLine();
					score_list = new int[student];
					count = 0;
					break;

				case "2":
					if(score_list == null) {
						System.out.println("학생 수 먼저 입력");
						break;
					}

					for(int i = count; i < student; i++) {
						System.out.printf("score_list[%d] : ", i);
						int score = sc.nextInt();
						score_list[i] = score;
					}
					break;

				case "3":
					if(score_list == null) {
						System.out.println("학생 수 먼저 입력");
						break;
					}

					for(int i : score_list) {
						System.out.println(i);
					}
					break;

				case "4":
					if(score_list == null) {
						System.out.println("학생 수 먼저 입력");
						break;
					}

					int max = 0, min = 100, sum = 0;
					for(int i = 0; i < score_list.length; i++) {
						if(score_list[i] > max) {
							max = score_list[i];
						}
						if(score_list[i] < min) {
							min = score_list[i];
						}
						sum += score_list[i];
					}
					avg = sum / score_list.length;
					System.out.printf("최대 : %d, 최소 : %d, %.2f\n", max, min, avg);
					break;

				case "5":
					System.out.println("프로그램 종료");
					break Loop;

				default:
					System.out.println("1~5중에 입력");
					break;
				}

			}

	}
}
