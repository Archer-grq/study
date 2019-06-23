package IO_STUDY;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Text04 {
	public static void main(String[] args) {
		
		byte[] b=fileToByteArray("src/image/3.jpg");
		System.out.println(b.length);
		byteArrayToFile(b, "5.jpg");
		
		
	}
	public static byte[] fileToByteArray(String path) {
		File file=new File(path);
		InputStream is=null;
		ByteArrayOutputStream baos=null;
		int len=-1;
		try {
			is=new FileInputStream(file);
			baos=new ByteArrayOutputStream();
			
			byte[] temp=new byte[1024];
			while((len=is.read(temp))!=-1) {
				baos.write(temp,0,len);
			}
			baos.flush();
			return baos.toByteArray();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(is!=null) {
				try {
					is.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return null;
	}
	
	public static void byteArrayToFile(byte[] b,String path) {
		File file=new File(path);
		OutputStream os=null;
		InputStream btis=null;
		
		try {
			os=new FileOutputStream(file);
			btis=new ByteArrayInputStream(b);
			int len=-1;
			byte[] falsh=new byte[10];
			while((len=btis.read(falsh))!=-1) {
				os.write(falsh,0,len);
			}
			os.flush();
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(os!=null) {
				try {
					os.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	

}