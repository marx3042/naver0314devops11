package data.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

import data.dto.GuestDto;
import data.dto.SawonDto;
import db.common.MySqlConnect;

public class GuestDao {
	MySqlConnect db=new MySqlConnect();

	//추가
	public void insertGuest(GuestDto dto)
	{
		Connection conn=db.getConnection();
		PreparedStatement pstmt=null;
		String sql="insert into Guest (nickname,avata,content,writeday) values (?,?,?,now())";

		try {
			pstmt=conn.prepareStatement(sql);
			//바인딩
			pstmt.setString(1, dto.getNickname());
			pstmt.setString(2, dto.getAvata());
			pstmt.setString(3, dto.getContent());
			//실행
			pstmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(pstmt, conn);
		}
	}
	//출력
	public List<GuestDto> getAllGuest()
	{
		List<GuestDto> list=new Vector<GuestDto>();
		Connection conn=db.getConnection();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql="select * from Guest order by num desc";

		try {
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				GuestDto dto=new GuestDto();
				dto.setNum(rs.getInt("num"));
				dto.setNickname(rs.getString("nickname"));
				dto.setAvata(rs.getString("avata"));
				dto.setContent(rs.getString("content"));
				dto.setWriteday(rs.getTimestamp("writeday"));

				list.add(dto);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(pstmt, conn);
		}
		return list;
	}

	//검색
	public List<GuestDto> getSearchGuest(String searchWord)
	{
		List<GuestDto> list=new Vector<GuestDto>();
		Connection conn=db.getConnection();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql="select * from Guest where nickname like ? order by num desc";

		try {
			pstmt=conn.prepareStatement(sql);
			//바인딩
			pstmt.setString(1, "%"+searchWord+"%");
			//실행
			rs=pstmt.executeQuery();
			while(rs.next()) {
				GuestDto dto=new GuestDto();
				dto.setNum(rs.getInt("num"));
				dto.setNickname(rs.getString("nickname"));
				dto.setAvata(rs.getString("avata"));
				dto.setContent(rs.getString("content"));
				dto.setWriteday(rs.getTimestamp("writeday"));

				list.add(dto);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(pstmt, conn);
		}
		return list;
	}
	//상세보기
	public GuestDto getData(int num)
	{
		GuestDto dto=new GuestDto();
		Connection conn=db.getConnection();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql="select * from Guest where num=?";

		try {
			pstmt=conn.prepareStatement(sql);
			//바인딩
			pstmt.setInt(1,num);
			//실행
			rs=pstmt.executeQuery();
			if(rs.next()) {
				dto.setNum(rs.getInt("num"));
				dto.setNickname(rs.getString("nickname"));
				dto.setAvata(rs.getString("avata"));
				dto.setContent(rs.getString("content"));
				dto.setWriteday(rs.getTimestamp("writeday"));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(rs,pstmt, conn);
		}
		return dto;
	}

	//삭제
	public void deleteGuest(int num)
	{
		GuestDto dto=new GuestDto();
		Connection conn=db.getConnection();
		PreparedStatement pstmt=null;
		String sql="delete from Guest where num=?";

		try {
			pstmt=conn.prepareStatement(sql);
			//바인딩
			pstmt.setInt(1,num);
			//실행
			pstmt.execute();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(pstmt, conn);
		}		
	}

	//수정
	public void updateGuest(GuestDto dto)
	{
		String sql="update guest set nickname=?,content=? where num=?";
		Connection conn=db.getConnection();
		PreparedStatement pstmt=null;

		try {
			pstmt=conn.prepareStatement(sql);
			//바인딩
			pstmt.setString(1, dto.getNickname());
			pstmt.setString(2, dto.getContent());			
			pstmt.setInt(3, dto.getNum());
			//실행
			pstmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(pstmt, conn);
		}
	}
}