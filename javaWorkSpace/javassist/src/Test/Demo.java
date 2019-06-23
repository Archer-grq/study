package Test;

import javassist.CannotCompileException;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtConstructor;
import javassist.CtField;
import javassist.CtMethod;

/**
 * 测试javassist生成一个新的类
 * @author HASEE
 *
 */
public class Demo {
	public static void main(String[] args) throws Exception {
		ClassPool pool=ClassPool.getDefault();
		CtClass cc=pool.makeClass("User");
		
		//创建属性
		CtField c1=CtField.make("private int age;", cc);
		CtField c2=CtField.make("private String name;", cc);
		cc.addField(c1);
		cc.addField(c2);
		
		//创建方法
		CtMethod cm1=CtMethod.make("public void setName(String name){this.name=name;};", cc);
		CtMethod cm2=CtMethod.make("public void setAge(int age){this.age=age;};", cc);
		CtMethod cm3=CtMethod.make("public String getName(){return this.name;};", cc);
		CtMethod cm4=CtMethod.make("public int getAge(){return this.age;};",cc);
		cc.addMethod(cm1);
		cc.addMethod(cm2);
		cc.addMethod(cm3);
		cc.addMethod(cm4);
		
		//创建构造方法
		CtConstructor cct=new CtConstructor(new CtClass[] {CtClass.intType,pool.get("java.lang.String")},cc);
		cct.setBody("{this.age=$1;this.name=$2;}");
		cc.addConstructor(cct);
		
		cc.writeFile("F:/Object/javaWorkSpace/javassist/src/Test");
		System.out.println("生成类成功");
		
	}
}
