package day0328;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Ex04_SwingButton extends JFrame{
	JButton btn1, btn2;
	JButton btnArray[] = new JButton[6];
	String btnLabel[] = {"초록색", "빨강색", "분홍색", "오렌지색", "노랑색", "랜덤색"};
	
	
	public Ex04_SwingButton(String title){
		super(title);
		this.setLocation(100, 100);	//시작위치
		this.setSize(300, 300); 	//창 크기
		// this.getContentPane().setBackground(new Color(90, 50, 30)); 	
		this.getContentPane().setBackground(Color.yellow); 	//배경색변경
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	//단순 프레임 종료
		this.initDesign();	//각종 컴포넌트 생성

		this.setVisible(true);
	}

	public void initDesign() {
		this.setLayout(null);	//기본 레이아웃 없애기
		//버튼 1 생성
		btn1 = new JButton("HEllO");
		//프레임에 추가
		btn1.setBounds(10, 10, 100, 30);	//x, y, w, h
		this.add(btn1);
		//btn1이벤트 추가- 익명 내부 클래스 형태로 이벤트 구현
		btn1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JOptionPane.showMessageDialog(Ex04_SwingButton.this, "버튼 1을 눌렀어요");
			}
		});
		
		// 버튼2 생성후 프레임에 추가해보세요
		btn2 = new JButton("button2");
		btn2.setBounds(110, 10, 100, 30);
		this.add(btn2);
		btn2.addActionListener(new Button2Event());
		
		//btnArray 배열 변수를 새성 후 프레임에 추가
		int yPos = 40;
		for(int i = 0; i < btnArray.length; i++) {
			btnArray[i] = new JButton(btnLabel[i]);
			btnArray[i].setBounds(10, yPos, 100, 30);
			this.add(btnArray[i]);
			yPos+=35;
			
			//익명 내부 클래스 형태로 이벤트 구현
			btnArray[i].addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					// Object ob = e.getSource();	//이벤트가 발생한 오브젝트
					JButton ob = (JButton)e.getSource();
					System.out.println(ob.getText());
					// System.out.println(ob.getLabel());	//예전 버전
					
					switch (ob.getText()) {
					case "빨강색":
						//부모 컴포넌트의 인스턴스 변수인 this를 통해서 배경색 변경	
						Ex04_SwingButton.this.getContentPane().setBackground(Color.red);
						break;
					case "초록색":
						//부모 컴포넌트의 인스턴스 변수인 this를 통해서 배경색 변경	
						Ex04_SwingButton.this.getContentPane().setBackground(Color.green);
						break;
					case "분홍색":
						//부모 컴포넌트의 인스턴스 변수인 this를 통해서 배경색 변경	
						Ex04_SwingButton.this.getContentPane().setBackground(Color.pink);
						break;
					case "오렌지색":
						//부모 컴포넌트의 인스턴스 변수인 this를 통해서 배경색 변경	
						Ex04_SwingButton.this.getContentPane().setBackground(Color.orange);
						break;
					case "노랑색":
						//부모 컴포넌트의 인스턴스 변수인 this를 통해서 배경색 변경	
						Ex04_SwingButton.this.getContentPane().setBackground(Color.yellow);
						break;
					case "랜덤색":
						//부모 컴포넌트의 인스턴스 변수인 this를 통해서 배경색 변경
						Random r = new Random();
						Ex04_SwingButton.this.getContentPane().setBackground(new Color(r.nextInt(256), r.nextInt(256), r.nextInt(256)));
						break;
					default:
						throw new IllegalArgumentException("Unexpected value: " + ob.getText());
					}
				}
			});
		}
		
	}
	
	class Button2Event implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			JOptionPane.showMessageDialog(Ex04_SwingButton.this, "버튼2 추가");
		}
	}

	public static void main(String[] args) {
		Ex04_SwingButton a = new Ex04_SwingButton("스윙버튼");
	}
}
