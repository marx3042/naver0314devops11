package day0520.uploadcontroller;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class UploadOneController {

	@GetMapping("/uploadform1")
	public String upload1()
	{
		return "upload/uploadform1";
	}
	
	@PostMapping("/upload1")
	public String uploadPhoto1(
			@RequestParam String title,
			@RequestParam("upload") MultipartFile upload,
			HttpServletRequest request,
			Model model
			)
	{
		//���ϼ����� ������ ������Ʈ���� �̹����� ���ε�� ��α��ϱ�
		String realFolder=request.getSession().getServletContext().getRealPath("/resources/upload");
		System.out.println(realFolder);//�ַܼ� ����� Ž���⸦ ��� �̹����� Ȯ�����ּ���
		
		//���ε��� ���ϸ�
		String fileName=upload.getOriginalFilename();
		
		//���� ��ο� �ش� ���ϸ����� ���ε��غ���
		try {
			upload.transferTo(new File(realFolder+"/"+fileName));
			//���ε�� ������ ���ٸ� model �� ����
			model.addAttribute("title", title);
			model.addAttribute("photo", fileName);
			
		} catch (IllegalStateException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return "upload/resultphoto1";
	}
}