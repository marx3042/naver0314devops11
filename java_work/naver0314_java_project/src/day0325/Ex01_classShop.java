package day0325;

public class Ex01_classShop {
	public static void showTitle() {
		System.out.println("** Start **");
		System.out.println("번호\t상품\t수량\t단가\t총금액");
	}
	
	public static void writeShop(Shop myshop[]) {
		for(int i = 0; i < myshop.length; i++) {
			System.out.print(i + "\t");
			System.out.print(myshop[i].getSang() + "\t");
			System.out.print(myshop[i].getSu() + "\t");
			System.out.print(myshop[i].getDan() + "\t");
			System.out.println(myshop[i].getSu() * myshop[i].getDan());
		}
	}
	
	public static void main(String[] args) {
		Shop myShop[] = new Shop[4];
		
		myShop[0] = new Shop();
		myShop[1] = new Shop("딸기");
		myShop[2] = new Shop(3, 2000);
		myShop[3] = new Shop("사과", 5, 3000);
		
		
		
		showTitle();	//제목을 출력하는 static method, 번호	상품 수량	단가	총금액
		writeShop(myShop);
		
		System.out.println();
		System.out.println("0번의 상품명, 수량, 단가 변경");
		myShop[0].setSang("포도");
		myShop[0].setSu(3);
		myShop[0].setDan(2000);
		
		System.out.println("1번의 상품명, 수량, 단가 변경");
		myShop[1].setSangpum("오렌지", 5, 1200);
		
		System.out.println("** 변경된 값으로 다시 출력 **");
		showTitle();
		writeShop(myShop);
		
	}
	
}
