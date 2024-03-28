package day0327;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class Ex01_Set {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * Set 인터페이스를 구현한 클래스로는 TreeSet,HashSet 이 있다
		 * Set 타입의특징 : 1. 중복데이타를 허용하지 않는다
		 *               2. 비순차적이다
		 *               3. TreeSet 은 오름차순으로 들어간다
		 *                  HashSet 은 그냥 자기 마음대로 들어간다
		 */
		//<Integer> :제네릭, 해당 컬렉션에는 Integer 타입만 넣을수 있다,다른타입을 넣을경우 컴파일오류 발생
		//Set<Integer> set1=new HashSet<Integer>();
		//Set<Integer> set1=new HashSet<>();//뒷부분 제네릭은 생략가능
		Set<Integer> set1=new TreeSet<>();
		set1.add(100);//JDK5이전에는 set1.add(new Integer(100));
		set1.add(78);
		set1.add(78);
		set1.add(100);
		set1.add(65);
		
		System.out.println("set1 의 데이타 갯수 :"+set1.size());//3개,중복데이타는 1번만 포함
		System.out.println("** 출력 1 **");
		for(int n:set1)
		{
			System.out.println(n);
		}
		System.out.println("** 출력 2 **");
		Iterator<Integer> iter=set1.iterator();
		while(iter.hasNext())
		{
			System.out.println(iter.next());
		}
	}
	

}














