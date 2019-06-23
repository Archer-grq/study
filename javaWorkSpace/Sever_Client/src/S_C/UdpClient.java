package S_C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

/**
 * ���Ͷ�
 *
 * 1��ʹ��DatagramSocket ָ���˿� �������Ͷ�
 * 2��׼������ һ��ת���ֽ�����
 * 3����װ��DatagramPacket��������Ҫָ��Ŀ�ĵ�
 * 4�����Ͱ��� send(DatagramPacket p)
 * 5���ͷ���Դ
 */
public class UdpClient {

    public static void main(String[] args) throws IOException {
        System.out.println("���ͷ������С�������");
        //ʹ��DatagramSocket ָ���˿� �������Ͷ�
        DatagramSocket client =new DatagramSocket(7777);
        //׼������ һ��ת���ֽ�����
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        
        while(true) {
        	String data =reader.readLine();
            byte[] datas=data.getBytes();
            //��װ��DatagramPacket��������Ҫָ��Ŀ�ĵ�
            DatagramPacket packet=new DatagramPacket(datas,0,datas.length,
                    new InetSocketAddress("localhost",9999));
            //���Ͱ��� send(DatagramPacket p)
            client.send(packet);
            if(data.equals("bye")) {
            	break;
            }
        }
        client.close();
        System.out.println("���Ͷ��ѹر�");
        
    }
}

