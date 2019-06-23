package Chat;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;


/**
 * 在线聊天室：客户端
 * @author HASEE
 *
 */
public class Client {
	public static void main(String[] args) throws UnknownHostException, IOException {
		System.out.println("-----Client-----");
		BufferedReader console=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("请输入用户名：");
		String name=console.readLine();
		//建立连接
		Socket client=new Socket("localhost",8888);
		//客户端发消息
		new Thread(new Send(client,name)).start();
		new Thread(new Receive(client)).start();
	}
}
