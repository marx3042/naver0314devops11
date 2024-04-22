package test001;

import java.util.*;

public class Test001 {
	static public int[] solution(int n) {
        int answer[] = new int[n/2+1];
        
        for(int i = 1; i <= n; i+=2) {
        	answer[i/2+1] = i;
        }

        return answer;
    }
	
	public static void main(String[] args) {
		for(int i : solution(10)) {
			System.out.println(i);
		}
		
	}
}
