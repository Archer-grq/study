package S_C;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * 接收端
 *
 * 1、使用DatagramSocket 指定端口 创建接收端
 * 2、准备容器 封装成DatagramPacket包裹
 * 3、阻塞式接收包裹receive(DatagramPacket p)
 * 4、分析数据 byte[] getData()
 *                  getLength()
 * 5、释放资源
 */
public class UdpSever {
    public static void main(String[] args) throws Exception {
        System.out.println("接收方启动中。。。。");
        //使用DatagramSocket 指定端口 创建接收端
        DatagramSocket sever = new DatagramSocket(9999);
        while(true) {
        	//准备容器 封装成DatagramPacket包裹
            byte[] container=new byte[1024*60];
            DatagramPacket packet =new DatagramPacket(container,0,container.length);
            //阻塞式接收包裹receive(DatagramPacket p)
            sever.receive(packet);
            //分析数据
            byte[] datas=packet.getData();
            int len =packet.getLength();
            String d=new String(datas,0,len);
            System.out.println(d);
            if(d.equals("bye")) {
            	break;
            }
        }
        //释放资源
        sever.close();

    }
}
