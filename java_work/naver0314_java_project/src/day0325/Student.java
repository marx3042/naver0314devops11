package day0325;

public class Student {
	private String name;
	private int java, spring, total;
	private double avg;
	private char grade;

	public Student() {
		this("없음", 0, 0);
	}
	public Student(String name) {
		this.name = name;
	}
	public Student(int java, int spring) {
		super();
		this.java = java;
		this.spring = spring;
		this.total = this.java + this.spring;
		this.avg = this.total / 2;
		if(this.avg >= 90) {
			this.grade = 'A';
		}
		else if(this.avg >= 80) {
			this.grade = 'B';
		}
		else if(this.avg >= 70) {
			this.grade = 'C';
		}
		else {
			this.grade = 'F';
		}
	}
	
	public Student(String name, int java, int spring) {
		super();
		this.name = name;
		this.java = java;
		this.spring = spring;
		this.total = this.java + this.spring;
		this.avg = this.total / 2;	
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getJava() {
		return java;
	}
	public void setJava(int java) {
		this.java = java;
	}
	public int getSpring() {
		return spring;
	}
	public void setSpring(int spring) {
		this.spring = spring;
	}
	public int getTotal() {
		this.total = this.java + this.spring;
		return this.total;
	}
	
	public double getAvg() {
		this.avg = this.total / 2;
		return this.avg;
	}
	public char getGrade() {
		if(this.avg >= 90) {
			this.grade ='A';
		}
		else if(this.avg >= 80) {
			this.grade = 'B';
		}
		else if(this.avg >= 70) {
			this.grade = 'C';
		}
		else {
			this.grade = 'F';
		}
		
		return this.grade;
	}
	
	public void setScore(int java, int spring) {
		this.java = java;
		this.spring = spring;
	}
	
	
	
}
