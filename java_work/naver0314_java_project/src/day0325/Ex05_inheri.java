package day0325;

//같은 패키지내에서는 부모가 가진 method중 private을 제외하고 모두 상속받음

class Parent1 {
	
	void method1() {
		System.out.println("부모의 default method");
	}
	
	protected void method2() {
		System.out.println("부모의 protected method");
	}

	private void method3() {
		System.out.println("부모의 private method");
	}

	public void method4() {
		System.out.println("부모의 public method");
	}
	

}

class Sub1 extends Parent1 {
	public void show() {
		this.method1();	//부모가 다른 패키지에 있다면 default 도 호출안됨
		this.method2();	//protected	: 상속관계라면 다른 패키지에서도 호출 가능
		this.method4();	//자유롭게 상속, 호출가능
		
		// this.method3();	//private 는 상속안됨
		System.out.println("super 로 호출");
		// 같은 구역안에 같은 이름의 메소드가 존재할 경우 상속자와 부모의 메소드 구분 짓기
		// 부모와 같은 이름의 메소드를 override method 라고 한다
		super.method1();
		super.method2();
		super.method4();
	}
}

public class Ex05_inheri {
	public static void main(String[] args) {
		Sub1 s = new Sub1();
		s.show();
	}
}
