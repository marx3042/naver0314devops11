package member.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import member.dao.MemberDao;

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
}
