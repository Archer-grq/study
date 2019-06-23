package S_C;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramSocket;
import java.net.SocketException;


public class UdpTalkClient {
	public static void main(String[] args) throws Exception {
		
		System.out.println("客户端启动中。。。。");
		DatagramSocket client =new DatagramSocket(7777);
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String data=reader.readLine();
		
		
	}

}
