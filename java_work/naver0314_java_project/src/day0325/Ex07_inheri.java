package day0325;

class Member {
	private String memberName;
	private int memberCount;
	
	public Member() {
		
	}
	
	Member(String memberName,int memberCount){
		this.memberName = memberName;
		this.memberCount = memberCount;
	}
	
	public void writeMember() {
		System.out.println("모임 이름 : " + memberName);
		System.out.println("모임 정원 : " + memberCount);
	}
		
}

class SubMember extends Member{
	private String myName;
	private int myAge;
	
	public SubMember() {
		myName = "이름없음";
		myAge = 20;
	}
	
	SubMember(String memberName, int memberCount, String myName, int myAge){
		super(memberName, memberCount);
		this.myName = myName;
		this.myAge = myAge;
	}
	
	@Override
	public void writeMember() {
		super.writeMember();
		System.out.println("내 이름 : " + myName);
		System.out.println("내 나이 : " + myAge);
		System.out.println("=".repeat(20));
	}
}

public class Ex07_inheri {
	public static void main(String[] args) {
		SubMember sub1 = new SubMember();
		sub1.writeMember();
		
		SubMember sub2 = new SubMember("701모임", 30, "이영자", 35);
		sub2.writeMember();
	}
}
