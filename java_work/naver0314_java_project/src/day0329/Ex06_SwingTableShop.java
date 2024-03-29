package day0329;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class Ex06_SwingTableShop extends JFrame{
	final static String FILENAME = "d:/naver0314/myshop.txt";

	JTable table;
	DefaultTableModel tableModel;
	JButton btnAdd, btnDelete;
	JTextField tfSang, tfSu, tfDan;
	
	public Ex06_SwingTableShop(String title) {
		// TODO Auto-generated constructor stub
		super(title);
		this.setLocation(100, 100);//시작위치
		this.setSize(400, 400);//창크기
		//this.getContentPane().setBackground(new Color(93, 199, 187));//배경색 변경
		//this.getContentPane().setBackground(Color.yellow);//배경색 변경
		//this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//프레임 종료
		//윈도우 종료시 테입르의 내용을 파일에 저장 후 종료하자
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent e) {
				// TODO Auto-generated method stub
				super.windowClosed(e);
				
				FileWriter fw = null;
				try {
					fw = new FileWriter(FILENAME);
					//테이블의 행갯수만큼 반복해서 데이터를 읽는다
					for(int i = 0; i < table.getRowCount(); i++) {
						String sang = table.getValueAt(i,  0).toString();
						String su = table.getValueAt(i,  1).toString();
						String dan = table.getValueAt(i,  2).toString();
						String tot = table.getValueAt(i,  3).toString();
						
						String s = sang+","+su+","+dan+","+tot+"\n";
						fw.write(s);
					}
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}finally {
					try {
						fw.close();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				
				System.exit(0);
			}
		});
		
		this.initDesign();//각종 컴포넌트 생성
		this.setVisible(true);
	}
	
	public void initDesign() {
		JPanel pTop = new JPanel();
		btnAdd = new JButton("상품정보추가");
		btnDelete = new JButton("상품정보삭제");
		pTop.add(btnAdd);
		pTop.add(btnDelete);
		
		this.add("North",pTop);
		
		//중간에는 테이블 추가
		String title[] = {"삼품명","수량","단가","총금액"};
		tableModel = new DefaultTableModel(title,0);
		table = new JTable(tableModel);
		this.add("Center", new JScrollPane(table));
		
		//하단에는 입력 컴포넌트들
		tfSang = new JTextField(7);
		tfSu = new JTextField(4);
		tfDan = new JTextField(7);
		
		JPanel pBottom = new JPanel();
		pBottom.add(new JLabel("상품명"));
		pBottom.add(tfSang);
		pBottom.add(new JLabel("수량"));
		pBottom.add(tfSu);
		pBottom.add(new JLabel("단가"));
		pBottom.add(tfDan);
		
		this.add("South", pBottom);
		
		//추가버튼 이벤트
		btnAdd.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//입력 안했을 경우 종료
				if(tfSang.getText().length() == 0) {
					JOptionPane.showMessageDialog(Ex06_SwingTableShop.this, e);
				}
				if(tfSu.getText().length() == 0) {
					JOptionPane.showMessageDialog(Ex06_SwingTableShop.this, e);
				}
				if(tfDan.getText().length() == 0) {
					JOptionPane.showMessageDialog(Ex06_SwingTableShop.this, e);
				}
				
				String sang = tfSang.getText();
				int su = 0, dan = 0;
				try {
					su = Integer.parseInt(tfSu.getText().toString());
					dan = Integer.parseInt(tfDan.getText().toString());
				} catch (NumberFormatException e1) {
					// TODO Auto-gen)erated catch block
					System.out.println("수량, 단가 문자입력오류");
					JOptionPane.showMessageDialog(Ex06_SwingTableShop.this, "수량, 단가는 수로만 입력");
					return;
				}
				int total = su * dan;
				
				//Vector로 데이터를 담는다(data)
				Vector<String> data = new Vector<>();
				data.add(sang);
				data.add(String.valueOf(su));
				data.add(String.valueOf(dan));
				data.add(String.valueOf(total));
				
				//tableModel로 추가한다(addRow)
				tableModel.addRow(data);
				//입력박스 데이터는 지운다(setText)
				tfSang.setText("");
				tfSu.setText("");
				tfDan.setText("");
			}
		});
		
		//삭제 이벤트는 행을 선택시 행의 데이터 삭제
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ex06_SwingTableShop a=new Ex06_SwingTableShop("기본창");
	}

}