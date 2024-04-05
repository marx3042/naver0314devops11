package day0405;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import com.mysql.cj.jdbc.Driver;

public class Ex07_Sawondelete {
	static final String MYSQL_DRIVER="com.mysql.cj.jdbc.Driver";
	static final String MYSQL_URL="jdbc:mysql://localhost:3306/bit701?serverTimezone=Asia/Seoul";
	static final String USERNAME="root";
	static final String PASSWORD="1234";
	
	public Ex07_Sawondelete() {
		try {
			Class.forName(MYSQL_DRIVER);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void deleteSawon() {
		Scanner sc = new Scanner(System.in);
		String delName = "";
		System.out.println("삭제할 이름을 입력하세요");
		delName = sc.nextLine();
		String sql = "delete from sawon where name = ?"; 
		
		Connection conn = null;
		PreparedStatement pstmt = null;

		
		
		try {
			conn = DriverManager.getConnection(MYSQL_URL, USERNAME, PASSWORD);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, delName);
			
			int n = pstmt.executeUpdate();
			if(n == 0) {
				System.out.println("없음");
			}
			else {
				System.out.println("삭제함");
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {

				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		Ex07_Sawondelete ex = new Ex07_Sawondelete();
		ex.deleteSawon();
	}
}
