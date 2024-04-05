package day0405;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Ex02_ShopCartJoin {
	static final String MYSQL_DRIVER="com.mysql.cj.jdbc.Driver";
	static final String MYSQL_URL="jdbc:mysql://localhost:3306/bit701?serverTimezone=Asia/Seoul";
	static final String USERNAME="root";
	static final String PASSWORD="1234";
	
	public void writeCarJoin() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = """
				select
				cartnum, username, sangpum, price, color, date_format(guipday, '%Y-%m-%d %H:%i') guipday 
				from shop, cart
				where shop.shopnum=car.shopnum
				""";
		try {
			conn = DriverManager.getConnection(MYSQL_URL, USERNAME, PASSWORD);
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			System.out.println("\t** 나의 장바구니**\n");
			System.out.println("시퀸스\t이름\t상품명\t가격\t색상\t구입일");
			System.out.println("=".repeat(50));
			
			while(rs.next()) {
				int cn = rs.getInt("cartnum");
				String s = rs.getString("sangpum");
				String u = rs.getString("useranme");
				int p = rs.getInt("price");
				String c = rs.getString("color");
				String g = rs.getString("guipday");
				
				System.out.println(cn+"\t"+u+"\t"+s+"\t"+p+"\t"+c+"\t"+g);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				rs.close();
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		Ex01_MysqlSawonGroup ex2 = new Ex01_MysqlSawonGroup();
	}
}
