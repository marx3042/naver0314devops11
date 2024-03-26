package day0325;

public class Ex11_Book328 {
	//매개변수의 다형성
	public static void aninalSound(Animal2 ani) {
		ani.sound();
	}
	
	public static void main(String[] args) {
	Dog1 dog = new Dog1();
	dog.sound();
	
	Cat1 cat = new Cat1();
	cat.sound();
	
	aninalSound(new Dog1());
	aninalSound(new Cat1());
	}
}
