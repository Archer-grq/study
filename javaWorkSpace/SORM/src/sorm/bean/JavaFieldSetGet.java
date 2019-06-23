package sorm.bean;

/**
 *  封装了java属性和get set方法的源代码
 * @author HASEE
 *
 */
public class JavaFieldSetGet {
	
	/**
	 * 属性的源码信息 如:private int a;
	 */
	private String fieldInfo;
	/**
	 * set方法的源码信息 如:public void setA(int a){this.a=a;};
	 */
	private String setInfo;
	/**
	 * get方法的原信息 如:public int getA(){return a;};
	 */
	private String getInfo;
	
	@Override
	public String toString() {
		System.out.println(fieldInfo);
		System.out.println(getInfo);
		System.out.println(setInfo);
		return super.toString();
	}
	public JavaFieldSetGet() {
	}
	public JavaFieldSetGet(String fieldInfo, String setInfo, String getInfo) {
		super();
		this.fieldInfo = fieldInfo;
		this.setInfo = setInfo;
		this.getInfo = getInfo;
	}
	public String getFieldInfo() {
		return fieldInfo;
	}
	public void setFieldInfo(String fieldInfo) {
		this.fieldInfo = fieldInfo;
	}
	public String getSetInfo() {
		return setInfo;
	}
	public void setSetInfo(String setInfo) {
		this.setInfo = setInfo;
	}
	public String getGetInfo() {
		return getInfo;
	}
	public void setGetInfo(String getInfo) {
		this.getInfo = getInfo;
	}
	
}
