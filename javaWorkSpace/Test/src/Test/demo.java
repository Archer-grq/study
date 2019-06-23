package Test;
import java.math.BigInteger;
import java.util.Scanner;


public class demo {
	
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		int n=scanner.nextInt();
	    BigInteger sum=BigInteger.ONE;
	    
	    for(int i=1;i<=n;i++){
	      sum=sum.multiply(BigInteger.valueOf(i));
	    }
	    char [] s=sum.toString().toCharArray();
	    
	    for(int i=0;i<s.length;i++){
	    	if(i%50==0) {
	    		System.out.println();
	    	}
	    	System.out.print(s[i]);
	    }
	}
	
}
