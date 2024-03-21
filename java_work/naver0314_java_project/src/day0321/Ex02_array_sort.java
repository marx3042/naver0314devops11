package day0321;

public class Ex02_array_sort {
	public static void main(String[] args) {
		//두 값을 바꿀 경우
		int arr[] = {5, 8, 2,1, 10};
		
		for(int i = 0; i < arr.length; i++) {
			for(int j = i + 1; j < arr.length; j++) {
				if(arr[i] > arr[j]) {
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
		
		for(int i : arr) {
			System.out.print(i + "\t");
		}
	}
}
