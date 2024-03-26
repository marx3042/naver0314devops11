package day0326;

//구현 가능한 목록을 나열만 한고 실제(body)가 없다
//상수와 추상 메소드로만 구성 되어있다.

interface InterA{
	int MAX = 10;	//상수지만 구분할 필요가 없으므로 final 생략
	public void disp();	//추상 메소드지만 구분할 필요가 없으므로 abstract 생략
	public void study();
}

class MyInter implements InterA{

	@Override
	public void disp() {
		// TODO Auto-generated method stub
		System.out.println("현재 최대 인원 수는 "+MAX+"명입니다");
	}

	@Override
	public void study() {
		// TODO Auto-generated method stub
		System.out.println("우리 인터 공부중");
	}
	
	public void play() {
		System.out.println("게임");
	}
	
}

public class Ex04_interface {
	public static void main(String[] args) {
		InterA a = new MyInter();
		a.disp();
		a.study();
		//a.play();	//호출 안된
		//sub class down casting 후 호출
		((MyInter)a).play();
	}
}
