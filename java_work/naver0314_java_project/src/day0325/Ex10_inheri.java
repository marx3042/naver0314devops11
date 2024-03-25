package day0325;

public class Ex10_inheri {
	
	//다형성
	public static void showAnimal(Animal ani) {
		ani.writeAnimal();
	}
	
	public static void main(String[] args) {
		showAnimal(new Dog());
		showAnimal(new Cat());
	}
}
