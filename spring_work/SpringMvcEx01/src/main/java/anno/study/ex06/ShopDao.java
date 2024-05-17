package anno.study.ex06;

import org.springframework.stereotype.Component;

@Component
public class ShopDao {
	public void insert(ShopDto dto) {
		System.out.println("데이타 추가");
		System.out.println(dto.toString());
	}
	
	public void delete(String sang) {
		System.out.println(sang+"상품을 삭제하였습니다");
	}
	public void update(ShopDto dto)
	{
		System.out.println("데이타 수정");
		System.out.println(dto);
	}
	public void selectAll()
	{
		System.out.println("전체 상품을 출력합니다");
	}
}