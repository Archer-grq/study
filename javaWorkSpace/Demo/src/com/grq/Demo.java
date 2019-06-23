package com.grq;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

public class Demo {
	public static void main(String[] args) throws Exception {
		//获取URL
//		URL url=new URL("https://jd.com");
		URL url=new URL("https://www.bilibili.com/");
		//下载资源
		InputStream is=url.openStream();
		BufferedReader bis=new BufferedReader(new InputStreamReader(is,"utf-8"));
		String msg=null;
		while(null!=(msg=bis.readLine())) {
			System.out.println(msg);
		}
		bis.close();
	}


}
