package day0326;

import day0326.OunterClass.InnerClass;

class OunterClass{
	int a = 10;
	static int b = 20;
	
	class InnerClass{
		int c = 30;
		static int d = 40;	//jdk11 버전에서는 오류, member inner class에서는 static변수 선언 불가, jdk17에서는 가능
		
		public void show() {
			System.out.println(a);
			System.out.println(b);
			System.out.println(c);
			System.out.println(d);
		}
	}
	
	//정적 내부 클래스
	static class InnerClass2{
		int e = 50;
		static int f = 60;
		public void show() {
			// System.out.println(a);	static  내부 클래스에서는 외부 클래스의 instance 변수 호출 불가
			System.out.println(b);
			//System.out.println(c);
			//System.out.println(d);
			System.out.println(e);
			System.out.println(f);
		}
	}
	
	public void disp() {
		InnerClass in = new InnerClass();
		in.show();
		
		InnerClass2 in2 = new InnerClass2();
		in2.show();
	}
	
}


public class Ex09_innerClass {
	public static void main(String[] args) {
		OunterClass oc = new OunterClass();
		oc.disp();
		
		
		
	}
}
