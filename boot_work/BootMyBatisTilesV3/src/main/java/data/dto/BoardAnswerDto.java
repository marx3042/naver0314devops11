package data.dto;

import java.sql.Timestamp;

import org.apache.ibatis.type.Alias;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Alias("badto")
public class BoardAnswerDto {
	private int aidx;
	private int num;
	private String writer;
	private String myid;
	private String content;
	private Timestamp writeday;	
}