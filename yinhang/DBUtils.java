package yinhang;
import java.util.HashMap;
import java.io.*;

public class DBUtils {
	private static DBUtils instance = null;
	public static HashMap<String,User> users = new HashMap<String,User>();
	
	private DBUtils() throws NumberFormatException, IOException{
		FileReader  ab = new FileReader("data.txt");
		BufferedReader ac = new BufferedReader(ab);
		String str;
		while((str=ac.readLine())!=null){
			String x1 []=str.split(",");
			User u1=new User();
			u1.setCardId(x1[0]);
			u1.setCardPwd(x1[1]);
			u1.setUserName(x1[2]);
			u1.setCall(x1[3]);
			u1.setAccount(Integer.parseInt(x1[4]));
			users.put(u1.getCardId(), u1);
		}
		ab.close();
	}
	public static DBUtils getInstance1() throws NumberFormatException, IOException{
		if(instance ==null){
			synchronized(DBUtils.class){
				if(instance == null){
					instance = new DBUtils();
				}
			}
		}
		return instance;
	}
	public User getUser(String cardId){
		User user = (User)users.get(cardId);
		return user;
	}
	public HashMap<String,User>getUsers(){
		return users;
	}
	public static DBUtils getInstance() {
		
		return null;
	}

}
