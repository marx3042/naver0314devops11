package day0326;

interface Apple{
	public void one();
}

//interface끼리 상속은 extends
interface Banana extends Apple{
	//banana를 구현할 클래스는 one, two모두 구현해야함
	public void two();
}

class Orange implements Banana{
	@Override
	public void one() {
		// TODO Auto-generated method stub
		System.out.println("오랜하나");
	}
	
	@Override
	public void two() {
		// TODO Auto-generated method stub
		System.out.println("오랜둘");
	}
	public void three() {
		System.out.println("오랜셋");
	}
}

public class ex05_interface {
	public static void main(String[] args) {
		Banana b = new Orange();
		b.one();
		b.two();
		((Orange)b ).three();
	}

}
