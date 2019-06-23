package STUDY_THREAD;
/**
 * Ä£Äâ¹êÍÃÈüÅÜ
 * @author HASEE
 *
 */
interface ddd{
	void ff(int a);
}
public class Race implements Runnable {
	private String winer;
	@Override
	public void run() {
		for(int steps=1;steps<=100;steps++) {
				
			System.out.println(Thread.currentThread().getName()+"-->"+steps);
			if(gameOver(steps)) {
				break;
			}
				
		}
	}
	
	private boolean gameOver(int steps) {
		if(winer!=null){
			return true;
		}else if(steps==100){
			winer=Thread.currentThread().getName();
			System.out.println(Thread.currentThread().getName());
			return true;
		}else {
			return false;
		}
	}
	
	public static void main(String[] args) {
		/*Race race=new Race();
		new Thread(race,"ÎÚ¹ê").start();
		new Thread(race,"Ğ¡°×ÍÃ").start();
		new Thread(()->{
			for(int i=0;i<100;i++) {
				System.out.println("ssssssssssssssss"+i);
			}
		}).start();
		new Thread(()->{
			for(int i=0;i<100;i++) {
				System.out.println("tttttttttttttttttt"+i);
			}
		}).start();*/
		ddd a=(int d)->{
			System.out.println("hhhhh"+d);
		};
		a.ff(52);
		
	}
}
