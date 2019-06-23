package IO_STUDY;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Text05 {
	
	public static void main(String[] args) throws IOException {
		ByteArrayOutputStream baos=new ByteArrayOutputStream();
		DataOutputStream dos=new DataOutputStream(baos);
		dos.writeInt(5584);
		dos.writeChar('µÄ');
		
		byte[] datas=baos.toByteArray();
		
		DataInputStream dis =new DataInputStream(new ByteArrayInputStream(datas));
		int data1=dis.readInt();
		System.out.println(data1);
		char n=dis.readChar();
		System.out.println(n);
	}
}
