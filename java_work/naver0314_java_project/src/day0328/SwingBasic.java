package day0328;

import java.awt.Color;

import javax.swing.JFrame;

public class SwingBasic extends JFrame{
	public SwingBasic(String title){
		super(title);
		this.setLocation(100, 100);	//시작위치
		this.setSize(400, 500); 	//창 크기
		// this.getContentPane().setBackground(new Color(90, 50, 30)); 	
		this.getContentPane().setBackground(Color.blue); 	//배경색변경
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	//단순 프레임 종료
		this.initDesign();	//각종 컴포넌트 생성

		this.setVisible(true);
	}
	
	public void initDesign() {
		this.add("Center", null);
	}
	
	public static void main(String[] args) {
		SwingBasic a = new SwingBasic("기본창");
	}
}
