package day0325;

class Animal{
	
	public void writeAnimal() {
		System.out.println("Animal 부모클래스");
		
	}
}

class Cat extends Animal {
	@Override
	public void writeAnimal() {
		System.out.println("고양이");
		
	}
}

class Dog extends Animal {
	@Override
	public void writeAnimal() {
		System.out.println("개");
		
	}
}

public class Ex09_inheri {
	public static void main(String[] args) {
		
	}
}
