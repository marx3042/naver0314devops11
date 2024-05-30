package controller.guest;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import data.dto.GuestDto;
import data.dto.GuestPhotoDto;
import data.service.GuestService;
import data.service.MemberService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import naver.cloud.NcpObjectStorageService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/guest")
public class GuestAjaxController {
	@NonNull
	private GuestService guestService;
	@NonNull
	private MemberService memberService;
	@NonNull
	private NcpObjectStorageService storageService;
	
	private String bucketName="bitcamp-bucket-56";
	private String folderName="guestphoto";
	
	@PostMapping("/addguest")
	public void guestInsert(
			@RequestParam String gcontent,
			//required = false : null 값일경우도 값을 받음(원래는 400번 오류난다)
			@RequestParam(value = "upload",required = false) List<MultipartFile> upload,
			HttpSession session
			)
	{
		//쎄션으로부터 로그인한 아이디를 얻는다
		String myid=(String)session.getAttribute("loginid");
		//아이디에 해당하는 이름 얻기
		String writer=memberService.getDataById(myid).getName();
		//dto 에 데이타들 넣기
		GuestDto dto=GuestDto.builder()
				.writer(writer)
				.myid(myid)
				.gcontent(gcontent)
				.build();
		//db 에 일단 작성자,아이디,내용 저장
		guestService.insertGuest(dto);//이때 guestidx 로 방금추가된 시퀀스값이 들어온다
		int guestidx=dto.getGuestidx();
		//파일을 클라우드 스토리지에 업로드
		
		//파일을 업로드하지 않은경우
		//파일에서 직접 호출하는경우
//		if(upload.get(0).getOriginalFilename().equals(""))
//			return;
		
		//등록 버튼 클릭시 파일도 전달되는 방식
		System.out.println("upload="+upload);
		if(upload==null)
			return;
		
		for(MultipartFile mfile:upload)
		{
			//스토리지에 저장후 파일명 얻기
			String photoname=storageService.uploadFile(bucketName, folderName, mfile);
			
			//db 에 insert
			GuestPhotoDto pdto=new GuestPhotoDto();
			pdto.setGuestidx(guestidx);
			pdto.setPhotoname(photoname);
			
			//db 에 insert
			guestService.insertGuestPhoto(pdto);
		}
	}
	
	@GetMapping("/datas")
	public List<GuestDto> guestList()
	{
		//사진을 제외한 방명록 데이타 가져오기
		List<GuestDto> glist=guestService.getAllGuest();
		//각 방명록글에 첨부된 사진명 photos 에 넣기
		for(GuestDto dto:glist)
		{
			dto.setPhotos(guestService.getGuestPhoto(dto.getGuestidx()));
		}
		
		return glist;
	}
}