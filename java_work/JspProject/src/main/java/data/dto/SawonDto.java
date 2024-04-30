package data.dto;

public class SawonDto {
	private int num;
	private int age;
	private String name;
	private String buseo;
	private String addr;
	private String photo;
	private String gender;
	private String birthday;
	
	public SawonDto() {
		super();
	}

	public SawonDto(int age, String name, String buseo, String addr, String photo,
			String gender, String birthday) {
		super();
		this.age = age;
		this.name = name;
		this.buseo = buseo;
		this.addr = addr;
		this.photo = photo;
		this.gender = gender;
		this.birthday = birthday;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBuseo() {
		return buseo;
	}

	public void setBuseo(String buseo) {
		this.buseo = buseo;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	
}