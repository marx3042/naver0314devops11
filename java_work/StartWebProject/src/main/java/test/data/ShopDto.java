package test.data;

public class ShopDto {
	private String sangpum;
	private String photo;
	private int price;
	private int cnt;
	private String color;
	
	public ShopDto(){
		super();
	}
	

	public ShopDto(String sangpum, String photo,  int price, int cnt, String color) {
		super();
		this.sangpum = sangpum;
		this.photo = photo;
		this.price = price;
		this.cnt = cnt;
		this.color = color;
	}


	public String getSangpum() {
		return sangpum;
	}

	public void setSangpum(String sangpum) {
		this.sangpum = sangpum;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getCnt() {
		return cnt;
	}

	public void setCnt(int cnt) {
		this.cnt = cnt;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
	
	
}
