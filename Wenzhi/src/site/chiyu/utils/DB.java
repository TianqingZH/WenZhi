package site.chiyu.utils;

import java.sql.Connection;
import java.sql.DriverManager;

public class DB {

	/***
	 * 获取数据库连接
	 * @return Connection
	 */
	public static Connection getConnection() {
		
        try {
            Class.forName("com.mysql.jdbc.Driver");
            return DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/wenzhi?characterEncoding=UTF-8", "root",
                    "123456");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("数据库获取连接错误");
        }
        return null;
		
	}
}
