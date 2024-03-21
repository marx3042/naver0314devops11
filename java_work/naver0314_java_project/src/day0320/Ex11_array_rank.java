package day0320;

public class Ex11_array_rank {
	public static void main(String[] args) {
		int score[] = {100, 90, 80, 90, 70};
		int rank[] = new int[5];
		/*
		 * 등수를 구하는데 동점일 경우 동순위를 부여한다
		 * 출력은 번호	점수	등수 순으로 출력한다
		 */
		for(int i = 0; i < score.length; i++) {
			rank[i] = 1;
			
			for (int j = 0; j < score.length; j++) {
				//상대방 점수가 더 크면 기준 등수(i)의 값을 1 증가한다
				if (score[i] < score[j]) {
					rank[i]++;
				}
			}
		}
		for(int i = 0; i < score.length; i++) {
			System.out.printf("%d 번호 %d점 %d등\n", i, score[i], rank[i]);
		}
	}
}