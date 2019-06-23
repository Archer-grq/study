package IO_STUDY;

import java.io.File;
import java.io.IOException;

public class TEXT01 {

	public static void getN(File file,int i) {
		
		if(file==null||!file.exists()) {
			return;
		}else {
			if(file.isDirectory()) {
				for(int e=0;e<i;e++) {
					System.out.print("-");
				}
				System.out.println(file.getName());
				File[] s=file.listFiles();
				for(File f:s) {
					getN(f, i+1);
				}
				
			}else if(file.isFile()){
				for(int e=0;e<i;e++) {
					System.out.print("-");
				}
				System.out.println(file.getName());
			}
		}
		
	}
	public static void main(String[] args) throws IOException {
		
		
		File ss=new File("F:/Object/javaWorkSpace/IO_STUDY/src");
		
		getN(ss, 0);
		
	}
	
}
