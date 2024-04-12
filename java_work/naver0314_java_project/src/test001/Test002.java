package test001;

public class Test002 {

	public static int[] solution(String[] park, String[] routes) {
		int[] answer = new int[2];
		int x = 0, y = 0;

		for(int i = 0; i < park.length; i++) {
			if(park[i].contains("S")) {
				x = i;
				y = park[i].indexOf("S");
			}
		}


		int m;

		for (int i = 0; i < routes.length; i++) {
			String list[] = routes[i].split(" ");
			System.out.println(x + " " + y);
			
			RESULT:
			switch (list[0]) {
			case "E":
				m = Integer.parseInt(list[1]);
				if (y + 1 + m <= park[x].length()) {
					for (int j = 1; j <= m; j++) {
						if (park[x].charAt(y + j) == 'X') {
							break RESULT;
						}
					}
					y += m;
				}
				break;
			case "W":
				m = Integer.parseInt(list[1]);
				if (y + 1 - m >= 0) {
					for (int j = 1; j <= m; j++) {
						if (park[x].charAt(y - j) == 'X') {
							break RESULT;
						}
					}
					y -= m;
				}
				break;
			case "S":
				m = Integer.parseInt(list[1]);
				if (x + 1 + m <= park.length) {
					for (int j = 1; j <= m; j++) {
						if (park[x + j].charAt(y) == 'X') {
							break RESULT;
						}
					}
					x += m;
				}
				break;
			case "N":
				m = Integer.parseInt(list[1]);
				if (x + 1 - m >= 0) {
					for (int j = 1; j <= m; j++) {
						if (park[x - j].charAt(y) == 'X') {
							break RESULT;
						}
					}
					x -= m;
				}
				break;
			}
		}
		answer[0] = x;
		answer[1] = y;
		return answer;
	}

	public static void main(String[] args) {
		String park[] = {"OSO","OOO","OXO","OOO"};
		String routes[] = {"E 2","S 3","W 1"};

		int a[] = solution(park, routes);
		System.out.println(a[0] +" " +a[1]);


	}
}
