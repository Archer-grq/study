
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
		u.name="��Ц��";
	}
	static {
		System.out.println("����˧");
	}
	public void changeName2(User u) {
		u=new User(200,"����");
		hello();
	}
	public static void hello() {
		System.out.println("������������˧����");
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		User u=new User(100,"��ʦ");
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