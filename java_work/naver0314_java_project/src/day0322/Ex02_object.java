package day0322;

class Orange{
	//private 접근지정자는 같은 클래스내에서만 접근이 가능
	private String name;
	private int age;
	
	private static String company = "삼성";
	
	
	//getter 매서드 : call by reference(규칙 : getName, getAge)
	public String getName() {
		//this : 자기자신을 의미하는 인스턴스 변수(일반 맴버메서드에만 존재, static메서드에는 없음)
		return this.name;
		//return name;	//같은 구역안에 같은 이름이 없을경우에만 this생략 가능
	}
	public int getAge() {
		return this.age;
	}
	
	//외부로부터 값을 받아서 맴버변수의 값을 변경
	public void setName(String name) {
		this.name = name;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	
	//static 변수를 반환하는 메서드
	public static String getCompany() {
		return company;
	}
}

public class Ex02_object {
	public static void main(String[] args) {
		Orange or = new Orange();
		System.out.println(or.getName());
		
		or.setAge(23);
		or.setName("new");
		
		System.out.println(or.getAge() + or.getName());
		
		System.out.println(Orange.getCompany());
	}
}
