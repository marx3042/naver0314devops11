package day0401;

public class Ex01_Thread extends Thread{
	private String threadName;
	private int count;
	
	public Ex01_Thread(String threadName, int count) {
		this.threadName = threadName;
		this.count = count;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		
		for(int i = 1; i <= count; i++) {
			System.out.println(threadName + ":" + i);
		}
	}
	
	public static void main(String[] args) {
		Ex01_Thread a = new Ex01_Thread("1번", 10);
		Ex01_Thread b = new Ex01_Thread("2번", 10);
		Ex01_Thread c = new Ex01_Thread("3번", 10);
		a.run();
		b.run();
		c.run();
	}
}
