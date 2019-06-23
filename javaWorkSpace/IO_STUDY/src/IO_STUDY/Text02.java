package IO_STUDY;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * 
 * @author HASEE
 *
 */
public class Text02 {
	public static void main(String[] args) {
		File file=new File("text.txt");
		InputStream is=null;
		try {
			is = new FileInputStream(file);
			byte[] b=new byte[4];
			int len=-1;
			while((len=is.read(b))!=-1) {
				System.out.println(len+" ");
				String str=new String(b,0,len);
				System.out.println(str);
			}
			
			
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
	}
	
}
