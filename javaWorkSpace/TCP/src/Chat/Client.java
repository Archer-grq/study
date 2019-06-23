package Chat;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;


/**
 * ���������ң��ͻ���
 * @author HASEE
 *
 */
public class Client {
	public static void main(String[] args) throws UnknownHostException, IOException {
		System.out.println("-----Client-----");
		BufferedReader console=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("�������û�����");
		String name=console.readLine();
		//��������
		Socket client=new Socket("localhost",8888);
		//�ͻ��˷���Ϣ
		new Thread(new Send(client,name)).start();
		new Thread(new Receive(client)).start();
	}
}
