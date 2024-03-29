package day0329;

import java.awt.Color; 
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Ex04_SwingTable extends JFrame{
	JTable table;
	JLabel lblMessage;
	
	
	public Ex04_SwingTable(String title) {
		// TODO Auto-generated constructor stub
		super(title);
		this.setLocation(100, 100);//시작위치
		this.setSize(300, 300);//창크기
		this.getContentPane().setBackground(new Color(93, 199, 187));//배경색 변경
		//this.getContentPane().setBackground(Color.yellow);//배경색 변경
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//프레임 종료
		this.initDesign();//각종 컴포넌트 생성
		this.setVisible(true);
	}
	
	public void initDesign(){
		String title[] = {"이름","나이","혈액형","핸드폰","주소"};
		String data[][] = {{"이영자", "32세", "B", "010-1234-1234", "서울"},
				{"강호동", "45세", "O", "010-8989-9999", "부산"},
				{"유재석","29세","AB","010-2222-3333","제주도"},
				{"제니","23세","A","010-6767-7878","뉴욕"}
				};
		table = new JTable(data, title);
		//상단에 제목 추가
		this.add("North", new JLabel("701 member 현황", JLabel.CENTER));
		//프레임의 센터에 추가
		this.add("Center", new JScrollPane(table));	//태이블도 스크롤바가 생겨야한다(제목포함)
		//메세지 라벨ㅇ르 south에 추가
		lblMessage = new JLabel("result", JLabel.CENTER);
		this.add("South", lblMessage);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ex04_SwingTable a=new Ex04_SwingTable("테이블");
	}
	int a;
	
}