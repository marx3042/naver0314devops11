package day0520.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class FoodDto {
	//formtag�� ������� ���ƾ� �ڵ����� ����
	private String foodname;	//formtag ������� ���ƾ���
	private String foodphoto;
	private int price;
	private int count;
}
