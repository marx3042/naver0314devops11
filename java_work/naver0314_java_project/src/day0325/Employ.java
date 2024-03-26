package day0325;

public class Employ {
	private String name, position;
	private int age, basePay, benefit, netPay;
	
	public Employ() {
		this("없음", 0);
	}
	public Employ(String name, String position, int age) {
		this.name = name;
		this.position = position;
		this.age = age;
	}
	public Employ(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getBasePay() {
		return basePay;
	}
	public void setBasePay(int basePay) {
		this.basePay = basePay;
	}
	public int getBenefit() {
		return benefit;
	}
	public void setBenefit(int benefit) {
		this.benefit = benefit;
	}
	public int getNetPay() {
		this.netPay = this.basePay + this.benefit;
		return netPay;
	}

	public void setPay(int basePay, int benefit) {
		this.basePay = basePay;
		this.benefit = benefit;
	}
	public void setWorker(String name, String position, int age) {
		this.name = name;
		this.position = position;
		this.age = age;
	}
	
	
}
