package STUDY_THREAD;

import java.util.ArrayList;
import java.util.List;

/**
 * ģ��ӰԺ��Ʊϵͳ 
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
		Cinema cinema =new Cinema(avible, "�¶�ӰԺ");
		new Thread(new Customer(cinema, seats1),"�ϴ�").start();;
		new Thread(new Customer(cinema, seats2),"�϶�").start();		
		
	}
}

class Cinema {
	private List<Integer> available;//����λ��
	private String name;//ӰԺ����
	
	public Cinema(List<Integer> available, String name) {
		super();
		this.available = available;
		this.name = name;
	}
	//��Ʊ
	public boolean buyTickets(List<Integer> seats) {
		System.out.println("��ӭ���� <"+name+"> ��ǰƱ��λ����"+available);
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
				System.out.println(Thread.currentThread().getName()+"�ɹ�����"+seats+"λ��Ʊ");
			}else {
				System.out.println(Thread.currentThread().getName()+"��Ʊʧ�ܣ���λ�ò���!!");
			}
		}
		
	}
	
}
