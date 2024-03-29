package day0328;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class Ex06_SwingCanvasRadio extends JFrame{
	final static String PHOTO1 = "D:/naver_0314/work_all/image/연예인사진/soojee.jpg";
	final static String PHOTO2 = "D:/naver_0314/work_all/image/연예인사진/shinsekyeong.jpg";
	final static String PHOTO3 = "D:/naver_0314/work_all/image/연예인사진/seolhyeon.jpg";
	final static String PHOTO4 = "D:/naver_0314/work_all/image/연예인사진/18.jpg";
	
	Color boxColor = new Color(67, 196, 207);	//초기 박스 색상
	JRadioButton rbBox1,rbBox2,rbBox3,rbBox4;
	JRadioButton rbPhoto1,rbPhoto2,rbPhoto3,rbPhoto4;
	JRadioButton rbPhoto[] = new JRadioButton[4];
	
	int photoIndex = 1; 	//처음에 수지 사진
	MyDraw draw = new MyDraw();
	
	public Ex06_SwingCanvasRadio(String title){
		super(title);
		this.setLocation(100, 100);	//시작위치
		this.setSize(400, 600); 	//창 크기
		// this.getContentPane().setBackground(new Color(90, 50, 30)); 	
		this.getContentPane().setBackground(Color.gray); 	//배경색변경
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	//단순 프레임 종료
		this.initDesign();	//각종 컴포넌트 생성

		this.setVisible(true);
	}
	
	class MyDraw extends Canvas{
		@Override
		public void paint(Graphics g) {
			// TODO Auto-generated method stub
			super.paint(g);
			
			//채워진 박스 그리기
			g.setColor(boxColor);
			g.fillRect(30,  70,  300,  320);
			
			Image image = null;
			switch (photoIndex) {
			case 1: 
				image = new ImageIcon(PHOTO1).getImage();
				break;
			case 2: 
				image = new ImageIcon(PHOTO2).getImage();
				break;
			case 3: 
				image = new ImageIcon(PHOTO3).getImage();
				break;
			case 4: 
				image = new ImageIcon(PHOTO4).getImage();
				break;
			}
			g.drawImage(image, 80, 80, 220, 260, this);
			
		}
	}
	
	//new Color(67, 196, 207)
	public void initDesign() {
		this.add("Center", draw);
		JPanel pTop = new JPanel();
		ButtonGroup bg1 = new ButtonGroup();
		rbBox1 = new JRadioButton("초록색", true);
		bg1.add(rbBox1);
		pTop.add(rbBox1);
		
		rbBox2 = new JRadioButton("하늘색", true);
		bg1.add(rbBox2);
		pTop.add(rbBox2);

		rbBox3 = new JRadioButton("분홍색", true);
		bg1.add(rbBox3);
		pTop.add(rbBox3);
		
		rbBox4 = new JRadioButton("오렌지색", true);
		bg1.add(rbBox4);
		pTop.add(rbBox4);
		
		//rbBox1에 대한 이벤트
		rbBox1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				boxColor = Color.green;
				//캔버스의 paint 메소드 강제호출
				draw.repaint();
			}
		});
		rbBox2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				boxColor = Color.cyan;
				//캔버스의 paint 메소드 강제호출
				draw.repaint();
			}
		});
		rbBox3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				boxColor = Color.pink;
				//캔버스의 paint 메소드 강제호출
				draw.repaint();
			}
		});
		rbBox4.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				boxColor = Color.orange;
				//캔버스의 paint 메소드 강제호출
				draw.repaint();
			}
		});
		
		//프레임 상단에 Panel 추가
		this.add("North", pTop);
		
		JPanel pBottom = new JPanel();
		ButtonGroup bg2 = new ButtonGroup();
		String s[] = {"수지", "신세경", "설현", "김우빈"};
		
		for(int i = 0; i < rbPhoto.length;i++) {
			final int n = i + 1;
			
			rbPhoto[i] = new JRadioButton(s[i], i == (photoIndex -1) ? true : false);
			//그룹변수엥 추가
			bg2.add(rbPhoto[i]);
			//패널에도 추가
			pBottom.add(rbPhoto[i]);
			//이벤트
			rbPhoto[i].addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					// photoIndex = i + 1;
					photoIndex = n;
					draw.repaint();
				}
			});
		}
		this.add("South", pBottom);
	}
	
	public static void main(String[] args) {
		Ex06_SwingCanvasRadio a = new Ex06_SwingCanvasRadio("기본창");
	}
}
