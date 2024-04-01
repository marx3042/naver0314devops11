package day0329;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
		this.getContentPane().setBackground(new Color(93, 199, 187));//배경색 변경
		//this.getContentPane().setBackground(Color.yellow);//배경색 변경
		//this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//프레임 종료
		
		//종료시 발생하는 이벤트
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				super.windowClosing(e);
				//자동 저장해준느 메소드 호출
				sawonDataWrite();
				//시스템종료
				System.exit(0);
			}
		});
		this.initDesign();//각종 컴포넌트 생성
		this.setVisible(true);
	}
	
	//처음 생성시 파일 불러오기
	public void sawonDateRead() {
		FileReader fr = null;
		BufferedReader br = null;
		
		try {
			fr = new FileReader(FILENAME);
			br = new BufferedReader(fr);
			while(true) {
				String s = br.readLine();
				if(s == null) {
					break;
				}
				//한줄 읽어온 자료는 배열로 변환
				String data[] = s.split(",");
				//테이블에 추가
				tableModel.addRow(data);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				br.close();
				fr.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void sawonDataWrite() {
		FileWriter fw = null;
		try {
			fw = new FileWriter(FILENAME);
			//행 개수 만큼 반속해서 데이터를 일겅 파일에 저장(콤마로 연결)
			for(int i = 0; i < table.getRowCount(); i++) {
				String s = table.getValueAt(i,  0) + "," + table.getValueAt(i,  1) + "," +
						table.getValueAt(i,  2) + "," + table.getValueAt(i,  3) + "\n";
				fw.write(s);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
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
		
		//사원삭제이벤트
		 btnDelete.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//선택한 행번호 얻기
				int row = table.getSelectedRow();
				if(row == -1) {
					JOptionPane.showMessageDialog(Sawon.this, "삭제할 행 선택");
					return;
				}
				
				//선택한 행 삭제
				tableModel.removeRow(row);
			}
		});
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Sawon a=new Sawon("사원");
	}

}