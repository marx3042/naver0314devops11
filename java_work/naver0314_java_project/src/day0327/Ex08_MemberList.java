package day0327;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ex08_MemberList {
	List<MemberDto> list=new ArrayList<MemberDto>();
	Scanner sc=new Scanner(System.in);
	static final String FILENAME="d:/naver0314/member.txt";

	public Ex08_MemberList() {
		// TODO Auto-generated constructor stub
		memberReadFile();
	}
	
	//파일 읽기-처음 생성시 자동으로 파일에서 멤버 읽어오기
	public void memberReadFile()
	{
		FileReader fr=null;
		BufferedReader br=null;
		
		try {
			fr=new FileReader(FILENAME);
			br=new BufferedReader(fr);
			
			while(true)
			{
				String s=br.readLine();
				if(s==null)
					break;
				//이효리,010-2222-3333,서울,ab  이런형태로 읽어옴
				//, 로 분리하기
				String []a=s.split(",");
				//MemberDto 생성후 setter로 데이타 넣기
				MemberDto dto=new MemberDto();
				dto.setName(a[0]);
				dto.setHp(a[1]);
				dto.setAddr(a[2]);
				dto.setBlood(a[3]);
				
				//list 에 추가
				list.add(dto);				
			}
			System.out.println("총 "+list.size()+"명의 멤버 정보를 읽어왔어요!!");
		} catch (FileNotFoundException e) {
			System.out.println("읽어올 멤버 정보가 없습니다");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				br.close();
				fr.close();
			}catch (IOException|NullPointerException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
	}
	
	//종료시 파일 저장
	public void memberFileSave()
	{
		FileWriter fw=null;
		try {
			fw=new FileWriter(FILENAME);
			for(MemberDto dto:list)
			{
				String s=dto.getName()+","+dto.getHp()+","+dto.getAddr()+","+dto.getBlood()+"\n";
				fw.write(s);						
			}
			System.out.println("총 "+list.size()+" 명의 정보를 파일에 저장하였습니다");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				fw.close();
			} catch (IOException|NullPointerException e) {//두가지 Exception 을 같이 처리하고자 할경우
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	//메뉴 선택
	public int getMenu()
	{
		int menu=0;
		System.out.println("1. 멤버정보 추가");
		System.out.println("2. 멤버삭제");
		System.out.println("3. 전체멤버출력");
		System.out.println("4. 이름으로 검색");
		System.out.println("5. 핸드폰으로 검색");
		System.out.println("6. 저장후종료");
		System.out.println("================");
		try {
			menu=Integer.parseInt(sc.nextLine());
		}catch (NumberFormatException e) {//문자 입력시 발생하는 Exception
			System.out.println("번호를 숫자로 입력해주세요");
		}
		
		return menu;
	}
	
	//멤버 데이타 추가
	public void addMember()
	{
		System.out.println("이름을 입력하세요");
		String name=sc.nextLine();
		System.out.println("핸드폰을 입력하세요");
		String hp=sc.nextLine();
		System.out.println("주소를 입력하세요");
		String addr=sc.nextLine();
		System.out.println("혈액형을 입력하세요");
		String blood=sc.nextLine();
		
		MemberDto dto=new MemberDto(name, hp, addr, blood);
		//list 에 추가
		list.add(dto);
		System.out.println(list.size()+"번째 멤버 정보를 추가하였습니다 !!");		
	}
	
	//멤버 삭제
	public void deleteMember()
	{
		/*
		 * 삭제할 이름을 입력후 해당 이름에 해당하는 멤버정보를 삭제한다
		 * 없을경우 "xxx 님은 명단에 없습니다"
		 * 있을경우 "xxx 님의 정보를 삭제하였습니다"
		 */
		boolean f=false;
		System.out.println("삭제할 멤버명을 입력하세요");
		String name=sc.nextLine();
		for(int i=0;i<list.size();i++)
		{
			MemberDto dto=list.get(i);
			if(dto.getName().equals(name))
			{
				f=true;
				list.remove(i);
				break;
			}
		}
		if(f)
			System.out.println(name+"님의 정보를 삭제하였습니다");
		else
			System.out.println(name+"님은 명단에 없습니다");
		
	}
	
	//전체 멤버 출력
	public void writeMember()
	{
		System.out.println("\t** 전체 멤버 명단 **\n");
		System.out.println("=".repeat(45));
		System.out.println("번호\t이름\t핸드폰\t\t주소\t혈액형");
		System.out.println("=".repeat(45));
		
		for(int i=0;i<list.size();i++)
		{
			MemberDto dto=list.get(i);
			System.out.println(i+1+"\t"+dto.getName()+"\t"+dto.getHp()+"\t"+
			dto.getAddr()+"\t"+dto.getBlood().toUpperCase()+"형");
		}
		System.out.println("=".repeat(45));
	}
	
	//이름으로 검색
	public void searchName()
	{
		/*
		 *  검색할 이름 입력인데 성만 입력해도 해당 성을 가진 사람 출력(startsWith)
		 *  한명도 없을경우 "xxx 님은 명단에 없습니다"
		 *  
		 *  이름 : xxx
		 *  핸드폰 : xxx
		 *  주소 : xxx
		 *  혈액형 : A형
		 *  ------------
		 *  이름 : xxx
		 *  핸드폰 : xxx
		 *  주소 : xxx
		 *  혈액형 : A형
		 *  ------------
		 */
		boolean f=false;
		System.out.println("검색할 멤버명을 입력하세요");
		String name=sc.nextLine();//성만 입력도 가능
		for(MemberDto dto:list)
		{
			//입력한 이름으로 시작하는 경우 출력
			if(dto.getName().startsWith(name))
			{
				f=true;
				System.out.println("이름 : "+dto.getName());
				System.out.println("핸드폰 : "+dto.getHp());
				System.out.println("주소 : "+dto.getAddr());
				System.out.println("혈액형 : "+dto.getBlood().toUpperCase()+"형");
				System.out.println("-".repeat(20));
			}
		}
		
		if(!f)//if(f==false)
			System.out.println(name+" 님은 명단에 없습니다");
	}
	
	//전화번호로 검색
	public void searchPhone()
	{
		/*
		 *  검색할 핸드폰 끝4자리 입력하면 그 번호를 가진 사람 출력(endsWith)
		 *  한명도 없을경우 "xxxx 번호를 가진 멤버는 없습니다"
		 *  
		 *  이름 : xxx
		 *  핸드폰 : xxx
		 *  주소 : xxx
		 *  혈액형 : A형
		 *  ------------
		 *  이름 : xxx
		 *  핸드폰 : xxx
		 *  주소 : xxx
		 *  혈액형 : A형
		 *  ------------
		 */
		boolean f=false;
		System.out.println("검색할 핸드폰 뒤 4자리를 입력하세요");
		String phone=sc.nextLine();//4자리 숫자 입력
		for(MemberDto dto:list)
		{
			//입력한 숫자로 끝나는 핸드폰 찾기
			if(dto.getHp().endsWith(phone))
			{
				f=true;
				System.out.println("이름 : "+dto.getName());
				System.out.println("핸드폰 : "+dto.getHp());
				System.out.println("주소 : "+dto.getAddr());
				System.out.println("혈액형 : "+dto.getBlood().toUpperCase()+"형");
				System.out.println("-".repeat(20));
			}
		}
		
		if(!f)//if(f==false)
			System.out.println(phone+" 번호를 가진 멤버는 명단에 없습니다");
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ex08_MemberList ex=new Ex08_MemberList();
		
		while(true)
		{
			int menu=ex.getMenu();
			
			switch(menu)
			{
			case 1:
				ex.addMember();
				break;
			case 2:
				ex.deleteMember();
				break;
			case 3:
				ex.writeMember();
				break;
			case 4:
				ex.searchName();
				break;
			case 5:
				ex.searchPhone();
				break;
			case 6:
				ex.memberFileSave();
				System.out.println("** 멤버 정보를 저장후 종료합니다 **");
				System.exit(0);//종료
			default:
				System.out.println("잘못된 번호입니다");
			}
			System.out.println();
		}

	}

}






























