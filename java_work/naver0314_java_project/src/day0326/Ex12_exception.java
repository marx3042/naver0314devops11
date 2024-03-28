package day0326;

public class Ex12_exception {
	public static void main(String[] args) {
		int arr[] = {3, 4, 5, 10};
		
		for(int i = 0; i <= arr.length; i++) {
			
			try {
				System.out.println(i + ":" + arr[i]);				
			} catch (ArrayIndexOutOfBoundsException e) {
				// TODO: handle exception
				// e.printStackTrace(); 	//에러 추적 - 라인번호 출력
				System.out.println("배열 인덱스 오류 : "+e.getMessage());
			}
		}
		System.out.println("종료");
		
		
	}
}
