package cn.grq.linkedList;

public class MyHashMap<K,V>{

	Node<K,V>[] table;
	int size;
	
	public MyHashMap() {
		table=new Node[16];//长度一般定义成二的整数次幂
		
	}
	public void put(K key,V value) {
		
		Node<K,V> newNode=new Node<>();
		newNode.hash=myHash(key.hashCode(),table.length);
		newNode.key=key;
		newNode.value=value;
		newNode.next=null;
		
		boolean keyRepeat=false;
		
		Node<K,V> temp=table[newNode.hash];
		Node<K,V> lastN=null;
		
		if(temp==null) {
			table[newNode.hash]=newNode;
			size++;
		}else {
			while(temp!=null) {
				
				if(temp.key.equals(newNode.key)) {
					//key重复
					temp.value=newNode.value;
					keyRepeat=true;
					break;
				}else {
					//key不重复
					lastN=temp;
					temp=temp.next;
				}
				
			}
			if(!keyRepeat) {
				lastN.next=newNode;
				size++;
			}
			
		}
		
	}
	
	public int myHash(int v, int length) {
		return v&(length-1);//效果等价于v%(length-1)值不同,但效率更高
	}
	
	public String toString() {
		
		StringBuilder sb=new StringBuilder("{");
		for(int i=0;i<table.length;i++) {
			Node<K,V> temp=table[i];
			while(temp!=null) {
				sb.append(temp.key+":"+temp.value+",");
				temp=temp.next;
			}
		}
		sb.setCharAt(sb.length()-1, '}');
		return sb.toString();
	}
	
	public V get(K key) {
		int hash=myHash(key.hashCode(), table.length);
		V value=null;
		
		if(table[hash]!=null) {
			Node<K,V> temp=table[hash];
			while(temp!=null) {
				if(temp.key.equals(key)) {
					value=temp.value;
					break;
				}else {
					temp=temp.next;
				}
			}
		}
		
		return value;
	}
	
	
	
	public static void main(String[] args) {
		MyHashMap<Integer,String> m=new MyHashMap<>();
		m.put(10, "aaa");
		m.put(20, "bbb");
		m.put(30, "ccc");
		m.put(20, "ddd");
		m.put(85, "eee");
		m.put(69, "fff");
		m.put(53, "ggg");
		System.out.println(m);
		System.out.println(m.get(69));
		
		
	}
}
