package sorm.core;
/**
 * Mysql数据类型和java数据类型相互转化
 * @author HASEE
 *
 */
public class MysqlTypeConvertor implements TypeConvertor {

	@Override
	public String dbTypeToJavaType(String clumnType) {
		if("varchar".equalsIgnoreCase(clumnType)||"char".equalsIgnoreCase(clumnType)) {
			return "String";
		}else if("int".equalsIgnoreCase(clumnType)||
				 "tinyint".equalsIgnoreCase(clumnType)||
				 "smallint".equalsIgnoreCase(clumnType)||
				 "integer".equalsIgnoreCase(clumnType)){
			return "Integer";
		}else if("bigint".equalsIgnoreCase(clumnType)) {
			return "long";
		}else if("double".equalsIgnoreCase(clumnType)||"float".equalsIgnoreCase(clumnType)) {
			return "Double";
		}else if("clob".equalsIgnoreCase(clumnType)) {
			return "java.sql.Clob";
		}else if("blob".equalsIgnoreCase(clumnType)) {
			return "java.sql.Blob";
		}else if("date".equalsIgnoreCase(clumnType)) {
			return "java.sql.Date";
		}else if("time".equalsIgnoreCase(clumnType)) {
			return "java.sql.Time";
		}else if("timestamp".equalsIgnoreCase(clumnType)) {
			return "java.sql.Timestamp";
		}
		
		
		return null;
	}

	@Override
	public String javaTypeToDbType(String javaDataType) {
		// TODO Auto-generated method stub
		return null;
	}

}
