package day0322;

class Myshop{
	private String sangpum;
	private int su, dan;
	private static String message;
	
	public static final String SHOP = "24시간 이마트";
	
	public void setSangpum(String sangpum) {
		this.sangpum = sangpum;
	}
	public void setSu(int su) {
		this.su = su;
	}
	public void setDan(int dan) {
		this.dan = dan;
	}
	static public void setMessage(String message) {
		// static 맴버변수는 같은 구역에 같은 이름의 변수가 있을 경우 앞에 클래스명을 생략하지 말고 써준다
		Myshop.message = message;
	}
	
	public String getSangpum() {
		return sangpum;
	}
	public int getSu() {
		return su;
	}
	public int getDan() {
		return dan;
	}
	public static String getMessage() {
		return message;
	}
	public static String getShop() {
		return SHOP;
	}
	
	public void setData(String sangpum, int su, int dan) {
		//메서드를 this로 호출 가능
		this.setSangpum(sangpum);
		this.setSu(su);
		this.setDan(dan);
	}
	//overloading method
	public void setData(String sangpum,int su, int dan, String message) {
		//메서드를 this로 호출 가능
		this.setSangpum(sangpum);
		this.setSu(su);
		this.setDan(dan);
		//인스턴스메서드에서 static메서드 호출이 가능한가 : y
		//반대로 static 메서드에서 인스턴스 맴버 메서드를 호출할 수 있는가? : n
		//static 메서드에서 같은 static 메서드는 호ㅊㄹ이 가능한가? y
		setMessage(message);	//앞에 클래스명은 같은 클래스라 생략함
	}
	
	public void writeData() {
		System.out.println("상품명 : {}\n갯수 : {}\n단가 : {}".format(sangpum, su, dan));
	}
	
}

public class Ex03_staticMethod {
	
	public static void main(String[] args) {
		Myshop sang1 = new Myshop();
		Myshop sang2 = new Myshop();
		Myshop sang3 = new Myshop();		
		
		System.out.println("** 상품 1 **");
		sang1.setSangpum("딸기");
		sang1.setSu(3);{
		sang1.setDan(2300);
		Myshop.setMessage("오늘 각종 과일 셍리합니다!!");	//static 메서드는 클래스명으로 호출
		
		sang1.writeData();
		}
			
		
	}
		
	
	
}
