package Tcp_1;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * TCP���������
 * 1������������
 * 2��ָ���˿� ʹ��ServerScoket
 * 3������ʽ�ȴ����� accept
 * 4�����������������
 * 5���رշ�������
 *
 */
public class Server {
	public static void main(String[] args) throws IOException {
		System.out.println("----Server-----");
		ServerSocket server =new ServerSocket(7777);
		Socket client =server.accept();
		System.out.println("һ���ͻ��˽��������ӡ���");
		DataInputStream dis=new DataInputStream(client.getInputStream());
		String data=dis.readUTF();
		System.out.println(data);
		dis.close();
		client.close();
		
	}
}
