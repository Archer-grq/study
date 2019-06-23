package S_C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

/**
 * 发送端
 *
 * 1、使用DatagramSocket 指定端口 创建发送端
 * 2、准备容器 一定转成字节数组
 * 3、封装成DatagramPacket包裹，需要指定目的地
 * 4、发送包裹 send(DatagramPacket p)
 * 5、释放资源
 */
public class UdpClient {

    public static void main(String[] args) throws IOException {
        System.out.println("发送方启动中。。。。");
        //使用DatagramSocket 指定端口 创建发送端
        DatagramSocket client =new DatagramSocket(7777);
        //准备容器 一定转成字节数组
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        
        while(true) {
        	String data =reader.readLine();
            byte[] datas=data.getBytes();
            //封装成DatagramPacket包裹，需要指定目的地
            DatagramPacket packet=new DatagramPacket(datas,0,datas.length,
                    new InetSocketAddress("localhost",9999));
            //发送包裹 send(DatagramPacket p)
            client.send(packet);
            if(data.equals("bye")) {
            	break;
            }
        }
        client.close();
        System.out.println("发送端已关闭");
        
    }
}

