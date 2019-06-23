package Test;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;


import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;
import javassist.CtNewMethod;
import javassist.NotFoundException;

/**
 * 测试javassist的API
 * @author HASEE
 *
 */
public class Demo1 {
	/**
	 * 测试基本方法
	 * @throws Exception
	 */
	public static void test01() throws Exception {
		ClassPool pool=ClassPool.getDefault();
		CtClass cc=pool.get("Test.Emp");
		
		/*
		 * byte[] bb=cc.toBytecode(); for(byte b:bb) { System.out.print(b+" "); }
		 * System.out.println(bb.length); System.out.println(Arrays.toString(bb));
		 */
		System.out.println(cc.getName());
		System.out.println(cc.getSimpleName());
		System.out.println(cc.getSuperclass());//获得父类
		System.out.println(cc.getInterfaces());//获得接口
	}
	/**
	 * 测试产生新的方法
	 * @throws Exception 
	 */
	public static void test02() throws Exception {
		ClassPool pool=ClassPool.getDefault();
		CtClass cc=pool.get("Test.Emp");
		
		//CtMethod cm=CtNewMethod("",cc);
		CtMethod cm=new CtMethod(CtClass.intType, "add", new CtClass[]{CtClass.intType,CtClass.intType},cc);
		cm.setModifiers(Modifier.PUBLIC);
		cm.setBody("{System.out.println(\"javassist\");return $1+$2;}");
		cc.addMethod(cm);
		//使用反射调用该方法
		Class clazz=cc.toClass();
		Object obj=clazz.newInstance();
		Method method=clazz.getDeclaredMethod("add",int.class,int.class);
		Object result=method.invoke(obj,55,62);
		System.out.println(result);
		
		
	}
	
	public static void test03() throws Exception {
		ClassPool pool=ClassPool.getDefault();
		CtClass cc=pool.get("Test.Emp");
		
		CtMethod cm=cc.getDeclaredMethod("sayHello");
		cm.insertBefore("System.out.println(\"----start----\");");
		cm.insertAfter("System.out.println(\"----end----\");");
		
		//使用反射调用该方法
		Class clazz=cc.toClass();
		Object obj=clazz.newInstance();
		Method method=clazz.getDeclaredMethod("sayHello",int.class);
		method.invoke(obj,55);
		Emp e=new Emp();
		e.sayHello(36);
		
	}
	
	public static void main(String[] args) throws Exception {
		test03();
	}
}
