package anno.study.ex04;

import org.springframework.stereotype.Component;

@Component  //xml ¿¡ canadaTire ·Î µî·Ï
public class CanadaTire implements Tire{
	@Override
	public String getTireName() {
		// TODO Auto-generated method stub
		return "Ä³³ª´ÙÅ¸ÀÌ¾î";
	}
}	