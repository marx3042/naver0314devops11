package day0401;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Ex04_Network {

	public static void main(String[] args) throws UnknownHostException{
		//작 ㅣ컴퓨터의 IP와 컴퓨터 이름 알아보기
		InetAddress local = InetAddress.getLocalHost();
		System.out.println("내컴퓨터IP : " + local.getHostAddress());
		System.out.println("내컴퓨터이름 : " + local.getHostName());
		System.out.println("=".repeat(40));

		System.out.println("Naver의 서버 컴퓨터 IP");
		InetAddress naverInet[] = InetAddress.getAllByName("www.naver.com");
		for(InetAddress inet : naverInet) {
			System.out.println("네이버 ip : "+inet);
		}

		System.out.println("=".repeat(40));

		System.out.println("google의 서버 컴퓨터 IP");
		InetAddress googleInet[] = InetAddress.getAllByName("www.google.com");
		for(InetAddress inet : googleInet) {
			System.out.println("구글 ip : "+inet);
		}
	}
}
