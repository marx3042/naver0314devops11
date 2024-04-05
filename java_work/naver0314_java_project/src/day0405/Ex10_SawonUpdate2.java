package day0405;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.mysql.cj.jdbc.Driver;
import day0404db.Ex01_MysqlSawon;

public class Ex10_SawonUpdate2 {
	static final String MYSQL_DRIVER="com.mysql.cj.jdbc.Driver";
	static final String MYSQL_URL="jdbc:mysql://localhost:3306/bit701?serverTimezone=Asia/Seoul";
	static final String USERNAME="root";
	static final String PASSWORD="1234";
	
	public Ex10_SawonUpdate2() {
		try {
			Class.forName(MYSQL_DRIVER);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void updateSawon() {
		Ex01_MysqlSawon sawon = new Ex01_MysqlSawon();
		sawon.writeSawon();
		System.out.println("-".repeat(40));
		
		Scanner sc = new Scanner(System.in);
		String updateName, updateBuseo;
		int updateScore;
		
		System.out.println("수정할 사람의 이름은?");
		updateName = sc.nextLine();
		System.out.println("수정할 점수는?");
		updateScore = Integer.parseInt(sc.nextLine());
		System.out.println("수정할 부서는?");
		updateBuseo = sc.nextLine();
		
		String sql = "update sawon set score=?,buseo=? where name=?";
		System.out.println(sql);
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		
		try {
			conn = DriverManager.getConnection(MYSQL_URL, USERNAME, PASSWORD);
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, updateScore);
			pstmt.setString(2, updateBuseo);
			pstmt.setString(3, updateName);
			
			int n = pstmt.executeUpdate();
			if(n == 0) {
				System.out.println("존재 안함");
			}
			else {
				System.out.println("수정함");
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
		Ex10_SawonUpdate2 ex = new Ex10_SawonUpdate2();
		ex.updateSawon();
	}
}
