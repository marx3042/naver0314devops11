package day0328;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.Scanner;

import javax.imageio.plugins.tiff.BaselineTIFFTagSet;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class Ex05_SwingCanvas extends JFrame{
	//캔버스 변수 선언
	MyDraw draw = new MyDraw();
	//음식사진 경로
	String foodImage = "D:\\naver_0314\\work_all\\image\\음식사진\\11.jpg";
	String foodImage2 = "D:/naver_0314/work_all/image/음식사진/1.jpg";
	
	public Ex05_SwingCanvas(String title){
		super(title);
		this.setLocation(100, 100);	//시작위치
		this.setSize(500, 500); 	//창 크기
		// this.getContentPane().setBackground(new Color(90, 50, 30)); 	
		// this.getContentPane().setBackground(Color.LIGHT_GRAY); 	//배경색변경
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE );	//단순 프레임 종료
		this.initDesign();	//각종 컴포넌트 생성
		this.setVisible(true);
	}
	
	class MyDraw extends Canvas{
		//처음 시작시, 그리고 프레임 크기 변경시에는 자동 호출
		//그 이외에는 강제호출(repaint)
		@Override
		public void paint(Graphics g) {
			// TODO Auto-generated method stub
			super.paint(g);
			
			//색상 변경
			g.setColor(Color.magenta);
			//테두리만 있는 타원 그리기
			g.drawOval(30, 30, 100, 100);
			//채워진 타원
			g.setColor(Color.orange);
			g.fillOval(150, 30, 100, 100);
			
			//테두리만 있는 사각형
			g.setColor(new Color(8, 207, 7));
			g.drawRect(30,  150,  100,  100);
			
			//채워진 사각형
			g.setColor(new Color(239, 136, 190));
			g.fillRect(150,  150,  100,  100);
			
			//글꼴 출력
			g.setFont(new Font("Comic Sans MS", Font.BOLD, 30));
			g.drawString("good day", 50,  350);

			//글꼴 출력
			g.setFont(new Font("궁서체", Font.BOLD, 30));
			g.drawString("안녕하세요", 250,  350);
			
			//음식 이미지 그리기
			Image image1 = new ImageIcon(foodImage).getImage();
			g.drawImage(image1, 300, 10, 130, 130,  this);
			
			//음식 이미지 그리기2
			Image image2 = Toolkit.getDefaultToolkit().getImage(foodImage2);
			g.drawImage(image2, 300,  150,  130,  130,  this);
			
			
		}
	}
	
	public void initDesign() {
		this.add("Center", draw);
	}
	
	public static void main(String[] args) {
		Ex05_SwingCanvas a = new Ex05_SwingCanvas(null);
	}
}
