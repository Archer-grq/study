package Chat;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;


/**
 * ��װ�ɶ��̣߳�������
 * @author HASEE
 *
 */
public class Send implements Runnable {
	private BufferedReader console;
	private DataOutputStream dos;
	private Socket client;
	private String name;
	private boolean isRunning;
	
	
	public Send(Socket client,String name) {
		this.client=client;
		this.name=name;
		console=new BufferedReader(new InputStreamReader(System.in));
		try {
			dos=new DataOutputStream(client.getOutputStream());
			
			isRunning=true;
			//��������
			send(this.name);
		} catch (IOException e) {
			release();
			e.printStackTrace();
		}
	}
	@Override
	public void run() {
		while(isRunning) {
			String msg=getStrFormConsole();
			if(!msg.equals("")) {
				send(msg);
			}
		}
	}
	private void send(String msg) {
		try {
			dos.writeUTF(msg);
			dos.flush();
		} catch (IOException e) {
			release();
			e.printStackTrace();
		};
	}
	//�ӿ���̨��ȡ����
	private String getStrFormConsole() {
		try {
			return console.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}
	private void release() {
		this.isRunning=false;
		Utils.close(dos,client);
	}
}
