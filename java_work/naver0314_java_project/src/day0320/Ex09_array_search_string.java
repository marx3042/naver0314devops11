package day0320;

import java.util.Arrays;
import java.util.Scanner;

public class Ex09_array_search_string {
	public static void main(String[] args) {
		String members[] = {"강호동", "한가인", "유재석", "이승민", "강하나",
				"손미나", "이영자", "박남정", "한지혜", "손창민"};
		/*
		 * 검색할 이름을 입력하면 몇번째에 있는지 출력
		 * 없을 경우 없다고 출력
		 * 반복해서 검색을 하다 q / Q를 입력 시 종료
		 */
		
		Scanner sc = new Scanner(System.in);
		String name, result = "no";
		while(true) {
			System.out.println("이름을 입력하세요");
			name = sc.nextLine();
			
			if(name.equalsIgnoreCase("q")) {
				System.out.println("종료");
				sc.close();
				return;
			}
			
			for(String m : members) {
				if(m.equals(name)) {
					result = m;
				}
			}
			
			if(!(result.equals("no"))){
				System.out.println(result + "은 " + (Arrays.asList(members).indexOf(result) + 1) + "번째에 있다");
			}
			else {
				System.out.println("없다");
			}						
		}
	}
}
