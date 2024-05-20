package day0520.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class FoodDto {
	//formtag의 변수명과 같아야 자동으로 읽음
	private String foodname;	//formtag 변수명과 같아야함
	private String foodphoto;
	private int price;
	private int count;
}
