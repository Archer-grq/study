package IO_STUDY;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Date;

import javax.xml.crypto.Data;

/**
 * 对象输入输出流（序列化反序列化）
 * 只有带有接口 Serialization 才能序列化
 * @author HASEE
 *
 */
public class Text06 {
	
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		ByteArrayOutputStream baos=new ByteArrayOutputStream();
		ObjectOutputStream oos=new ObjectOutputStream(new BufferedOutputStream(baos));
		oos.writeObject(new User(25,"zhangsan",52));
		oos.writeObject(new Date());
		oos.flush();
		byte[] datas=baos.toByteArray();
		ObjectInputStream ois=new ObjectInputStream(new BufferedInputStream(new ByteArrayInputStream(datas)));
		Object ss=ois.readObject();
		System.out.println(ss);
		Object s=ois.readObject();
		System.out.println(s);
		
	}
	
}
class User implements Serializable{
	private int id;
	private String name;
	private int sex;
	public User(int id, String name, int sex) {
		super();
		this.id = id;
		this.name = name;
		this.sex = sex;
	}
	public String toString() {
		return "id:"+id+"name:"+name+"sex:"+sex;
	}
	
}