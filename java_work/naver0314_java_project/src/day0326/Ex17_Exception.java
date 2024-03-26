package day0326;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/*
 * score.txt를 읽어서 총 갯수와 총점, 평균을 구하시오
 * 단, 점수에 문자가 있는 경우 갯수에서 제외하고 총점에서도 제외하고 출력이 되도록 하기
 * 
 * 개수 : 13개
 * 총점 : 990
 * 평균 : 78.99
 */

public class Ex17_Exception {
	static final String FILE = "E:/Java_eclipse/JV_eclipse_WorkSpace/naver0314_java_project/src/day0326/score.txt";
	
	public static void print() {
		BufferedReader br = null;
		FileReader fr = null;
		int sum = 0, count = 0;
		double avg;
		
		try {
			fr = new FileReader(FILE);
			br = new BufferedReader(fr);
			
			while(true) {
				String line = br.readLine();
				if(line == null) {
					break;
				}
				try {
					Integer num = Integer.parseInt(line);
					sum += num;
					count++;
				} catch (NumberFormatException e) {
					// TODO: handle exception
					continue;
				}
			}
			System.out.println("개수 : " + count);
			System.out.println("총점 : " + sum);
			avg = sum / count;
			System.out.printf("%.2f\n", avg);
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				fr.close();
				br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} 
		
	}
	
	public static void main(String[] args) {
		print();
	}
}
