package day0320;

public class Ex07_array {
	public static void main(String[] args) {
		int data[] = {23, 100, 200, -13, 67, -123, 78, 345, 3, 110};
		int max, min;
		max = min = data[0];	//무조건 첫 데이터를 max또는 min지정
		System.out.println(data.length);
		
		for(int i = 1; i < data.length; i++) {
			if(max < data[i]) {
				max = data[i];
			}
			
			if(min > data[i]) {
				min = data[i];
			}
		}
		System.out.println("최대값 : " + max);
		System.out.println("최소값 : " + min);
		
		int pcnt = 0, mcnt = 0;
		//배열 데이터중 양수의 갯수와 음수의 갯수를 구하여서 출력해보시오
		
		for(int i = 0; i < data.length; i++) {
			if(data[i] < 0) {
				mcnt++;
			}
			else if(data[i] > 0) {
				pcnt++;
			}
		}
		System.out.println("양수 : " + pcnt);
		System.out.println("음수 : " + mcnt);
	}
}
