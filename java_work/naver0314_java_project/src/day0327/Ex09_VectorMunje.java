package day0327;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.NumberFormat;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;

/*
 *   1.학생정보추가 : 이름,나이,3과목 점수입력
 *   2.학생정보삭제 : 이름으로 찾아서 삭제(없을경우 메세지 출력)
 *   3.전체출력 : 번호,이름,Java,Spring,HTML,총점,평균,등급 출력
 *   4.평균으로검색 :  평균값을 입력하면 그 평균값 이상의 학생들을 출력
 *   5.이름으로검색 : 입력한이름을 포함하고 있으면 출력(contains)
 *   6.저장후종료
 */
public class Ex09_VectorMunje {

	static final String FILENAME="d:/naver0314/student.txt";
	Scanner sc=new Scanner(System.in);
	List<StudentDto> list=new Vector<StudentDto>();

	public Ex09_VectorMunje() {
		// TODO Auto-generated constructor stub
		studentReadData();//처음 생성시 무조건 파일 읽어서 list 에 담기
	}

	//파일에서 데이타 읽기
	public void studentReadData()
	{
		FileReader fr=null;
		BufferedReader br=null;
		try {
			fr=new FileReader(FILENAME);
			br=new BufferedReader(fr);

			while(true)
			{
				//한줄단위로 읽기
				String line=br.readLine();
				if(line==null)
					break;
				//,단위로 분리(배열형태로 분리)
				String []data=line.split(",");
				//StudentDto 생성후 setter 로 데이타 넣기 또는 생성자 통해서 넣기도됨
				StudentDto dto=new StudentDto();
				dto.setName(data[0]);
				dto.setAge(Integer.parseInt(data[1]));
				dto.setJava(Integer.parseInt(data[2]));
				dto.setSpring(Integer.parseInt(data[3]));
				dto.setHtml(Integer.parseInt(data[4]));

				//list 에 추가
				list.add(dto);
			}
			System.out.println("총 "+list.size()+"명의 학생정보를 읽어왔습니다!");
		} catch (FileNotFoundException e) {
			System.out.println("읽어올 학생 정보가 없습니다");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				br.close();
				fr.close();
			}catch (IOException|NullPointerException e) {
				// TODO: handle exception
			}
		}

	}

	public int getMenu()
	{
		int menu=0;
		System.out.println("1.학생정보추가");
		System.out.println("2.학생정보삭제");
		System.out.println("3.전체출력");
		System.out.println("4.평균으로검색");
		System.out.println("5.이름으로검색");
		System.out.println("6.저장후종료");
		System.out.println("=============");
		try {
			menu=Integer.parseInt(sc.nextLine());
		}catch (NumberFormatException e) {
			//만약 문자가 입력되면 무조건 전체출력을 해보자
			menu=3;
		}
		return menu;
	}

	public void addStudent()
	{
		System.out.println("학생 이름을 입력해주세요");
		String name=sc.nextLine();

		int age,java,spring,html;
		System.out.println("나이를 입력해주세요");
		try {
			age=Integer.parseInt(sc.nextLine());
		}catch (NumberFormatException e) {
			//만약 문자가 입력시 무조건 나이는 0으로 주기
			age=0;
		}

		System.out.println("자바점수를 입력해주세요");
		try {
			java=Integer.parseInt(sc.nextLine());
		}catch (NumberFormatException e) {
			//만약 문자가 입력시 무조건 0으로 주기
			java=0;
		}

		System.out.println("스프링점수를 입력해주세요");
		try {
			spring=Integer.parseInt(sc.nextLine());
		}catch (NumberFormatException e) {
			//만약 문자가 입력시 무조건 0으로 주기
			spring=0;
		}

		System.out.println("HTML점수를 입력해주세요");
		try {
			html=Integer.parseInt(sc.nextLine());
		}catch (NumberFormatException e) {
			//만약 문자가 입력시 무조건 0으로 주기
			html=0;
		}

		//StudentDto 생성후 list 에 추가
		StudentDto dto=new StudentDto(name, age, java, spring, html);
		list.add(dto);
		System.out.println(list.size()+"번째 학생정보를 추가하였습니다");
	}

	public void deleteStudent()
	{
		boolean f=false;
		System.out.println("삭제할 학생의 이름은?");
		String name=sc.nextLine();

		for(int i=0;i<list.size();i++)
		{
			StudentDto dto=list.get(i);
			if(dto.getName().equals(name))
			{
				f=true;
				//삭제
				list.remove(i);
				break;
			}
		}

		if(f)
			System.out.println(name+" 님의 정보를 삭제했습니다");
		else
			System.out.println(name+"님은 명단에 없습니다");
	}

	public void writeStudent()
	{
		System.out.println("\t\t** 전체 학생정보 출력 **\n");
		System.out.println("=".repeat(70));
		System.out.println("번호\t이름\t나이\tJava\tSpring\tHTML\t총점\t평균\t등급");
		System.out.println("=".repeat(70));
		//평균은 소숫점 한자리로 출력해보자
		NumberFormat nf=NumberFormat.getInstance();
		nf.setMaximumFractionDigits(1);

		for(int i=0;i<list.size();i++)
		{
			StudentDto dto=list.get(i);
			System.out.println(i+1+"\t"+dto.getName()+"\t"+dto.getAge()+"\t"+
					dto.getJava()+"\t"+dto.getSpring()+"\t"+dto.getHtml()+"\t"+dto.getTotal()
					+"\t"+nf.format(dto.getAvg())+"\t"+dto.getGrade());
		}
		System.out.println("=".repeat(70));

	}

	public void searchAverage()
	{
		//입력하는 평균값 이상의 학생정보만 출력하기
		System.out.println("검색할 평균값은?");
		double avg=Double.parseDouble(sc.nextLine());

		System.out.printf("\t\t** %5.1f 평균이상의 학생정보 출력 **\n",avg);
		System.out.println("=".repeat(70));
		System.out.println("번호\t이름\t나이\tJava\tSpring\tHTML\t총점\t평균\t등급");
		System.out.println("=".repeat(70));
		//평균은 소숫점 한자리로 출력해보자
		NumberFormat nf=NumberFormat.getInstance();
		nf.setMaximumFractionDigits(1);

		for(int i=0;i<list.size();i++)
		{
			StudentDto dto=list.get(i);
			if(dto.getAvg()>=avg)
				System.out.println(i+1+"\t"+dto.getName()+"\t"+dto.getAge()+"\t"+
						dto.getJava()+"\t"+dto.getSpring()+"\t"+dto.getHtml()+"\t"+dto.getTotal()
						+"\t"+nf.format(dto.getAvg())+"\t"+dto.getGrade());
		}
		System.out.println("=".repeat(70));
	}

	public void searchName()
	{
		//입력하는 이름을 포함한 학생정보만 출력하기
		System.out.println("검색할 이름은?");
		String name=sc.nextLine();

		System.out.printf("\t\t** \"%s\" 이름을 포함한 학생정보 출력 **\n",name);
		System.out.println("=".repeat(70));
		System.out.println("번호\t이름\t나이\tJava\tSpring\tHTML\t총점\t평균\t등급");
		System.out.println("=".repeat(70));
		//평균은 소숫점 한자리로 출력해보자
		NumberFormat nf=NumberFormat.getInstance();
		nf.setMaximumFractionDigits(1);

		for(int i=0;i<list.size();i++)
		{
			StudentDto dto=list.get(i);
			if(dto.getName().contains(name))
				System.out.println(i+1+"\t"+dto.getName()+"\t"+dto.getAge()+"\t"+
						dto.getJava()+"\t"+dto.getSpring()+"\t"+dto.getHtml()+"\t"+dto.getTotal()
						+"\t"+nf.format(dto.getAvg())+"\t"+dto.getGrade());
		}
		System.out.println("=".repeat(70));
	}

	public void studentFileSave()
	{
		FileWriter fw=null;
		try {
			fw=new FileWriter(FILENAME);
			for(StudentDto dto:list)
			{
				String s=dto.getName()+","+dto.getAge()+","+dto.getJava()+","+dto.getSpring()+","+dto.getHtml()+"\n";
				//파일에 저장
				fw.write(s);
			}
			System.out.println("총 "+list.size()+"명의 정보를 저장합니다!");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(fw!=null)
				try {
					fw.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}

	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.println("컴퓨터".contains("컴"));//true
		//System.out.println("컴퓨터".contains("하"));//false

		Ex09_VectorMunje ex=new Ex09_VectorMunje();

		while(true)
		{
			int menu=ex.getMenu();
			switch(menu)
			{
			case 1:
				ex.addStudent();
				break;
			case 2:
				ex.deleteStudent();
				break;
			case 3:
				ex.writeStudent();
				break;
			case 4:
				ex.searchAverage();
				break;
			case 5:
				ex.searchName();
				break;
			case 6:
				ex.studentFileSave();
				System.out.println("** 저장후 종료합니다 **");
				System.exit(0);
			}
			System.out.println();
		}

	}
}

