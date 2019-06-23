package Chat;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * ���������ң������
 * @author HASEE
 *
 */
public class Sever {
	private static CopyOnWriteArrayList<Channle> all=new CopyOnWriteArrayList<Sever.Channle>();
	public static void main(String[] args) throws IOException {
		System.out.println("-----Sever-----");
		ServerSocket server =new ServerSocket(8888);
		while(true) {
			Socket client =server.accept();
			Channle c=new Channle(client);
			all.add(c);
			System.out.println(c.name+"������");
			new Thread(c).start();
		}
	}
	static class Channle implements Runnable{
		
		private DataInputStream dis;
		private DataOutputStream dos;
		private Socket client;
		private String name;
		private boolean isRunning;
		
		public Channle(Socket client) {
			this.client=client;
			try {
				dis = new DataInputStream(client.getInputStream());
				dos=new DataOutputStream(client.getOutputStream());
				isRunning=true;
				//��ȡ����
				this.name=receive();
				//��ӭ��ĵ���
				this.send("---��ӭ����������---");
				this.sendOthers("---��ӭ"+this.name+"����������---",true);
			} catch (IOException e) {
				release();
				e.printStackTrace();
			}
		}
		//������Ϣ
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
		//Ⱥ��
		//˽��Լ����ʽ@XXX:msg
		private void sendOthers(String msg,boolean isSys) {
			boolean isPrivate=msg.startsWith("@");
			if(isPrivate) {//˽��
				int index=msg.indexOf(":");
				//��ȡĿ������
				String targetName=msg.substring(1,index);
				msg=msg.substring(index+1);
				for(Channle other:all) {
					if(other.name.equals(targetName)) {
						other.send(this.name+"���ĵĶ���˵"+msg);
						break;
					}
				}
				
			}else {
				for(Channle other:all) {
					if(other==this) {
						continue;
					}
					if(!isSys) {
						other.send(name+"��������˵��"+msg);
					}else {
						other.send(msg);
					}
				}
			}
		}
		//������Ϣ
		private void send(String msg) {
			try {
				dos.writeUTF(msg);
				dos.flush();
			} catch (IOException e) {
				release();
				e.printStackTrace();
			}
		}
		//�ͷ���Դ
		private void release() {
			this.isRunning=false;
			Utils.close(dos,dis,client);
			all.remove(this);//�˳�������
			sendOthers(this.name+"�뿪��������", true);
		}
		@Override
		public void run() {
			while(isRunning) {
				String msg=receive();
				if(!msg.equals("")) {
					sendOthers(msg,false);
				}
			}
			
		}
	}

}



