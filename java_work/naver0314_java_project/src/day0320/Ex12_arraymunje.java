package day0320;

import java.util.Scanner;

public class Ex12_arraymunje {
	public static void main(String[] args) {
		/*
		 * 처음에 인원수(human)을 입력 받은 후 해당 인원수 만큼
		 * name, kor, eng,tot, rank 변수를 배열 할당하고
		 * 인원 수 만큼 이름, 국어, 영어점수를 입력하면
		 * 총점과 등수를 계산해서 출력하는 프로그램을 작성하시오
		 * 출력은
		 * ----
		 * 번호	이름	국어	영어	총점	등수
		 * -----
		 * 1	홍길동	100		100		200		1
		 */
		
		Scanner sc = new Scanner(System.in);
		System.out.print("몇명? : ");
		int num = sc.nextInt();
		
		String name[] = new String[num];
		int kor[] = new int[num];
		int eng[] = new int[num];
		int tot[] = new int[num];
		int rank[] = new int[num];
		
		for(int i = 0; i < num; i++) {
			System.out.print(i+1 + "번 이름 : ");
			name[i] = sc.nextLine();
			sc.nextLine();
			System.out.print(i+1 + "번 국어점수 : ");
			kor[i] = sc.nextInt();
			System.out.print(i+1 + "번 영어점수 : ");
			eng[i] = sc.nextInt();
			tot[i] = kor[i] + eng[i];
		}
		for (int i = 0; i < name.length; i++) {
			rank[i] = 1;
			for(int j = 0; j < name.length; j++) {
				if(tot[i]  < tot[j]) {
					rank[i]++;
				}
			}
		}
		System.out.println("=".repeat(45));
		System.out.println("번호\t등수\t이름\t국어\t영어\t총점\t등수");
		System.out.println("=".repeat(45));
		for(int i = 0; i < num; i++) {
			System.out.printf("%d\t%s\t%d\t%d\t%d\t%d\n", i+1, name[i], kor[i], eng[i], tot[i], rank[i]);
		}
		
	}
}

