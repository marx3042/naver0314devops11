package day0408;

import java.awt.Button;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import db.common.DbConnect;
import oracle.jdbc.proxy.annotation.Pre;

public class Ex02_DBSawon extends JFrame{
	DbConnect db =  new DbConnect();
	JTable table;
	DefaultTableModel tableModel;
	JTextField tfNum, tfName,tfScore,tfGender,tfBuseo;
	JButton btnAdd,btnDel;
	JComboBox<String> cbResult;
	JRadioButton rbAll, rbMan, rbGirl;
	int order = 1;
	
	public Ex02_DBSawon(String title) {
		// TODO Auto-generated constructor stub
		super(title);
		this.setLocation(100, 100);//시작위치
		this.setSize(500, 500);//창크기
		//this.getContentPane().setBackground(new Color(93, 199, 187));//배경색 변경
		//this.getContentPane().setBackground(Color.yellow);//배경색 변경
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//프레임 종료
		this.initDesign();//각종 컴포넌트 생성
		this.writeDB();
		this.setVisible(true);
	}
	
	public void initDesign() {
		JPanel p1 = new JPanel();
		p1.add(new JLabel("시퀸스"));
		tfNum = new JTextField(5);
		p1.add(tfNum);
		
		p1.add(new JLabel("이름"));
		tfName = new JTextField(5);
		p1.add(tfName);

		p1.add(new JLabel("점수"));
		tfScore = new JTextField(5);
		p1.add(tfScore);
		
		p1.add(new JLabel("성별"));
		tfGender = new JTextField(5);
		p1.add(tfGender);
		
		p1.add(new JLabel("부서"));
		tfBuseo= new JTextField(5);
		p1.add(tfBuseo);
		
		this.add("North", p1);
		//
		String title[] = {"시퀸스", "이름", "점수", "성별", "부서"};
		tableModel = new DefaultTableModel(title, 0);
		table = new JTable(tableModel);
		this.add("Center", new JScrollPane(table));
		//
		
		JPanel p2 = new JPanel();
		btnAdd = new JButton("추가");
		btnDel = new JButton("삭제");
		
		p2.add(btnAdd);
		p2.add(btnDel);
		
		String cb[] = {"전체", "홍보부", "교육부", "인사부"};
		cbResult = new JComboBox<String>(cb);
		p2.add(new JLabel("출력순서"));
		p2.add(cbResult);
		
		ButtonGroup bg = new ButtonGroup();	//그룹버튼
		rbAll = new JRadioButton("전체");
		bg.add(rbAll);
		p2.add(rbAll);
		rbMan = new JRadioButton("남자");
		bg.add(rbMan);
		p2.add(rbMan);
		rbGirl = new JRadioButton("여자");
		bg.add(rbGirl);
		p2.add(rbGirl);
		
		
		
		this.add("South",p2);
		
		
		cbResult.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				order=cbResult.getSelectedIndex()+1;
				//다시 출력
				writeDB();
				
			}
		});
		
		btnAdd.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(tfNum.getText().length() == 0) {
					return;
				}
				if(tfName.getText().length() == 0) {
					return;
				}
				if(tfScore.getText().length() == 0) {
					return;
				}
				if(tfGender.getText().length() == 0) {
					return;
				}
				if(tfBuseo.getText().length() == 0) {
					return;
				}
				
				Connection conn = db.getConnection();
				PreparedStatement pstmt = null;
				String sql = "insert into sawon values (?,?,?,?,?)";
				
				try {
					pstmt = conn.prepareStatement(sql);
					pstmt.setInt(1,Integer.parseInt(tfNum.getText()));
					pstmt.setString(2, tfName.getText());
					pstmt.setInt(3, Integer.parseInt(tfScore.getText()));
					pstmt.setString(4, tfGender.getText());
					pstmt.setString(5, tfBuseo.getText());
					
					pstmt.execute();
					
					tfNum.setText("");
					tfName.setText("");
					tfScore.setText("");
					tfGender.setText("");
					tfBuseo.setText("");
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}finally {
					db.dbClose(pstmt, conn);
				}
				
			}
		});
		
		btnDel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int row = table.getSelectedRow();
				if(row == -1) {
					JOptionPane.showMessageDialog(Ex02_DBSawon.this, "삭제할 행을 선택해주세요");
					return;
				}
				//row 행의 0번열에 있는 시퀸스 값을 얻는다
				String num = table.getValueAt(row, 0).toString();
				
				//그 시퀸스에 해당하는 db데이터 삭제하는 sql문 작성
				String sql = "delete from student where num = ?";
				
				Connection conn = db.getConnection();
				PreparedStatement pstmt = null;
				
				try {
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, num);
					pstmt.execute();
					
					writeDB();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}finally {
					db.dbClose(pstmt, conn);
				}
			}
		});
		
		writeDB();
	}
	
	public void writeDB() {
		Connection conn = db.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "";		
		
		String result = rbAll.isSelected() ? "" : rbMan.isSelected() ? "and gender = '남자'" : rbGirl.isSelected() ? "and gender = '여자'" : "";
		
		if(order == 1) {
			if(result.length() == 0) {
				sql = "select * from sawon";		
			}
			else {
				String temp = result.substring(3);
				sql = "select * from sawon where" + temp;
			}
		}
		else if (order == 2) {
			sql = "select * from sawon where buseo = '홍보부'" + result;
		}
		else if(order == 3) {
			sql = "select * from sawon where buseo = '교육부'" + result;
		}
		else if(order == 4) {
			sql = "select * from sawon where buseo = '인사부'" + result;
		}
		
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			tableModel.setRowCount(0);
			
			while(rs.next()) {
				Vector<String> data=new Vector<String>();
				data.add(rs.getString("num"));
				data.add(rs.getString("name"));
				data.add(rs.getString("score"));
				data.add(rs.getString("gender"));
				data.add(rs.getString("buseo"));
				
				tableModel.addRow(data);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(pstmt, conn, rs);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ex02_DBSawon a=new Ex02_DBSawon("기본창");
	}

}