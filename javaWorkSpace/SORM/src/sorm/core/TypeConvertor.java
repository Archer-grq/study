package sorm.core;
/**
 * 负责java类型和数据库类型的转化
 * @author HASEE
 *
 */
public interface TypeConvertor {
	
	/**
	 * 将数据库类型数据转化成java类型
	 * @param clumnType 数据库字段的类型
	 * @return java 的数据类型
	 */
	public String dbTypeToJavaType(String clumnType);
	
	/**
	 * 将java类型转化成数据库类型
	 * @param javaDataType java字段的类型
	 * @return 数据库类型
	 */
	public String javaTypeToDbType(String javaDataType);
}
