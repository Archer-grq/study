package S_C;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class TalkReceieve implements Runnable{
	private DatagramSocket sever;
	private String form;
	public TalkReceieve(int port,String form) {
		this.form=form;
		try {
			sever=new DatagramSocket(port);
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public void run() {
		while(true) {
			byte[] container=new byte[1024*60];
			DatagramPacket packet=new DatagramPacket(container, 0,container.length);
			try {
				sever.receive(packet);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			byte[] datas=packet.getData();
			int len=packet.getLength();
			String data=new String(datas,0,len);
			System.out.println(form +":"+data);
			if(data.equals("bye")) {
				break;
			}
		}
		sever.close();
	}

}
