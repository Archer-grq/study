package Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {
	public static void main(String[] args) {
		 Pattern p=Pattern.compile("\\w+");
		 Matcher m=p.matcher("dhfkjsdhj&&dkhnljs&jk");
		 while(m.find()) {
			 System.out.println(m.group());
		 }
	}
}
