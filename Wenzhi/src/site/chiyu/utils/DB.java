package site.chiyu.utils;

import java.lang.reflect.Field;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class DB {

	// 数据库连接所需字段配置
	private static String dirver = "com.mysql.jdbc.Driver";
	private static String url = "jdbc:mysql://127.0.0.1:3306/wenzhi1?characterEncoding=UTF-8";
	private static String username = "root";
	private static String password = "123456";

	private Connection con = null;
	private PreparedStatement pst = null;
	private ResultSet rs = null;

	private int affectLine = 0;

	/***
	 * 获取数据库连接
	 * 
	 * @return Connection
	 */
	public Connection getConnection() {

		try {
			Class.forName(dirver);
			return DriverManager.getConnection(url, username, password);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("数据库获取连接错误");
		}
		return null;

	}

	public int executeUpdate(String sql, Object... params) {

		try {
			con = this.getConnection();
			System.out.println("当前执行的sql语句为；" + sql);
			pst = con.prepareStatement(sql);

			for (int i = 0; i < params.length; i++) {
				pst.setObject(i + 1, params[i]);
			}
			affectLine = pst.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			this.closeAll();
		}

		return affectLine;
	}

	/***
	 * 用泛型、反射查询，并返回相应的对象实例
	 * 
	 * @param clazz
	 * @param sql
	 * @param params
	 * @return
	 */
	public <T> T executeQuery(Class<T> clazz, String sql, Object... params) {
		T bean = null;
		try {
			con = this.getConnection();
			pst = con.prepareStatement(sql);
			if (params != null) {
				for (int i = 0; i < params.length; i++) {
					pst.setObject(i + 1, params[i]);
					//System.out.println("params[i]"+params[i]);
				}
			}
			
			rs = pst.executeQuery();
			// ResultSetMetaData获得结果集的元数据
			ResultSetMetaData resultSetMetaData = rs.getMetaData();
			Map<String, Object> map = new HashMap<String, Object>();

			if (rs.next()) {
				for (int i = 1; i < resultSetMetaData.getColumnCount(); i++) {
					String columnLable = resultSetMetaData.getColumnLabel(i + 1);// 获取列名的别名
					Object columnValue = rs.getObject(i + 1);
					map.put(columnLable, columnValue);
				}
			}

			//System.out.println("--->数据库：" + map);
			if (map.size() > 0) {
				bean = (T) clazz.newInstance();
				for (Entry<String, Object> entry : map.entrySet()) {
					String fieldName = entry.getKey();
					//System.out.println("当前字段！"+fieldName);
					Object fieldValue = entry.getValue();
					Field field = clazz.getDeclaredField(fieldName);
					field.setAccessible(true);
					field.set(bean, fieldValue);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll();
		}

		return bean;
	}

	/***
	 * 查询多条数据，放到list中返回
	 * @param sql 查询的sql语句
	 * @param params 可变参数
	 * @return list
	 */
	public <T> List<T> executeList(Class<T> clazz,String sql,Object... params){
		List<T> list = new ArrayList<T>();
		try {
			con = this.getConnection();
			pst = con.prepareStatement(sql);
			if (params != null) {
				for (int i = 0; i < params.length; i++) {
					pst.setObject(i + 1, params[i]);
				}
			}

			rs = pst.executeQuery();
			ResultSetMetaData resultSetMetaData = rs.getMetaData();
			
			while (rs.next()) {
				T bean = null;
				Map<String, Object> map = new HashMap<>();
				for (int i = 1; i < resultSetMetaData.getColumnCount(); i++) {
					String columnLable = resultSetMetaData.getColumnLabel(i + 1);// 获取列名的别名
					Object columnValue = rs.getObject(i + 1);
					map.put(columnLable, columnValue);
					if (map.size() > 0) {
						bean = (T) clazz.newInstance();
						for (Entry<String, Object> entry : map.entrySet()) {
							String fieldName = entry.getKey();
							Object fieldValue = entry.getValue();
							Field field = clazz.getDeclaredField(fieldName);
							 field.setAccessible(true);
							field.set(bean, fieldValue);
						}
					
					}
				}
				list.add(bean);
				}
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		finally {
			closeAll();
		}
		return list;
	}
	
	/***
	 * 关闭打开的所有连接
	 */
	public void closeAll() {

		try {
			if (rs != null) {
				rs.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			if (pst != null) {
				pst.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			if (con != null)
				con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
