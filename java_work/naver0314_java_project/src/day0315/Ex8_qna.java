package day0315;

import java.security.DrbgParameters.NextBytes;
import java.util.Scanner;

public class Ex8_qna {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String name, phoneNum;
		int age;
		name = sc.nextLine();
		phoneNum = sc.nextLine();
		age = sc.nextInt();
		System.out.println(name +  phoneNum + (2024 - age));
	}
}
