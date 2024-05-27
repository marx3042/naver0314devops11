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
	
	public MemberDto getDataById(String myid)
	{
		return memInter.getDataById(myid);
	}
	
	public void updatePhoto(int num,String photo)
	{
		Map<String, Object> map=new HashMap<>();
		map.put("num", num);
		map.put("photo", photo);
		memInter.updatePhoto(map);		
	}
	
	public void updateMember(MemberDto dto)
	{
		memInter.updateMember(dto);
	}
		
	public boolean isEqualPassCheck(int num,String passwd)
	{
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("num", num);
		map.put("passwd", passwd);
		int n=memInter.isEqualPassCheck(map);
		return n==1?true:false;
	}
	
	public void deleteMember(int num)
	{
		memInter.deleteMember(num);
	}
	
	public boolean isLoginCheck(String myid,String pass)
	{
		return memInter.isLoginCheck(myid, pass)==1?true:false;
	}
}