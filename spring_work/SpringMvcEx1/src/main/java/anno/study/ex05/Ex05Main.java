package anno.study.ex05;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Ex05Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext context=new ClassPathXmlApplicationContext("appex5.xml");
		
		Emp emp=(Emp)context.getBean("emp");
		emp.sawonInfo();
	}

}