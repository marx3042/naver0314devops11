package day0321;

public class Ex03_array_string_sort {
	public static void main(String[] args) {
		String arr[] = {"하석진", "강호동", "강호마", "Candy", "손석구"};
		//정렬
		
		for(int i = 0; i < arr.length - 1; i++) {
			for(int j = i + 1; j < arr.length; j++) {
				if(arr[i].compareTo(arr[j] ) > 0) {
					String tempS = arr[i];
					arr[i] =arr[j];
					arr[j] = tempS;
				}
			}
		}
		
		for(String m : arr) {
			System.out.print(m + "\t");
		}
		
	}
}
