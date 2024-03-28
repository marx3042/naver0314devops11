package day0326;

interface StudyInter {
	public void javaStudy();
	public void springStudy();
}

interface PlayInter{
	public void run();
	public void game();
}

class MyStudy implements StudyInter{

	@Override
	public void javaStudy() {
		// TODO Auto-generated method stub
		System.out.println("자바");
	}

	@Override
	public void springStudy() {
		// TODO Auto-generated method stub
		System.out.println("spring");
	}
	
}

class MyPlay implements PlayInter{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("run");
	}

	@Override
	public void game() {
		// TODO Auto-generated method stub
		System.out.println("game");
	}
	
}

public class Ex07_interface {
	public static void study(StudyInter s) {
		s.javaStudy();
		s.springStudy();
	}
	public static void play(PlayInter p) {
		p.run();
		p.game();
	}
	
	public static void main(String[] args) {
		study(new MyStudy());
		play(new MyPlay());
	}
}
