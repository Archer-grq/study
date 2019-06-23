package orm_test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
/**
 * 使用容器加数组封装数据
 * @author HASEE
 *
 */
public class Demo2 {
	public static void main(String[] args) {
		Connection conn=MysqlUtil.getSqlConnection();
		PreparedStatement ps=null;
		ResultSet rs=null;
		List<Object[]> list=new ArrayList<Object[]>();
		try {
			ps=conn.prepareStatement("select empname,salary,age from emp where id>? ");
			ps.setObject(1, 0);
			rs=ps.executeQuery();
			while(rs.next()) {
				Object[] objs=new Object[3];
				objs[0]=rs.getString(1);
				objs[1]=rs.getObject(2);
				objs[2]=rs.getObject(3);
				list.add(objs);
				}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			MysqlUtil.close(rs, ps, conn);
		}
		for(Object[] o:list) {
			for(Object ob:o) {
				System.out.println(ob);
			}
		}
	}
}
