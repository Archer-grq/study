package orm_test;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

@SuppressWarnings("all")
public class MysqlUtil {

    static Properties pros=null;
    static{
        pros=new Properties();
        try {
            pros.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("db.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Connection getSqlConnection(){
        try {
            Class.forName(pros.getProperty("mySqlDrivers"));
            return DriverManager.getConnection(pros.getProperty("mySqlUrl"),
                    pros.getProperty("mySqlUser"),pros.getProperty("mySqlPwd"));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void close(ResultSet rs, PreparedStatement st,Connection conn){
        if(null!=rs){
            try {
                rs.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if(null!=st){
            try {
                st.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if(null!=conn){
            try {
                conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
