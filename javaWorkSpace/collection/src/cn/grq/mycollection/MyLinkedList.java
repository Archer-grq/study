package cn.grq.mycollection;

//自定义链表
public class MyLinkedList {

	private Node first;
	private Node last;
	
	private int size=0;
	
	public void add(Object obj) {
		Node node =new Node(obj);
		
		if(first==null){
			
			first=node;
			last=node;
		}else {
			node.previous=last;
			node.next=null;
			last.next=node;
			last=node;
		}
		size++;
	}
	public String toString() {
		StringBuilder sb=new StringBuilder("[");
		
		//链表的遍历
		Node temp=first;
		while(temp!=null) {
			sb.append(temp.element+",");
			temp=temp.next;
		}
		sb.setCharAt(sb.length()-1, ']');
		
		return sb.toString();
	}
	public Object get(int index) {
		checkRange(index);
		Node temp=null;
		if(index<(size>>1)) {
			temp=first;
			for(int i=0;i<index;i++) {
				temp=temp.next;
			}
		}else {
			temp=last;
			for(int i=size-1;i>index;i--) {
				temp=temp.previous;
			}
		}
		
		return temp.element;
	}
	public void set(Object obj,int index) {
		checkRange(index);
		
		getNode(index).element=obj;
	}
	public void remove(int index) {
		checkRange(index);
		if(index==0) {
			first=first.next;
		}else if(index==size-1) {
			last=last.previous;
			last.next=null;
		}else {
			Node temp=getNode(index);
			temp.previous.next=temp.next;
			temp.next.previous=temp.previous;
		}
		
	}
	
	private Node getNode(int index) {
		Node temp=null;
		if(index<(size>>1)) {
			temp=first;
			for(int i=0;i<index;i++) {
				temp=temp.next;
			}
		}else {
			temp=last;
			for(int i=size-1;i>index;i--) {
				temp=temp.previous;
			}
		}
		return temp;
	}
	private void checkRange(int index) {
		if(index<0||index>size-1) {
			throw new RuntimeException("索引值不在范围！！");
		}
	}
	
	public static void main(String[] args) {
		
		MyLinkedList list=new MyLinkedList();
		list.add("aaa");
		list.add("bbb");
		list.add("ccc");
		list.add("ddd");
		list.add("eee");
		list.add("fff");
		list.add("ggg");
		list.add("hhh");

		System.out.println(list);
		System.out.println(list.get(7));
		list.set("啊", 2);
		list.remove(0);
		System.out.println(list);
	}
}
