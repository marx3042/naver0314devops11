package anno.study.ex05;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.Getter;

@Component
@Getter
public class Sawon {
	@Value("��â��")
	private String name;
	@Value("��⵵ ����� ���ൿ")
	private String addr;
	@Value("50")
	private int age;

}