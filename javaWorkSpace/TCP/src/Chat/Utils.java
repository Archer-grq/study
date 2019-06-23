package Chat;

import java.io.Closeable;
import java.io.IOException;

/**
 * 工具类
 * @author HASEE
 *
 */
public class Utils {
	/**
	 * 释放资源
	 */
	public static void close(Closeable... targets) {
		for(Closeable target:targets) {
			try {
				if(null!=target) {
					target.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
