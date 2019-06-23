package S_C;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * ���ն�
 *
 * 1��ʹ��DatagramSocket ָ���˿� �������ն�
 * 2��׼������ ��װ��DatagramPacket����
 * 3������ʽ���հ���receive(DatagramPacket p)
 * 4���������� byte[] getData()
 *                  getLength()
 * 5���ͷ���Դ
 */
public class UdpSever {
    public static void main(String[] args) throws Exception {
        System.out.println("���շ������С�������");
        //ʹ��DatagramSocket ָ���˿� �������ն�
        DatagramSocket sever = new DatagramSocket(9999);
        while(true) {
        	//׼������ ��װ��DatagramPacket����
            byte[] container=new byte[1024*60];
            DatagramPacket packet =new DatagramPacket(container,0,container.length);
            //����ʽ���հ���receive(DatagramPacket p)
            sever.receive(packet);
            //��������
            byte[] datas=packet.getData();
            int len =packet.getLength();
            String d=new String(datas,0,len);
            System.out.println(d);
            if(d.equals("bye")) {
            	break;
            }
        }
        //�ͷ���Դ
        sever.close();

    }
}
