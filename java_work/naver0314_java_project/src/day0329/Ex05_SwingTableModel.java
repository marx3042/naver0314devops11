package day0329;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.NumberFormat;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Ex05_SwingTableModel extends JFrame{
	JLabel lblTitle;
	DefaultTableModel tableModel;
	JTable table;
	JButton btnDelete;
	
	public Ex05_SwingTableModel(String title) {
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
	
	public void initDesign() {
		lblTitle = new JLabel("강남고 학생 정보", JLabel.CENTER);
		lblTitle.setFont(new Font("", Font.BOLD, 30));
		
		this.add("North", lblTitle);
		
		String title[] = {"이름", "나이","Java","Spring", "HTML", "총점", "평균"};
		tableModel = new DefaultTableModel(title, 0);
		table = new JTable(tableModel);
		this.add("Center", new JScrollPane(table));
		this.addStudentFile();
		this.process();
		
		//삭제버튼 생성 및 이벤트
		btnDelete = new JButton("학생 정보 삭제하기");
		this.add("South", btnDelete);
		
		btnDelete.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int row = table.getSelectedRow();
				System.out.println(row);
				
				if(row == -1)
					JOptionPane.showMessageDialog(Ex05_SwingTableModel.this, "먼저 삭제할");
				else
					tableModel.removeRow(row);
			}
		});
		
		
	}
	//총점평균 계산해주는 메소드
	public void process() {
		for(int i = 0; i < tableModel.getRowCount();i++) {
			int java = Integer.parseInt(table.getValueAt(i, 2).toString());
			int spring = Integer.parseInt(table.getValueAt(i, 3).toString());
			int html = Integer.parseInt(table.getValueAt(i, 4).toString());
			
			//총점구하기
			int tot = java+spring+html;
			//5번열에 출력(무조건 string 변환 후 출력)
			table.setValueAt(tot, i, 5);
			//평균 구하기
			double avg = tot/3.0;
			NumberFormat nf = NumberFormat.getInstance();
			nf.setMaximumFractionDigits(2);
			table.setValueAt(nf.format(avg), 1, 6);
		}
	}
	public void addStudentFile() {
		FileReader fr = null;
		BufferedReader br = null;
		try {
			fr = new FileReader("d:/naver_0314/work_all/java_work/naver0314_java_project/study.txt");
			br = new BufferedReader(fr);
			while(true) {
				String s = br.readLine();
				if(s == null) {
					break;
				}
				String data[] = s.split(",");
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
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ex05_SwingTableModel a=new Ex05_SwingTableModel("기본창");
	}

}