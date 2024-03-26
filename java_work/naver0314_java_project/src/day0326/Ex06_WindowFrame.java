package day0326;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;

class Myframe extends JFrame{
	public Myframe() {
		// TODO Auto-generated constructor stub
		super("701화이팅");
		this.setLocation(300, 100);	//프레임 시작위치
		this.setSize(300, 300);	//프레임의 너비, 높이
		this.setVisible(true);	//프레임이 보이도록
		
		//프레임에 이벤트 추가
		this.addWindowListener(new WindowExit());
	}
	
	//내부 클래스
	class WindowExit implements WindowListener{

		@Override
		public void windowOpened(WindowEvent e) {
			// TODO Auto-generated method stub
			System.out.println("윈도우 열었을때");
		}
		
		@Override
		public void windowClosing(WindowEvent e) {
			// TODO Auto-generated method stub
			System.out.println("윈도우를 종료합니다");
			System.exit(0);
		}

		@Override
		public void windowClosed(WindowEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void windowIconified(WindowEvent e) {
			// TODO Auto-generated method stub
			System.out.println("윈도우 아이콘");
		}

		@Override
		public void windowDeiconified(WindowEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void windowActivated(WindowEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void windowDeactivated(WindowEvent e) {
			// TODO Auto-generated method stub
			
		}

		
		
	}
		
	
}

public class Ex06_WindowFrame {
	public static void main(String[] args) {
		Myframe my = new Myframe();
		
	}

}
