package day0320;

import java.util.Random;
import java.util.Scanner;

public class Ex08_array_searchNum {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Random r = new Random();
		int data[] = new int[10];
		int num;
		
		for (int i = 0; i< 10; i++) {
			int n = r.nextInt(20) + 1;
			data[i] = n;
		}
		
		while(true) {
			int searchIndex = -1;
			System.out.println("검색할 숫자를 입력하세요");
			num = sc.nextInt();
			if(num == 0) {
				System.out.println("검색을 종료합니다");
				return;
			}
			
			for(int i = 0; i < data.length; i ++) {
				if(num == data[i]) {
					searchIndex = i;
					break;
				}
			}
			if(searchIndex == -1) {
				System.out.println("\t" + num + "은 데이터에 없습니다");
			}
			else {
				System.out.println("\t" + num + "은 " + (searchIndex + 1) + "번째에 있습니다");
				System.out.println();
			}
			
		}
	}
}
