package data.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor	//디폴트 생성자
@AllArgsConstructor	//모든 맴버변수를 인자로 받는 생성자
//@Setter
//@Getter
//@ToString
@Data				//Setter + Getter + ToString 합친것

public class ShopDto {
	private String sang;
	private String photo;
	private int price;
	private int su;
	
	
}
