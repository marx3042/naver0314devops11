package day0325;

//상속
class AA {
	public AA() {
		System.out.println("AA의 디폴트 생성자");
	}
	AA(String msg){
		System.out.println(msg + "문자열을 받는 생성자(AA)");
	}
}

class BB extends AA {
	public BB() {
		System.out.println("BB의 디폴트 생성자");
	}
	BB(String msg){
		super(msg);
		System.out.println(msg + "문자열을 받는 생성자(BB)");
	}
	
}

public class Ex04_inheri {
	public static void main(String[] args) {
		BB b = new BB();
		System.out.println();
		BB b2 = new BB("Hello");
		
		
	}
}
