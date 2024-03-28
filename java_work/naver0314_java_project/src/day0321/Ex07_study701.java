package day0321;

import java.util.Date;
import java.text.SimpleDateFormat;

import javax.lang.model.util.SimpleAnnotationValueVisitor14;

public class Ex07_study701 {
	public static void main(String[] args) {
		String []members= {
				"강하윤","공병현","김도훈","김우형","김정호",
				"김창인","민경진","박민지","박보민","박주용",
				"박한경","배동우","서정현","손가원","시바타유니",
				"신완철","우태형","유상곤","이가현","이병현",
				"이장우","이현성","정민석","정상혁","정진욱",
				"정환용","최시현","허승필","황재웅", "꽝"
		};
		
		String[][]team = new String[6][5];
		int random[] = new int[30];
		int next = 0;
		
		for(int i = 0; i < random.length; i++) {
			int num = (int)(Math.random() * 30);
			random[i] = num;
			for(int j = 0; j < i; j++) {
				if(random[i] == random[j]) {
					i--;
					break;
				}
			}
		}
		
		for(int i = 0; i < team.length;i++) {
			for(int j = 0; j < team[i].length; j++) {
				team[i][j] = members[random[next++]];
				// next++;
			}
			
		}
		
		Date date = new Date();
		SimpleDateFormat d = new SimpleDateFormat("yyyy년 MM월 dd일");
		System.out.println("\t" + d.format(date));
		
		
		for(int i = 0; i < team.length;i++) {
			System.out.printf("[%d조팀] ", i + 1);
			for(int j = 0; j < team[i].length; j++) {
				System.out.printf("%7s ", team[i][j]);
			}
			System.out.println();
		}
		
		
		
	}
}
