package data.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import data.dto.ReBoardDto;
import data.mapper.ReBoardMapperInter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ReBoardService {
	@NonNull
	private ReBoardMapperInter boardMapper;
	
	public int getMaxNum()
	{
		return boardMapper.getMaxNum();
	}
	
	public void updateRestep(int regroup,int restep)
	{
		Map<String, Integer> map=new HashMap<>();
		map.put("regroup", regroup);
		map.put("restep", restep);
		
		boardMapper.updateRestep(map);		
	}
	
	public void insertBoard(ReBoardDto dto)
	{
		int num=dto.getNum();
		int regroup=dto.getRegroup();
		int restep=dto.getRestep();
		int relevel=dto.getRelevel();
				
		if(num==0)//새글
		{
			regroup=this.getMaxNum()+1;
			restep=0;
			relevel=0;
		}else {//답글
			//기존의 같은 그룹글중 전달받은 restep 보다 큰 restep 은 모두 +1 하기
			this.updateRestep(regroup, restep);
			//전달받은 restep,relevel 에 +1
			restep+=1;
			relevel+=1;	
		}
		//dto 에 변경된 값 넣기
		dto.setRegroup(regroup);
		dto.setRestep(restep);
		dto.setRelevel(relevel);
		
		//db 에 insert
		boardMapper.insertBoard(dto);
	}
	
	public int getTotalCount()
	{
		return boardMapper.getTotalCount();
	}
	
	public List<ReBoardDto> getPagingList(int start,int perpage)
	{
		Map<String, Integer> map=new HashMap<>();
		map.put("start", start);
		map.put("perpage", perpage);
		
		return boardMapper.getPagingList(map);		
	}
	
	public void updateReadcount(int num)
	{
		boardMapper.updateReadcount(num);
	}
	
	public ReBoardDto getData(int num)
	{
		return boardMapper.getData(num);
	}
	public void updateBoard(ReBoardDto dto)
	{
		boardMapper.updateBoard(dto);
	}
	
	public void deleteBoard(int num)
	{
		boardMapper.deleteBoard(num);
	}
}