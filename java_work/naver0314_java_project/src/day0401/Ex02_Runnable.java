package day0401;

public class Ex02_Runnable implements Runnable{
	private String threadName;
	private int count;
	
	public Ex02_Runnable(String threadName, int count) {
		this.threadName = threadName;
		this.count = count;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		for(int i = 1; i <= count; i++) {
			System.out.println(threadName + ":" + i);
		}
	}
	
	public static void main(String[] args) {
		Ex02_Runnable a = new Ex02_Runnable("1번", 300);
		Ex02_Runnable b = new Ex02_Runnable("2번", 300);
		Ex02_Runnable c= new Ex02_Runnable("3번", 300);
		
		Thread th1 = new Thread(a);
		Thread th2 = new Thread(b);
		Thread th3 = new Thread(c);
		
		th1.start();
		th2.start();
		th3.start();
	}
}
