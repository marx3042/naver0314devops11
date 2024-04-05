package day0405;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Ex12_Student {
	static final String MYSQL_DRIVER="com.mysql.cj.jdbc.Driver";
	static final String MYSQL_URL="jdbc:mysql://localhost:3306/bit701?serverTimezone=Asia/Seoul";
	static final String USERNAME="root";
	static final String PASSWORD="1234";
	
	public Ex12_Student() {
		try {
			Class.forName(MYSQL_DRIVER);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	public void insetStudent(String name, int java, int html, int spring) {
		String sql = "insert into student (name, java, html, spring, testday) values(?,?,?,?,now())";
		try {
			conn = DriverManager.getConnection(MYSQL_URL, USERNAME, PASSWORD);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setInt(2, java);
			pstmt.setInt(3, html);
			pstmt.setInt(4, spring);
			
			pstmt.execute();
			writeStudent();
			
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
		
		System.out.println("\n"+name+"님의 성적을 들록하였습니다");
	}
	
	public void deleteStudent(String name) {
		String sql = "delete from student where name = ?";
		//삭제하는 db코드 추가
		try {
			conn = DriverManager.getConnection(MYSQL_URL, USERNAME, PASSWORD);
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, name);
			pstmt.execute();
			
			int n = pstmt.executeUpdate();
			if(n == 0) {
				System.out.println("지운다");
			}
			else {
				System.out.println("삭제함");
			}
			
			writeStudent();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//해당 학생이 없을경우 -xxx님은 명단에 없어요
		//있을경우 -XXX님의 성적 정보를 삭제
		
	}
	public void writeStudent() {
		String sql = """
				select num,name,java,html,spring,
				java+html+spring tot, round((java+html+spring)/3,1) avg,
				date_format(testday,'%Y-%m-%d %H:%i') testday
				from student
				""";
		try {
			conn = DriverManager.getConnection(MYSQL_URL, USERNAME, PASSWORD);
			
			System.out.println("\n"+"=".repeat(60));
			System.out.println("이름\t자바\thtml\tspring\ttot\tavg\ttestday");
			System.out.println("=".repeat(60));
			
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				
				String name = rs.getString("name");
				int java = rs.getInt("java");
				int html = rs.getInt("html");
				int spring = rs.getInt("spring");
				int tot = java+html+spring;
				double avg = tot/3;
				String testday = rs.getString("testday");
				
				System.out.println(name+"\t"+java+"\t"+html+"\t"+spring+"\t"+tot+"\t"+avg+"\t"+testday);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		Ex12_Student ex = new Ex12_Student();
		Scanner sc = new Scanner(System.in);
		int menu = 0, java, html, spring;
		String name;
		
		while(true) {
			System.out.println("1.학생정보추가	2. 이름으로 삭제	3. 전체출력	4. 종료");
			menu = Integer.parseInt(sc.nextLine());
			if(menu == 1) {
				System.out.println("추가할 이름은?");
				name = sc.nextLine();
				System.out.println("자바 점수는?");
				java = Integer.parseInt(sc.nextLine());
				System.out.println("html 점수는?");
				html = Integer.parseInt(sc.nextLine());
				System.out.println("spring 점수는?");
				spring = Integer.parseInt(sc.nextLine());
				
				ex.insetStudent(name, java, html, spring);
			}
			else if(menu == 2) {
				System.out.println("삭제할 학생의 이름은?");
				name = sc.nextLine();
				ex.deleteStudent(name);
			}
			else if(menu == 3) {
				ex.writeStudent();
			}
			else {
				System.out.println("종료");
				break;
			}
			System.out.println("=".repeat(60));
		}
	}
}
