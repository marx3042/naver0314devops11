package day0321;

public class Ex05_array_age_count {
	public static void main(String[] args) {
		int memberAges[] = {12, 56,34,23,34,59,46,6,11,29,32,59,51,28,44,55,5,7};
		System.out.println("총 인원 수 : " + memberAges.length);
		
		int ageCount[] = new int[6];
		
		/*
		 * 연령별 인원수를 구해서 출력하시오
		 * 
		 * 10세 미만 : 3명
		 * ...
		 * 50대 : 10명
		 */
		
		for (int i = 0; i < memberAges.length; i++) {
			ageCount[memberAges[i] / 10]++;
		}
		
		for(int i = 0; i < ageCount.length; i++) {
			if (i == 0)	{
				System.out.println("10세 미만 : " + ageCount[i] + "명");
				continue;
			}
			System.out.printf("%d대 : %d명\n", i * 10, ageCount[i]);
		}
		
	}
}
