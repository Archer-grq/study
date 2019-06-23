package sorm.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


import sorm.bean.ColumnInfo;
import sorm.bean.JavaFieldSetGet;
import sorm.bean.TableInfo;
import sorm.core.DBManager;
import sorm.core.MysqlTypeConvertor;
import sorm.core.TableContext;

/**
 * 封装了生成java文件（源文件）常用的操作
 * @author HASEE
 *
 */
public class JavaFileUtils {
	/**
	 * 根据字段信息生成java属性信息 如：var name-->private String name;以及相应的set get 方法
	 * @param columnInfo 字段信息
	 * @param convertor 类型转化器
	 * @return java属性和set get方法源码
	 */
	public static JavaFieldSetGet creatFieldSetGetSRC(ColumnInfo columnInfo,MysqlTypeConvertor convertor) {
		
		JavaFieldSetGet jfgs=new JavaFieldSetGet();
		
		String javaFieldType=convertor.dbTypeToJavaType(columnInfo.getDataType());
		
		jfgs.setFieldInfo("\t private "+javaFieldType+" "+columnInfo.getName()+";\n");
		StringBuilder getSrc=new StringBuilder();
		getSrc.append("\t public "+javaFieldType+" get"+StringUtils.firstCharToUpperCase(columnInfo.getName())+"(){\n");
		getSrc.append("\t\treturn "+columnInfo.getName()+";\n");
		getSrc.append("\t }\n");
		jfgs.setGetInfo(getSrc.toString());
		
		StringBuilder setSrc=new StringBuilder();
		setSrc.append("\t public void set"+StringUtils.firstCharToUpperCase(columnInfo.getName())
					 +"("+javaFieldType+" "+columnInfo.getName()+"){\n");
		setSrc.append("\t\t this."+columnInfo.getName()+"="+columnInfo.getName()+";\n");
		setSrc.append("\t }\n");
		jfgs.setSetInfo(setSrc.toString());
		return jfgs;
	}
	
	/**
	 * 生成表对应的类文件
	 * @param tableInfo
	 * @param typeConvertor
	 */
	public static void creatJavaPoFile(TableInfo tableInfo,MysqlTypeConvertor typeConvertor) {
		String src=creatJavaSrc(tableInfo, typeConvertor);
		String srcPath=DBManager.getConf().getSrcPath()+"\\";
		String popackage=DBManager.getConf().getPoPackage().replaceAll("\\.", "/");
		File f=new File(srcPath+popackage);
		if(!f.exists()) {
			f.mkdirs();
		}
		
		BufferedWriter bw=null;
		
		try {
			bw=new BufferedWriter( new FileWriter(f.getAbsoluteFile()+"/"
						+StringUtils.firstCharToUpperCase(tableInfo.gettName())+".java"));
			bw.write(src);
			bw.flush();
			
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if(bw!=null) {
				try {
					bw.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		
	}
	
	/**
	 * 根据信息生成java源代码
	 * @param tableInfo 表信息
	 * @param typeConvertor 类型转化器
	 * @return java源代码
	 */
	public static  String creatJavaSrc(TableInfo tableInfo,MysqlTypeConvertor typeConvertor) {
		
		Map<String,ColumnInfo> colums=tableInfo.getColumsMap();
		List<JavaFieldSetGet> javaFields=new ArrayList<JavaFieldSetGet>();
		
		for(ColumnInfo co:colums.values()) {
			javaFields.add(creatFieldSetGetSRC(co,typeConvertor));
		}
		
		StringBuilder src=new StringBuilder();
		
	    //生成package语句
		src.append("package "+DBManager.getConf().getPoPackage()+";\n\n");
		//生成import语句
		src.append("import java.sql.*;\n");
		src.append("import java.util.*;\n");
		//生成类声明语句
		src.append("public class "+StringUtils.firstCharToUpperCase(tableInfo.gettName())+"{\n");
		//生成属性列表
		for(JavaFieldSetGet f:javaFields) {
			src.append(f.getFieldInfo());
		}
		//生成get set方法
		for(JavaFieldSetGet f:javaFields) {
			src.append(f.getGetInfo());
			src.append(f.getSetInfo());
		}
		//生成类结束语句
		
		src.append("}\n");
		System.out.println(src);
		return src.toString();
	}
	
	public static void main(String[] args) {
//		ColumnInfo mColumnInfo=new ColumnInfo("name", "varchar", 0);
//		JavaFieldSetGet javaFieldSetGet=creatFieldSetGetSRC(mColumnInfo,new MysqlTypeConvertor());
//		System.out.println(javaFieldSetGet);
		Map<String,TableInfo> map=TableContext.tables;
		for(TableInfo t:map.values()) {
//		JavaFileUtils.creatJavaPoFile(t, new MysqlTypeConvertor());
		System.out.println(t.gettName());	
		}
	}
	
}




