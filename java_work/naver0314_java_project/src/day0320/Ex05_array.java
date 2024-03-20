package day0320;

public class Ex05_array {
	public static void main(String[] args) {
		//배열 선언 여러가지 방법
		int arr1[];
		//arr1에 배열에 몇개를 넣을지 갯수만큼 할당
		arr1 = new int[5];	//이때 각 배열에는 0의 초기값이 할당 된다(객체인경우(Integer, String..) null로 초기값이 할당)
		
		System.out.println("arr1의 초기값 출력");
		for(int i = 0; i < arr1.length; i++) {
			System.out.printf("{}\t",arr1[i]);
		}
		
		System.out.println("배열의 일부 값을 변경 후 출력해보자");
		arr1[0] = 5;
		arr1[4] = 30;
		
		System.out.println("다른 방법으로 출력");
		for(int i : arr1) {
			System.out.println(i);
		}
		
<<<<<<< HEAD
=======
		
>>>>>>> 6f04c524aaf04250c47e4dd08ccd7b4f52012f51
	}
}
