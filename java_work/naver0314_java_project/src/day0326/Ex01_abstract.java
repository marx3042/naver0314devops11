package day0326;

//abstract(추상화) 메소드는 override의 강제성을부여하기 위해 body({}); 없이 구현
//클래스와 메소드 양쪽 앞에 abstract를 붗여 추상 메소드를 선언한다
// abstract 메소드를 한개 이상 포함하고 있는 클래스는 추상 클래스
//단, 추상 클래스는 그 자체로는 생성 할 수 없다.
////추상 클래스를 상속받은 서브 클래스는 반드시 추상 메소드를 오버라이드 해야만 한다
//만약 오버라이드 하지 않.았.을. 경우 sub class 도 추상화 하여야 한다

abstract class Animal{
	
	abstract public void sound();
	
	//추상 클래스에는 추상 메소드 뿐 아니라 일반 메소드도 포함 할 수 있다.
	public void showTitle() {
		System.out.println("추상 클래스 공부중");
	}
	
}

class Dog extends Animal{
	@Override
	public void sound() {
		System.out.println("멍멍");
	}	
}

class Chick extends Animal {
	@Override
	public void sound() {
		System.out.println("삐약삐약");
	}
}

class Cat extends Animal{
	@Override
	public void sound() {
		System.out.println("야옹야옹");
	}
}

public class Ex01_abstract {
	
	public static void hello(Animal ani) {
		ani.sound();
	}
	
	public static void main(String[] args) {
		hello(new Cat());
		hello(new Dog());
		hello(new Chick());
		// hello(new Animal()); //추상 클래스는 객체 생성 불가
	}
}
