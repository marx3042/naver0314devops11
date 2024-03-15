package day0315;

public class Ex3_output {
	public static void main(String[] args) {
		int year = 2024;
		int month = 3, day = 15;
		
		String msg = "Have a Nice Day!!";
		char blood = 'B';
		double avg = 97.4567;
		
		System.out.println("** 출력 1 **");
		System.out.println("날짜 : "+ year+ "-"+ "month"+ "-"+ "day");
		System.out.print("혈액형 : " + blood+"형");
		System.out.println("\t평균 : " + avg);
		System.out.println("===============================");
		System.out.printf("%.2f", avg);
	}
}
