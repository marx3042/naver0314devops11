package test001;

import java.util.ArrayList;
import java.util.List;

public class Test {
	public static void main(String[] args) {
		String code = "abc1abc1abc";
		List<Character> ret = new ArrayList<>();
		boolean mode = false;
		
		for(int i = 0; i < code.length(); i++) {
			if(code.charAt(i) == '1') {
				if(mode) {
					mode = false;
				}
				else {
					mode = true;
				}
				continue;
			}
			
			if(mode) {
				if(i % 2 != 0) {
					ret.add(code.charAt(i));
				}				
			}
			else {
				if(i % 2 == 0) {
					ret.add(code.charAt(i));
				}
			}		
		}
		
		for(Character i : ret) {
			System.out.print(i);
		}
		
	}
}
