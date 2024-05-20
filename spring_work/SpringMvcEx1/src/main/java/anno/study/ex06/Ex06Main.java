package anno.study.ex06;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Ex06Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ApplicationContext context=new ClassPathXmlApplicationContext("appex6.xml");
		ShopController shopCont=(ShopController)context.getBean("shopcont");
		shopCont.insert("안녕", 2, 25000);
		System.out.println("-".repeat(30));
		shopCont.delete("하세요");
		System.out.println("-".repeat(30));
		shopCont.update("반가",1 ,120000);
	}

}