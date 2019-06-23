package IO_STUDY;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;
/**
 * 封装完成的文件分割流
 * @author HASEE
 *
 */
public class Text08 {
	
	private File src;
	private String destdir;
	private List<String> destPaths=new ArrayList<String>();
	private int blockSize;
	private int size;
	
	public Text08(String src,String destdir,int blockSize) {
		this.src=new File(src);
		this.destdir=destdir;
		this.blockSize=blockSize;
		inhit();
	}
	//初始化
	private void inhit() {
		long len=this.src.length();
		this.size=(int)Math.ceil(len*1.0/blockSize);
		//路径
		for(int i=0;i<len;i++) {
			this.destPaths.add(this.destdir+"/"+i+"----"+this.src.getName());
		}
	}
	//分割
	public void split() throws IOException {
		long len=this.src.length();
		int beginpos=0;
		int actualSize=(int)(blockSize>len?len:blockSize);
		for(int i=0;i<size;i++) {
			beginpos=i*blockSize;
			if(i==size-1) {
				actualSize=(int)len;
			}else {
				actualSize=blockSize;
				len-=blockSize;
			}
			spiltDetail(beginpos, actualSize, i);
		}

	}
	
	public static void main(String[] args) throws IOException{
		Text08 ss=new Text08("src/IO_STUDY/Text04.java", "src", 512);
		ss.split();
	}
	private void spiltDetail(int beginSize,int actualSize,int i) throws IOException  {
		RandomAccessFile raf = new RandomAccessFile(this.src, "r");
		RandomAccessFile raf2=new RandomAccessFile(this.destPaths.get(i),"rw");
		
		raf.seek(beginSize);
		
		byte[] flush=new byte[128];
		int len=-1;
		while((len=raf.read(flush))!=-1) {
			if(actualSize>len) {
				raf2.write(flush,0,len);
				actualSize-=len;
			}else {
				raf2.write(flush,0,actualSize);
				break;
			}
		}
		
		raf2.close();
		raf.close();
	}
}
