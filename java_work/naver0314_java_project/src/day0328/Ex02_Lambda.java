package day0328;

/*
 * 자바에서 함수형 프로그램 람다 표현식은 인터페이스 사용, 익명 내부 클래스의 다른 표현식
 * 단, 인터페이스는 단 하나의 추상 메소드만 가지고 있어어야 한다.
 * 
 * 람다 뜻 : '^'그리스어 알파벳의 11번째 글자
 */

@FunctionalInterface	//method가 하나인지 검증하는 역할
interface Orange{
	public void write();	//추가하는 순간 오류 발생
}

@FunctionalInterface
interface DataAdd{
	public void add(int x, int y);
}

public class Ex02_Lambda {
	//우리가 알고있는 익명 내부 클래스 형태로 Orange를 구현
	Orange or = new Orange() {
		
		@Override
		public void write() {
			// TODO Auto-generated method stub
			System.out.println("오랜지 먹고싶음");
		}
	};
	
	public void lambdaMethod() {
		Orange or2 = () -> System.out.println("람다식 오랜지 먹고싶음");
		or2.write();
		
		Orange or3 = () ->{
			System.out.println("안녕하세요");
			System.out.println("람다식 공부중 or3");
		};
		
		or3.write();
		
		Orange or4 = new Orange() {
			
			@Override
			public void write() {
				// TODO Auto-generated method stub
				System.out.println("평범한 익내클");
			}
		};
		
		or4.write();
	}
	
	public void lamndaMethod2() {
		DataAdd add1 = (int x, int y) -> System.out.println("두수의 합"+(x+y));
		add1.add(10, 20);
		add1.add(5, 6);
	}
	
	public static void main(String[] args) {
		Ex02_Lambda ex = new Ex02_Lambda();
		ex.or.write();
		ex.lambdaMethod();
	}
}
