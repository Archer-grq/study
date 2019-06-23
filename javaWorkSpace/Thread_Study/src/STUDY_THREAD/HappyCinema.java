package STUDY_THREAD;

import java.util.ArrayList;
import java.util.List;

/**
 * 模拟影院购票系统 
 * @author HASEE
 *
 */
public class HappyCinema {
	public static void main(String[] args) {
		List<Integer> avible=new ArrayList<Integer>();
		avible.add(2);
		avible.add(5);
		avible.add(6);
		avible.add(8);
		avible.add(12);		
		List<Integer> seats1=new ArrayList<Integer>();
		seats1.add(2);
		seats1.add(5);
		seats1.add(6);
		List<Integer> seats2=new ArrayList<Integer>();
		seats2.add(2);
		seats2.add(8);
		seats2.add(6);
		Cinema cinema =new Cinema(avible, "孤独影院");
		new Thread(new Customer(cinema, seats1),"老大").start();;
		new Thread(new Customer(cinema, seats2),"老二").start();		
		
	}
}

class Cinema {
	private List<Integer> available;//可用位置
	private String name;//影院名称
	
	public Cinema(List<Integer> available, String name) {
		super();
		this.available = available;
		this.name = name;
	}
	//购票
	public boolean buyTickets(List<Integer> seats) {
		System.out.println("欢迎光临 <"+name+"> 当前票的位置有"+available);
		List<Integer> copy=new ArrayList<Integer>();
		copy.addAll(available);
		copy.removeAll(seats);
		if(copy.size()>(available.size()-seats.size())) {
			return false;
		}
		available=copy;
		return true;
		
	}
	
}
class Customer implements Runnable{
	Cinema cinema;
	List<Integer> seats;
	public Customer(Cinema cinema,List<Integer> seats) {
		this.cinema=cinema;
		this.seats=seats;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		synchronized (cinema) {
			boolean flag=cinema.buyTickets(seats);
			if(flag) {
				System.out.println(Thread.currentThread().getName()+"成功购买"+seats+"位置票");
			}else {
				System.out.println(Thread.currentThread().getName()+"购票失败！！位置不够!!");
			}
		}
		
	}
	
}
