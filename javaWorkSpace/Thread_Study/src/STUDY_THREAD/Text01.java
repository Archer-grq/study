package STUDY_THREAD;

public class Text01 implements Runnable{
	//Ʊ��
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
			Thread.sleep(20);//ģ���ӳ�
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName()+"-->"+ticketNums--);
	
	}
	public static void main(String[] args) {
		//һ������
		Text01 ah=new Text01();	
		//�������
		new Thread(ah,"�ϴ�").start();
		new Thread(ah,"�϶�").start();
		new Thread(ah,"����").start();
		
	}
}
