package day0322;

class Stu
{
	String name="이영자";
	String blood="A";
	int age=12;	
}

public class Ex06_CallByReference {

	public static void changeStu(Stu s)
	{
		//주소를 통해서 main 의 s변수의 값을 직접 변경
		s.blood="O";
		s.age=34;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stu s=new Stu();
		System.out.println(s.name+","+s.blood+","+s.age);
		changeStu(s);//Call By Reference : 주소가 전달
		System.out.println("메서드 호출후 다시 출력");
		System.out.println(s.name+","+s.blood+","+s.age);
		
	}

}
