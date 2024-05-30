package data.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import data.dto.GuestDto;
import data.dto.GuestPhotoDto;

@Mapper
public interface GuestMapperInter {
	public void insertGuest(GuestDto dto);
	public void insertGuestPhoto(GuestPhotoDto dto);
	public List<GuestDto> getAllGuest();
	public List<String> getGuestPhoto(int guestidx);
	
	
}