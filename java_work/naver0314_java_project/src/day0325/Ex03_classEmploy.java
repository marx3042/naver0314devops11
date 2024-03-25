package day0325;

public class Ex03_classEmploy {
	public static void showTitle() {
		System.out.println("** 우리 회사 **");
		System.out.println("번호\t이름\t직급\t나이\t기본급\t수당\t합산");
		System.out.println("=".repeat(60));
	}
	
	public static void main(String[] args) {
		Employ em[] = {new Employ(),
				new Employ("강호동", "사원", 30),
				new Employ("유재석", "과장", 42),
				new Employ("이영자", "차장", 45),
				new Employ("손미나", 45),
		};
		
		//0번 데이터 수정
		em[0].setName("이광수");
		em[0].setPosition("사원");
		em[0].setAge(29);
		em[0].setBasePay(340);
		em[0].setBenefit(23);
		
		//1번 데이터 수정
		em[1].setPay(450, 100);	//기본급과 수당을 같이 수정
		//2번 데이터 수정
		em[2].setWorker("유재남", "계장", 41);
		em[2].setPay(410, 80);
		//3번 데이터 수정
		em[3].setPay(560, 120);
		//4번 데이터 수정
		em[4].setPosition("사원");
		em[4].setPay(289, 67);
		
		//출력
		showTitle();	//static method title print
		for(int i = 0; i < em.length; i++) {
			System.out.println(i + 1 + "\t" + em[i].getName() + "\t" + em[i].getPosition() + "\t" + 
					em[i].getAge() + "\t" + em[i].getBasePay() + "\t" + em[i].getBenefit() + "\t" + em[i].getNetPay());
		}
		
	}
}
