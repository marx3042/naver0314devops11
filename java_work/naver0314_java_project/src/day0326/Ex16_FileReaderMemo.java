package day0326;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Ex16_FileReaderMemo {

	static final String FILENAME2 = "d:/naver0314/memo2.txt";	
	public static void readMemo2 () {
		BufferedReader br = null;
		FileReader fr = null;

		try {
			fr = new FileReader(FILENAME2);
			System.out.println("** memo2 파일을 읽습니다 **");
			br = new BufferedReader(fr);

			while(true) {
				//파일의 내용을 한줄씩 읽어온다
				String line = br.readLine();
				if (line == null) {
					break;
				}
				System.out.println(line);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			System.out.println("** memo2 파일이 없어요 **");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				br.close();
				fr.close();
			} catch (IOException e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		readMemo2();
	}
}
