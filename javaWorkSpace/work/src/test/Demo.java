package test;

import java.io.File;

import org.apache.commons.io.FileUtils;

public class Demo {
	
	public static void main(String[] args) {
		File f=new File("F:\\Object\\javaWorkSpace\\IO_STUDY\\src0----Text04.java");
		//文件大小
		long len=FileUtils.sizeOf(f);
		System.out.println(len);
		//文档大小
		len=FileUtils.sizeOf(new File("F:\\Object\\javaWorkSpace\\IO_STUDY\\src0----Text04.java"));
		System.out.println(len);
	

	}
}
