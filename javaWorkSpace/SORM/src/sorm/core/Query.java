package sorm.core;
/**
 * 负责查询（对外提供核心类）
 * @author AnBOY
 *
 */

import java.util.List;


public interface Query {
	
	/**
	 * 执行一条DML语句
	 * @param sql SQL语句
	 * @param params 参数
	 * @return 执行SQL语句后影响记录的行数
	 */
	public int executeDML(String sql,Object[] params);
	
	/**
	 * 将一个对象存到数据库中
	 * @param obj 要存储的bean对象
	 */
	public void insert(Object obj);
	
	/**
	 * 删除clzz表示的类对应的表的记录（指定主键ID的值）
	 * @param clzz 跟表对应类的class对象
	 * @param id 主键ID
	 */
	public void delete(Class clzz,int id);
	
	/**
	 * 删除对象在数据库中对应的记录（对象所在的类类对应表，对象的主键值对应到记录）
	 * @param obj 需要操作的对象
	 */
	public void delete(Object obj);
	
	/**
	 * 更新对象对应的记录，并且只更新指定字段的值
	 * @param obj 需要更新的对象
	 * @param filedName 更新的属性的列表
	 * @return 执行SQL语句影响记录的行数
	 */
	public int update(Object obj,String[] filedName);
	
	/**
	 * 查询返回多条记录，并将每条记录封装到clzz指定的类的对象中
	 * @param sql 查询语句
	 * @param clzz 封装数据的javabean类的Class对象
	 * @param params sql的参数
	 * @return 查询到的结果
	 */
	public List queryRows(String sql,Class clzz,Object[] params);
	
	/**
	 * 查询返回一条记录，并将记录封装到clzz指定的类的对象中
	 * @param sql 查询语句
	 * @param clzz 封装数据的javabean类的Class对象
	 * @param params sql的参数
	 * @return 查询到的结果
	 */
	public List queryUniqueRows(String sql,Class clzz,Object[] params);
	
	/**
	 * 查询返回一个值(一行一列)，并将值返回
	 * @param sql 查询语句
	 * @param params sql的参数
	 * @return 查询到的结果
	 */
	public Object queryValue(String sql,Object[] params);

	/**
	 * 查询返回一个数(一行一列)，并将值返回
	 * @param sql 查询语句
	 * @param params sql的参数
	 * @return 查询到的数值
	 */
	public Number queryNumber(String sql,Object[] params);
}









