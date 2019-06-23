package Chat;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * 在线聊天室：服务端
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
			System.out.println(c.name+"已连接");
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
				//获取名称
				this.name=receive();
				//欢迎你的到来
				this.send("---欢迎进入聊天室---");
				this.sendOthers("---欢迎"+this.name+"加入聊天室---",true);
			} catch (IOException e) {
				release();
				e.printStackTrace();
			}
		}
		//接收消息
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
		//群聊
		//私聊约定格式@XXX:msg
		private void sendOthers(String msg,boolean isSys) {
			boolean isPrivate=msg.startsWith("@");
			if(isPrivate) {//私聊
				int index=msg.indexOf(":");
				//获取目标数据
				String targetName=msg.substring(1,index);
				msg=msg.substring(index+1);
				for(Channle other:all) {
					if(other.name.equals(targetName)) {
						other.send(this.name+"悄悄的对您说"+msg);
						break;
					}
				}
				
			}else {
				for(Channle other:all) {
					if(other==this) {
						continue;
					}
					if(!isSys) {
						other.send(name+"对所有人说："+msg);
					}else {
						other.send(msg);
					}
				}
			}
		}
		//发送消息
		private void send(String msg) {
			try {
				dos.writeUTF(msg);
				dos.flush();
			} catch (IOException e) {
				release();
				e.printStackTrace();
			}
		}
		//释放资源
		private void release() {
			this.isRunning=false;
			Utils.close(dos,dis,client);
			all.remove(this);//退出聊天室
			sendOthers(this.name+"离开了聊天室", true);
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



