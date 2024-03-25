package day0322;

class Member {
	private String name;
	private String hp;
	private String addr;
	
	public Member() {
		this("이름없음", "010", "서울");
		
	}
	public Member(String name) {
		this.name = name;
	}
	public Member(String name, String hp) {
		this.name = name;
		this.hp = hp;
	}
	public Member(String name, String hp, String addr) {
		this.name = name;
		this.hp = hp;
		this.addr = addr;
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getHp() {
		return hp;
	}
	public void setHp(String hp) {
		this.hp = hp;
	}
	
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	
	
}
public class Ex10_ClassMunje {

	public static void writeMember(Member m) {
		System.out.println("이름 : " + m.getName());
		System.out.println("번호 : " + m.getHp());
		System.out.println("지역 : " + m.getAddr());
		System.out.println("=".repeat(30));
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Member m1=new Member();
		Member m2=new Member("이강인");
		Member m3=new Member("손흥민","010-2222-3333");
		Member m4=new Member("Candy","010-444-5555","제주도");
		
		System.out.println("** 멤버 명단 출력 **");
		writeMember(m1);
		writeMember(m2);
		writeMember(m3);
		writeMember(m4);
		
		System.out.println("** m1 멤버의 값 변경하기 **");
		m1.setName("이영자");
		m1.setHp("011-2323-6767");
		m1.setAddr("부산");
		
		writeMember(m1);
	}
}