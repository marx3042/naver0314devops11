package day0326;

import java.util.Date;

public class Ex14_Exception {
	public static void go1() throws NullPointerException, NumberFormatException{
		// Date date = null;	//NullPointerExceoption
		Date date = new Date();
		System.out.println(date.getYear() + 1900);
		
		String a = "12a";
		int n = Integer.parseInt(a);	//여기서 NUmFormatException
		System.out.println(a + 10);
	}
	
	public static void main(String[] args) {
		try {
			go1();
		} catch (NullPointerException e) {
			// TODO: handle exception
			System.out.println("Date 클래스 생성을 안하고 메소드 호출 : " + e.getMessage());
		}
		catch (NumberFormatException e) {
			// TODO: handle exception
			System.out.println("문자가 있어 숫자 변환시 오류 발생 : " + e.getMessage());
			
		}
		finally {
			//catch의 영향을 받지 않고 try이후 무조건 실행되는 부분 
			System.out.println("이 영역은 무조건 실행 됩니다!");
		}
		
		
		System.out.println("정상종료");
	}
}
