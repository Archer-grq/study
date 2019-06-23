package sorm.util;
/**
 * 封装了字符串常用的操作
 * @author HASEE
 *
 */
public class StringUtils {
	/**
	 * 将字符串的首字母转化为大写
	 * @param str 字符串
	 * @return 首字母变为大写的字符串
	 */
	public static String firstCharToUpperCase(String str) {
		
		return str.toUpperCase().substring(0,1)+str.substring(1);
	}
}
