package anno.study.ex04;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Ex04Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext context=new ClassPathXmlApplicationContext("appex4.xml");
		
		//Hello h=(Hello)context.getBean("hello");
		Hello h=(Hello)context.getBean("h");
		h.showMessage();
	}

}