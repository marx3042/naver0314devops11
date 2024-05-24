package data.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import data.dto.MemberDto;
import data.mapper.MemberMapperInter;

@Service
public class MemberService {
	@Autowired
	private MemberMapperInter memInter;
	
	public int getTotalCount()
	{
		return memInter.getTotalCount();
	}
	public int getIdCheckCount(String searchid)
	{
		return memInter.getIdCheckCount(searchid);
	}
	
	public void insertMember(MemberDto dto)
	{
		memInter.insertMember(dto);
	}
	
	public List<MemberDto> getAllMembers()
	{
		return memInter.getAllMembers();
	}
	
	public MemberDto getData(int num)
	{
		return memInter.getData(num);
	}
	
	public void updatePhoto(int num,String photo)
	{
		Map<String, Object> map=new HashMap<>();
		map.put("num", num);
		map.put("photo", photo);
		memInter.updatePhoto(map);		
	}
	
	public int checkForPasswd(int num, String passwd) {
		Map<String, Object> map = new HashMap<>();
		map.put("passwd", passwd);
		map.put("num", num);
		return memInter.checkForPasswd(map);
	}
	
	public void deleteMember(int num) {
		memInter.deleteMember(num);
	}
}