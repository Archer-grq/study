
public class User {
	int id;
	String name;
	String psd;
	User(){
		
	}
	public User(int id,String name) {
		this.id=id;
		this.name=name;
	}
	public void changeName(User u) {
		u.name="搞笑吧";
	}
	static {
		System.out.println("我最帅");
	}
	public void changeName2(User u) {
		u=new User(200,"张三");
		hello();
	}
	public static void hello() {
		System.out.println("我是世界上最帅的人");
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		User u=new User(100,"老师");
		System.out.println(u.name+"\n"+u.id);
		u.changeName(u);
		System.out.println(u.name+"\n"+u.id);
		u.changeName2(u);
		System.out.println(u.name+"\n"+u.id);
		hello();
		User help=new User();
		help.id=102;
		System.out.println(help.id);
		{
			int a=3;
			System.out.println(a);
		}
		System.out.println(help.toString());
	
	}

}
