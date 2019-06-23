package cn.grq.text;

import java.text.DateFormat;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class DateText {
	
	public static void main(String[] args) {
		System.out.println("请输入日期(例：2018-5-31)");
		Scanner scanner = new Scanner(System.in);
		String temp = scanner.nextLine();
		DateFormat d= new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date date=d.parse(temp);
			Calendar calender = new GregorianCalendar();
			calender.setTime(date);
			int now=calender.get(Calendar.DATE);
			calender.set(Calendar.DATE,1);
			int n=calender.getActualMaximum(Calendar.DAY_OF_MONTH);
			int w=calender.get(Calendar.DAY_OF_WEEK); 
			System.out.println("日\t一\t二\t三\t四\t五\t六");
			for(int i=1;i<w;i++) {
				System.out.print("\t");
			}
			for(int i=1;i<=n;i++) {
				if(i==now) {
					System.out.print("*");
				}
				System.out.print(i+"\t");
				int z=calender.get(Calendar.DAY_OF_WEEK);
				if(z==7) {
					System.out.println();
				}
				calender.add(Calendar.DATE, 1);
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
