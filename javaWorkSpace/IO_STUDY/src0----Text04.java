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
	