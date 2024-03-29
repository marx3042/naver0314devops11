package day0329;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;

public class Ex02_SwingDraw extends JFrame implements MouseMotionListener, MouseListener{
	Color color = Color.green;
	int x, y, prex, prey;	//곡선을 그릴 현재 좌표 xy, 와 직선 좌표 prex, prey
	
	@Override
	public void mouseClicked(MouseEvent e) {}
	@Override
	public void mousePressed(MouseEvent e) {
		x = e.getX();
		y = getY();
	}
	@Override
	public void mouseReleased(MouseEvent e) {}
	@Override
	public void mouseEntered(MouseEvent e) {}
	@Override
	public void mouseExited(MouseEvent e) {}

	//초기 선 색상
	
	
	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		//현재 좌표를 직선좌표로 저장
		prex = x;
		prey = y;
		
		//현재좌표ㅏ는 다시 마우스 위치로 저장
		x = e.getX();
		y = e.getY();
		
		//paint다시 호출
		repaint();
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public Ex02_SwingDraw(String title){
		super(title);
		this.setLocation(100, 100);	//시작위치
		this.setSize(500, 500); 	//창 크기
		// this.getContentPane().setBackground(new Color(90, 50, 30)); 	
		// this.getContentPane().setBackground(Color.blue); 	//배경색변경
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	//단순 프레임 종료
		//마우스 이벤트 추가
		this.addMouseMotionListener(this);
		this.addMouseListener(this);
		this.initDesign();	//각종 컴포넌트 생성
		this.setVisible(true);
	}
	
	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		// super.paint(g);

		//선색상
		g.setColor(color);
		//선굵기 지정
		Graphics2D g2 = (Graphics2D)g;
		g2.setStroke(new BasicStroke(3));
		//선그리기
		// g.drawLine(10,  100,  400,  100);
		
		//곣너은 마우스를 드래그시 직선좌표부터 현재좌표까지 선을그리면 곡선이 된다
		g.drawLine(prex,  prey,  x, y);
		
	}
	
	public void initDesign() {
		
	}
	
	public static void main(String[] args) {
		Ex02_SwingDraw a = new Ex02_SwingDraw("기본창");
	}
}
