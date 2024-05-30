package data.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import data.dto.GuestDto;
import data.dto.GuestPhotoDto;
import data.mapper.GuestMapperInter;

@Service
public class GuestService {
	
	@Autowired
	private GuestMapperInter guestMapper;
	
	public void insertGuest(GuestDto dto)
	{
		guestMapper.insertGuest(dto);
	}
	
	public void insertGuestPhoto(GuestPhotoDto dto)
	{
		guestMapper.insertGuestPhoto(dto);
	}
	
	public List<GuestDto> getAllGuest()
	{
		return guestMapper.getAllGuest();
	}
	
	public List<String> getGuestPhoto(int guestidx)
	{
		return guestMapper.getGuestPhoto(guestidx);
	}

}