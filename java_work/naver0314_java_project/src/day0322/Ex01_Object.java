package day0322;

class Apple
{
	String msg="Happy Day!!";//인스턴스 멤버변수
	static String message="오늘은 금요일";//static 멤버변수(클래스 멤버변수)
}

class Banana{
	static int kor=100;
	static int eng=80;
	String name="마이클";
}

public class Ex01_Object {
	//멤버 변수들
	String name="홍길동";//인스턴스 변수
	final static int MAX=100;//static 변수,final : 상수 지정,값변경이 안됨

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * static 멤버 메서드는 static 멤버 변수나 static 멤버메서드만
		 * 접근이 가능하다
		 * 일반 인스턴스 메서드나 변수를 접근하기 위해서는 new 로 생성후
		 * 그 변수를 이용해서 호출해야만 한다
		 */
		//System.out.println(name);//오류 발생
		System.out.println(Ex01_Object.MAX);//static 변수는 클래스명.변수명
		System.out.println(MAX);//같은 클래스일경우는 앞에 클래스명은 생략이 가능하다
		
		
		//name 을 출력하려면 new 생성한 인스턴스 변수가 필요하다
		Ex01_Object ex=new Ex01_Object();
		//ex가 인스턴스 변수이다. 이 변수를 이용해야만 name 이 접근이 가능하다
		System.out.println(ex.name);
		
		//Apple 이 가진 2개의 멤버변수를 출력해보세요
		System.out.println(Apple.message);
		Apple apple=new Apple();
		System.out.println(apple.msg);
		
		//Banana 클래스의 kor,eng 점수 출력하고 합계도 출력
		int sum=Banana.kor+Banana.eng;
		System.out.println("국어점수:"+Banana.kor);
		System.out.println("영어점수:"+Banana.eng);
		System.out.println("합계:"+sum);
		//Banana 클래스의 name 도 출력해보세요
		Banana b=new Banana();
		System.out.println("이름:"+b.name);
		
	}

}











