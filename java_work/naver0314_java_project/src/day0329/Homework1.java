package day0329;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.FileDialog;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Area;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class Homework1 extends JFrame{
	static String photo = "D:/naver_0314/work_all/image/연예인사진/11.jpg";
//	File f1 = new File(folder);
//	List<String> files = new ArrayList<>();
	
//	for(File i : f1) {
//		files.add(i.getName());
//	}
	
	JButton btnImageOpen;
	MyPhoto myPhoto = new MyPhoto();
	
	public Homework1(String title){
		super(title);
		this.setLocation(100, 100);	//시작위치
		this.setSize(400, 500); 	//창 크기
		// this.getContentPane().setBackground(new Color(90, 50, 30)); 	
		this.getContentPane().setBackground(Color.blue); 	//배경색변경
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	//단순 프레임 종료
		this.initDesign();	//각종 컴포넌트 생성

		this.setVisible(true);
	}
	
	class MyPhoto extends Canvas {
		@Override
		public void paint(Graphics g) {
			// TODO Auto-generated method stub
			super.paint(g);
			Image image = new ImageIcon(photo).getImage();
			g.drawImage(image,  0, 0,  this.getWidth(),  this.getHeight(),  this);
			
		}
	}
	
	public void initDesign() {
		//패널에 버튼을 생성 후 North에 추가
		JPanel p = new JPanel();
		btnImageOpen = new JButton();
		p.add(btnImageOpen);
		this.add("North",p);
		
		//Canvas는 센터에 배치
		this.add("Center", myPhoto);
		
		//버튼 이벤트
		btnImageOpen.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				FileDialog dlg = new FileDialog(Homework1.this, "이미지 불러오기", FileDialog.LOAD);
				dlg.setVisible(true);
				if(dlg.getFile() ==null)	return;
				photo = dlg.getDirectory() + dlg.getFile();
				myPhoto.repaint();
			}
		});
	}
	
	public static void main(String[] args) {
		Homework1 a = new Homework1("기본창");
	}
}
