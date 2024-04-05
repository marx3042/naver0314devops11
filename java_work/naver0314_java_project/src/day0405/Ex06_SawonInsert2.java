package day0405;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import com.mysql.cj.jdbc.Driver;

public class Ex06_SawonInsert2 {
	static final String MYSQL_DRIVER="com.mysql.cj.jdbc.Driver";
	static final String MYSQL_URL="jdbc:mysql://localhost:3306/bit701?serverTimezone=Asia/Seoul";
	static final String USERNAME="root";
	static final String PASSWORD="1234";
	
	public Ex06_SawonInsert2() {
		try {
			Class.forName(MYSQL_DRIVER);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void insertSawon() {
		Scanner sc = new Scanner(System.in);
		String name, gender, buseo;
		int score, gnum, bnum;
		String sql = "";
		
		System.out.println("이름은?");
		name = sc.nextLine();
		System.out.println("점수는?");
		score = Integer.parseInt(sc.nextLine());
		System.out.println("성별은 선택 1.남자 2.여자");
		gnum = Integer.parseInt(sc.nextLine());
		gender = gnum == 1 ? "남자" : "여자";
		
		System.out.println("부서는 1.홍보부 2.인사부 3.교육부");
		bnum = Integer.parseInt(sc.nextLine());
		buseo = bnum == 1 ? "홍보부" : bnum == 2 ? "인사부" : "교육부";
		sql = "insert into sawon (name, score, gender, buseo) values (?,?,?,?)";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DriverManager.getConnection(MYSQL_URL, USERNAME, PASSWORD);
			pstmt = conn.prepareStatement(sql);
			//4개의  ? 에 차례대로 값을 바인딩
			pstmt.setString(1,  name);
			pstmt.setInt(2,  score);
			pstmt.setString(3, gender);
			pstmt.setString(4,  buseo);
			
			//바인딩이 모두 끝난 후 execute
			pstmt.execute();
			
			System.out.println("데이터 추가 성공!");
			
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
		Ex06_SawonInsert2 ex = new Ex06_SawonInsert2();
		ex.insertSawon();
	}
}
