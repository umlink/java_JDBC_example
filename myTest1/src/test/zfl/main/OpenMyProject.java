package test.zfl.main;


import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import net.sf.json.JSONObject;

import test.zfl.jdbc.ADUS;
import test.zfl.utils.User;

/**
 * @author LINK
 *
 */
public class OpenMyProject {
	public OpenMyProject() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param args
	 */
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("hello world!******************************");
		String sql1 = "insert into users (name,pwd) values ('校长','123456') ";
		String sql2 = "delete from users where name='test1'";
		String sql3 = "update users set pwd='111' where name='校长'";
		String sql4 = "select * from users";
		
		String userString = "[{name:lili,pws:123},{name:hehe,pws:123},{name:haha,pws:123}]";
		userString = userString.replace("[", "").replace("]", ""); 
		System.out.println(userString);
		String objStr = "{'name':'{\"temp\":\"tempVal\"}','pwd':'333'}";
		
		JSONObject json1 = JSONObject.fromObject(objStr);
		JSONObject json2 = JSONObject.fromObject(json1.get("name"));
		String jsonStr = json2.toString();
		User user = new User();
		user.setName((String) json1.get("name"));
		user.setPwd((String) json1.get("pwd"));
		System.out.println(user);
		System.out.println(json2.get("temp"));
		System.out.println(jsonStr);
		
		
		//定时器---start---
//		Timer tm = new Timer();
//		tm.scheduleAtFixedRate(new TimerTask(){
//			int count = 0;
//			ADUS adus = new ADUS();
//			String sql1 = "insert into users (name,pwd) values ('校长','123456') ";
//			String sql2 = "delete from users where name='test1'";
//			String sql3 = "update users set pwd='111' where name='校长'";
//			String sql4 = "select * from users";
//			public void run() {
//				count += 1;
//				System.out.println(count);
//				adus.addTemp(sql1);
//				adus.updateTemp(sql3);
//				List<User> userList= adus.searchTemp(sql4);
//				System.out.println(userList);
//			}
//		}, 2000, 1);
		//定时器--end---
		
	}


}
