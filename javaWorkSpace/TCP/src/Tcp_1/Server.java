package Tcp_1;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * TCP服务端流程
 * 1、创建服务器
 * 2、指定端口 使用ServerScoket
 * 3、阻塞式等待连接 accept
 * 4、操作：输入输出流
 * 5、关闭服务器、
 *
 */
public class Server {
	public static void main(String[] args) throws IOException {
		System.out.println("----Server-----");
		ServerSocket server =new ServerSocket(7777);
		Socket client =server.accept();
		System.out.println("一个客户端建立了连接。。");
		DataInputStream dis=new DataInputStream(client.getInputStream());
		String data=dis.readUTF();
		System.out.println(data);
		dis.close();
		client.close();
		
	}
}
