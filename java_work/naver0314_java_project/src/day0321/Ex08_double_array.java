package day0321;

public class Ex08_double_array {
	public static void main(String[] args) {
		int arr[][];
		arr = new int[2][3];
		System.out.println("행 개수 : "+ arr.length);
		System.out.println("0번행의 열 갯수 : " + arr[0].length);
		
		arr[0][0] = 3;
		arr[0][2] = 10;
		
		arr[1][1] = 30;
		arr[1][2] = 50;
		
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr[i].length; j++) {
				System.out.printf("arr[%d][%d] = %d\t",i, j, arr[i][j]);
				
			}
			System.out.println();
		}
	}
}
