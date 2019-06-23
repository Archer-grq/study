package STUDY_THREAD;

public class Text01 implements Runnable{
	//票数
	private int ticketNums=99;
	private boolean flag=true;
	
	@Override
	public void run() {
		while(flag) {
			text();
		}
	}
	private synchronized void text() {
		if(ticketNums<0) {
			flag=false;
			return;
		}
		try {
			Thread.sleep(20);//模拟延迟
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName()+"-->"+ticketNums--);
	
	}
	public static void main(String[] args) {
		//一个对象
		Text01 ah=new Text01();	
		//多个代理
		new Thread(ah,"老大").start();
		new Thread(ah,"老二").start();
		new Thread(ah,"老三").start();
		
	}
}
