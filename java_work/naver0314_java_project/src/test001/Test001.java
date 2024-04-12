package test001;

import java.util.Stack;

public class Test001 {
	public int solution(int board[][], int moves[]) {
		int answer = 0;
		Stack<Integer> s = new Stack<>();
		int temp, s_temp;

		MOV:
		for(int n : moves) {
			for(int j = 0; j < board.length;j++) {
				if(board[j][n-1] == 0) {
					continue;
				}
				temp = board[j][n-1];	
				board[j][n-1] = 0;
				
				if (!(s.isEmpty())) {
					s_temp = s.pop();
					
					if(temp == s_temp) {
						answer += 2;
						continue MOV;
					}
					s.push(s_temp);
				}
				
				s.push(temp);				
				continue MOV;
			}
		}
		return answer;
	}
	
	public static void main(String[] args) {
		int board[][] = {{0,0,0,0,0},
						{0,0,1,0,3},
						{0,2,5,0,1},
						{4,2,4,4,2},
						{3,5,1,3,1}};
		
		int moves[] = {1,5,3,5,1,2,1,4};
		System.out.println(solution(board, moves));
		
	}
}
