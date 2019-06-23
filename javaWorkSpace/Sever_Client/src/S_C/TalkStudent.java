package S_C;

public class TalkStudent {
	public static void main(String[] args) {
		new Thread(new TalkSend(7777, "localhost", 9999)).start();
		new Thread(new TalkReceieve(7778,"–°¿Ó")).start();
	}
}
