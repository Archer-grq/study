package Chat;

import java.io.Closeable;
import java.io.IOException;

/**
 * ������
 * @author HASEE
 *
 */
public class Utils {
	/**
	 * �ͷ���Դ
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
