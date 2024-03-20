package day0320;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class Ex10_array_search_startswith {
	public static void main(String[] args) {
		String members[] = {"강호동", "한가인", "유재석", "이승민", "강하나",
				"손미나", "이영자", "박남정", "한지혜", "손창민"};
		/*
		 * 검색할 이름은? 강
		 * 1번째 : 강호동
		 * 5번째 : 강하나
		 * 총 2명 검색
		 * 
		 * 검색할 이름은? 박이
		 * "박이"로 시작하는 맴버는 없습니다
		 * 
		 * 검색할 이름은? q / Q
		 * 검색을 종료합니다
		 */
		
		Scanner sc = new Scanner(System.in);
		String search, result = "";
		
		while(true) {
			System.out.print("검색할 이름은? :");
			search = sc.nextLine();
			int count = 0;
			
			if(search.equalsIgnoreCase("q")) {
				sc.close();
				System.out.println("**종료**");
				return;
			}
			
			for(String m : members) {
				if(m.startsWith(search)) {
					System.out.println(Arrays.asList(members).indexOf(m) + 1 + "번째 : " + m);
					count++;
				}
			}
			
			if(count != 0) {				
				System.out.printf("총 %d명 검색\n", count);
			}
			else {
				System.out.println("없음");
			}
			
			
		}
	}
}
