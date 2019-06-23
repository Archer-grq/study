package IO_STUDY;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

/**
 * 打印流
 * @author HASEE
 *
 */
public class Text07 {
	public static void main(String[] args) throws FileNotFoundException {
		PrintStream ps = System.out;
		ps.println("hello World!!");
		ps.println("你好世界！！");
		
		ps=new PrintStream(new BufferedOutputStream(new FileOutputStream("print.txt")),true);
		ps.println();
		ps.println("hello World!!");
		ps.println("你好世界！！");
		
		System.setOut(ps);
		System.out.println("hh");
		ps.close();
	}
}
