package Tcp_1;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * TCP�ͻ�������
 * 1�������ͻ���
 * 2���������ӣ�ʹ��Socket�����ͻ���+�������ĵ�ַ�Ͷ˿�
 * 3�����������������
 * 4���ͷ���Դ
 *
 */
public class Client {
	public static void main(String[] args) throws UnknownHostException, IOException {
		
		System.out.println("----Client----");
		Socket client = new Socket("localhost",7777);
		DataOutputStream dos=new DataOutputStream(client.getOutputStream());
		dos.writeUTF("ɵ��");
		dos.close();
		client.close();
	}

}
