package test.zfl.jdbc;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import test.zfl.utils.User;

public class ADUS {
	/*
	 * add
	 */
	private String warn=null;
	public boolean addTemp(String sql){
		Connection con = null;
		PreparedStatement pst = null;
		try {
			con = JDBC.getCon();
			pst = con.prepareStatement(sql);
			pst.executeUpdate();
			warn = "save data success!";
		} catch (Exception e) {
			warn = "save data error!";
		}finally{
			JDBC.closeAll(con, pst, null);
		}
		System.out.println(warn);
		return true;
	}
	/*
	 * delete
	 */
	public boolean deleteTemp(String sql){
		Connection con = JDBC.getCon();
		PreparedStatement pst = null;
		try {
			con = JDBC.getCon();
			pst = con.prepareStatement(sql);
			pst.executeUpdate();
			warn = "delete data success!";
		} catch (Exception e) {
			warn = "delete data error!";
		} finally{
			JDBC.closeAll(con, pst, null);
		}
		System.out.println(warn);
		return true;
	}
	/*
	 * update
	 */
	public boolean updateTemp(String sql){
		Connection con = JDBC.getCon();
		PreparedStatement pst = null;
		try {
			con = JDBC.getCon();
			pst = con.prepareStatement(sql);
			pst.executeUpdate();
			warn = "update data success!";
		} catch (Exception e) {
			warn = "update data error!";
		} finally{
			JDBC.closeAll(con, pst, null);
		}
		System.out.println(warn);
		return true;
	}
	/*
	 * search
	 */
	public List<User> searchTemp(String sql){
		String warn = null;
		Connection con = JDBC.getCon();
		PreparedStatement pst = null;
		ResultSet rst = null;
		List<User> userList = new ArrayList<User>();
		try {
			con = JDBC.getCon();
			pst = con.prepareStatement(sql);
			rst = pst.executeQuery();
			while(rst.next()){
				User user = new User();
				user.setName(rst.getString("name"));
				user.setPwd(rst.getString("pwd"));
				userList.add(user);
			}
			warn = "search data success!";
		} catch (Exception e) {
			warn = "search data error!";
		} finally{
			JDBC.closeAll(con, pst, rst);
		}
		System.out.println(warn);
		return userList;
	}
}
