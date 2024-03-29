package day0329;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class Sawon extends JFrame{
	final static String FILENAME = "d:/naver0314/test.txt";
	
	JTable table;
	DefaultTableModel tableModel;
	JButton btnAdd, btnDelete;
	JTextField tfName;
	JComboBox<String> cBlood, cAddr, cClass;
	String blood_label[] = {"A", "B", "O", "AB"};
	String addr_label[] = {"서울", "인천", "대구", "부산"};
	String class_label[] = {"사장", "부장", "대리", "사원"};
	
	
	public Sawon(String title) {
		// TODO Auto-generated constructor stub
		super(title);
		this.setLocation(100, 100);//시작위치
		this.setSize(600, 600);//창크기
		//this.getContentPane().setBackground(new Color(93, 199, 187));//배경색 변경
		//this.getContentPane().setBackground(Color.yellow);//배경색 변경
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//프레임 종료
		this.initDesign();//각종 컴포넌트 생성
		this.setVisible(true);
	}
	
	public void initDesign() {
		//상단
		JPanel pTop = new JPanel();
		btnAdd = new JButton("사원정보추가");
		btnDelete = new JButton("사원정보삭제");
		pTop.add(btnAdd);
		pTop.add(btnDelete);
		this.add("North", pTop);
		
		//테이블
		String title[] = {"이름","혈액형","지역","직급"};
		tableModel = new DefaultTableModel(title,0);
		table = new JTable(tableModel);
		this.add("Center", new JScrollPane(table));
		
		//하단
		tfName = new JTextField(5);
		cBlood = new JComboBox<String>(blood_label);
		cAddr = new JComboBox<String>(addr_label);
		cClass = new JComboBox<String>(class_label);
		
		JPanel pBottom = new JPanel();
		pBottom.add(new JLabel("이름"));
		pBottom.add(tfName);
		pBottom.add(new JLabel("혈액형"));
		pBottom.add(cBlood);
		pBottom.add(new JLabel("지역"));
		pBottom.add(cAddr);
		pBottom.add(new JLabel("직급"));
		pBottom.add(cClass);
		this.add("South", pBottom);
		
		btnAdd.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String name = tfName.getText();
				String blood = cBlood.getSelectedItem().toString();
				String addr = cAddr.getSelectedItem().toString();
				String c_lass = cClass.getSelectedItem().toString();
				
				Vector<String> data = new Vector<>();
				data.add(name);
				data.add(blood);
				data.add(addr);
				data.add(c_lass);
				tableModel.addRow(data);
				
			}
		});
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Sawon a=new Sawon("사원");
	}

}