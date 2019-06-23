package Test;

public class Emp {
	private int empno;
	private String name;
	public int getEmpno() {
		return empno;
	}
	public void sayHello(int a) {
		System.out.println(a);
	}
	public void setEmpno(int empno) {
		this.empno = empno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Emp(int empno, String name) {
		super();
		this.empno = empno;
		this.name = name;
	}
	public Emp() {
		super();
	}
	
}
