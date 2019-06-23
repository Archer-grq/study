package S_C;

public class TalkTeacher {
	public static void main(String[] args) {
		new Thread(new TalkReceieve(9999,"п║уе")).start();
		new Thread(new TalkSend(6767, "localhost", 7778)).start();
	}
}
