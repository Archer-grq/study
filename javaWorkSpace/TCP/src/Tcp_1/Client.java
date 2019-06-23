package Tcp_1;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * TCP客户端流程
 * 1、创建客户端
 * 2、建立连接：使用Socket建立客户端+服务器的地址和端口
 * 3、操作：输入输出流
 * 4、释放资源
 *
 */
public class Client {
	public static void main(String[] args) throws UnknownHostException, IOException {
		
		System.out.println("----Client----");
		Socket client = new Socket("localhost",7777);
		DataOutputStream dos=new DataOutputStream(client.getOutputStream());
		dos.writeUTF("傻逼");
		dos.close();
		client.close();
	}

}
