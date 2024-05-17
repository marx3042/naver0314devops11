package anno.study.ex05;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.Getter;

@Component
@Getter
public class Sawon {
	@Value("김창인")
	private String name;
	@Value("경기도 시흥시 은행동")
	private String addr;
	@Value("50")
	private int age;

}