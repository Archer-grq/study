package IO_STUDY;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;


public class Text03 {
	public static void main(String[] args) {
		File old =new File("dext.txt");
		File copy=new File("copy.txt");
		InputStream is=null;
		OutputStream os=null;
		int len;
		try {
			is=new FileInputStream(old);
			os=new FileOutputStream(copy,true);
			byte[] b=new byte[5];
			while((len=is.read(b))!=-1) {
				os.write(b,0,len);
				os.flush();
			}
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
			if(is!=null) {
				try {
					is.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
