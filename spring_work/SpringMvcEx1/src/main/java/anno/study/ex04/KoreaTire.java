package anno.study.ex04;

import org.springframework.stereotype.Component;

@Component   //koreaTire 가 아이디가 된다
public class KoreaTire implements Tire{
	@Override
	public String getTireName() {
		// TODO Auto-generated method stub
		return "한국타이어";
	}

}