package cn.grq.mycollection;

import javax.management.RuntimeErrorException;

public class MyArrayList<E> {
	private Object[] elementData;
	private int size=0;
	
	private static final int DEAFALT_CAPACITY=10;
	
	
	public MyArrayList() {
		elementData=new Object[DEAFALT_CAPACITY];
	} 
	
	public MyArrayList(int capacity) {
		if(capacity<0) {
			throw new RuntimeException("容器长度不能为负数！");
		}else if(capacity==0) {
			elementData=new Object[DEAFALT_CAPACITY];
		}else {
			elementData=new Object[capacity];
		}
	}
	
	public void add(E obj) {
		//数组扩容
		if(size==elementData.length) {
			Object[] newArray =new Object[elementData.length+(elementData.length>>1)];
			System.arraycopy(elementData, 0, newArray, 0, elementData.length);
			elementData=newArray;
		}
		elementData[size++]=obj;
	}
	
	public E get(int index) {
		checkRange(index);
		return (E)elementData[index];
	}
	public void set(E element,int index) {
		checkRange(index);
		elementData[index]=element;
	}
	//检查索引是否正常
	public void checkRange(int index) {
		if(index<0||index>=size) {
			throw new RuntimeException("索引不合法!"+index);
		}
	}
	public String toString() {
		StringBuilder sb=new StringBuilder();
		sb.append("[");
		for(int i=0;i<size;i++) {
			sb.append(elementData[i]+",");
		}
		sb.setCharAt(sb.length()-1, ']');
		return sb.toString();
	}
	
	public void remove(E element) {
		for(int i=0;i<size;i++) {
			if(elementData[i].equals(element)) {
				remove(i);
			}
		}
	}
	
	public void remove(int index) {
		checkRange(index);
		int numMoved=size-index-1;
		if(numMoved>0) {
			System.arraycopy(elementData, index+1, elementData, index, numMoved);
		}
		
		elementData[size--]=null;
	}
	public int size() {
		return size;
	}
	public boolean isEmpty() {
		return size==0?true:false;
	}
	
	
	
	public static void main(String[] args) {
		MyArrayList<String> sl =new MyArrayList<String>(20);
		for(int i=0;i<40;i++) {
			sl.add("g"+i);
		}
		System.out.println(sl);
		sl.remove(15);
		sl.remove("g12");
		System.out.println(sl);
		System.out.println(sl.size);
		System.out.println(sl.isEmpty());
	}
}
