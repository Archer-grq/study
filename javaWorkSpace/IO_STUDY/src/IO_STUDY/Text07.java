package IO_STUDY;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

/**
 * ��ӡ��
 * @author HASEE
 *
 */
public class Text07 {
	public static void main(String[] args) throws FileNotFoundException {
		PrintStream ps = System.out;
		ps.println("hello World!!");
		ps.println("������磡��");
		
		ps=new PrintStream(new BufferedOutputStream(new FileOutputStream("print.txt")),true);
		ps.println();
		ps.println("hello World!!");
		ps.println("������磡��");
		
		System.setOut(ps);
		System.out.println("hh");
		ps.close();
	}
}
