package member.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import member.dao.MemberDao;
import member.dto.MemberDto;

@Service
@AllArgsConstructor
public class MemberService {

	//@Autowired
	private MemberDao memberDao;
	
	public int getTotalCount()
	{
		return memberDao.getTotalCount();
	}
	
	public int getSearchId(String searchid)
	{
		return memberDao.getSearchId(searchid);
	}
	
	public void insertMember(MemberDto dto)
	{
		memberDao.insertMember(dto);
	}
	
	public List<MemberDto> getAllMembers()
	{
		return memberDao.getAllMembers();
	}
	
	public MemberDto getData(int num)
	{
		return memberDao.getData(num);
	}

	public void updatePhoto(int num,String photo)
	{
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("num", num);
		map.put("photo", photo);
		memberDao.updatePhoto(map);
	}
	
	public void updateMember(MemberDto dto)
	{
		memberDao.updateMember(dto);
	}
	
	public boolean isEqualPassCheck(int num,String passwd)
	{
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("num", num);
		map.put("passwd", passwd);
		
		return memberDao.isEqualPassCheck(map);
	}
	public void deleteMember(int num)
	{
		memberDao.deleteMember(num);
	}
}