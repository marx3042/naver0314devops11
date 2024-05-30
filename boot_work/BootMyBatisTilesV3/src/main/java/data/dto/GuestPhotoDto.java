package data.dto;

import org.apache.ibatis.type.Alias;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Alias("GuestPhotoDto")
public class GuestPhotoDto {
	private int photoidx;
	private int guestidx;
	private String photoname;
}