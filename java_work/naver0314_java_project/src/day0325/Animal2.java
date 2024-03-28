package day0325;


public abstract class Animal2 {
	public void breathe() {
		System.out.println("숨을 쉽니다");
	}
	
	public abstract void sound();
}

class Dog1 extends Animal2 {
	@Override
	public void sound() {
		System.out.println("멍멍");
	}
}

class Cat1 extends Animal2{
	@Override
	public void sound() {
		System.out.println("야옹");
		
	}
}