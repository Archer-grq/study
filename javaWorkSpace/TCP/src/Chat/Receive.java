package Chat;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;
/**
 * 封装成多线程：接收类
 * @author HASEE
 *
 */
public class Receive implements Runnable{
	private DataInputStream dis;
	private Socket client;
	private boolean isRunning;
	
	public Receive(Socket client) {
		this.client=client;
		try {
			dis=new DataInputStream(client.getInputStream());
			isRunning=true;
		} catch (IOException e) {
			release();
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		while(isRunning) {
			String msg=receive();
			if(!msg.equals("")) {
				System.out.println(msg);
			}
		}
	}
	private String receive() {
		String msg="";
		try {
			msg=dis.readUTF();
			
		} catch (IOException e) {
			release();
			e.printStackTrace();
		}
		return msg;
	}
	private void release() {
		isRunning=false;
		Utils.close(dis,client);
	}
}
