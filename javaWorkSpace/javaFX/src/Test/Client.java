package Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Client {
	public static void main(String[] args) throws IOException {
		BufferedReader br;
		while(true) {
			br=new BufferedReader(new InputStreamReader(System.in));
			String data=br.readLine();
			System.out.println(data);
		}
	}
}
