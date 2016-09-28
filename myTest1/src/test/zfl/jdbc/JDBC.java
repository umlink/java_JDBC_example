package test.zfl.jdbc;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class JDBC {
	static  String driver = null;
	static String dbUrl = null;
	static String username = null;
	static String password = null;
	static Connection con = null;
	//加载外部属性文件
	static{
		Properties prop = new Properties();
		try {
			InputStream in = new BufferedInputStream(new FileInputStream("resource/myTest1.ini"));
			prop.load(in);
			driver = prop.getProperty("driver");
			dbUrl = prop.getProperty("dbUrl");
			username = prop.getProperty("username");
			password = prop.getProperty("password");
			System.out.println("dbDriver:"+driver+"\n"+"dbUrl:"+dbUrl+"\n"+"username:"+username+"\n"+"password:"+password);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	static{
		try {
			Class.forName(driver);
			System.out.println("openSql");
		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
		}
	}
	public static Connection getCon(){
		try {
			con = DriverManager.getConnection(dbUrl, username, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
	public static void closeAll(Connection con,PreparedStatement pst,ResultSet rst){
		try {
			if(con != null) con.close();
			if(pst != null) pst.close();
			if(rst != null) rst.close();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
