package data.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import data.dto.BoardAnswerDto;
import data.mapper.BoardAnswerMapperInter;

@Service
public class BoardAnswerService {

	@Autowired
	private BoardAnswerMapperInter anInter;
	
	public void insertAnswer(BoardAnswerDto dto)
	{
		anInter.insertAnswer(dto);
	}
	
	public List<BoardAnswerDto> getAnswerData(int num)
	{
		return anInter.getAnswerData(num);
	}
	
	public void deleteAnswer(int aidx)
	{
		anInter.deleteAnswer(aidx);
	}
}