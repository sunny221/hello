package jihe;

import java.util.HashMap;

public class DBUtil {
	private static DBUtil instance = null;
	private HashMap<String,User> users = new HashMap<String,User>();
	
	private DBUtil(){
		
		User u1 = new User();
		u1.setCardId("12345601");
		u1.setCardPwd("111111");
		u1.setUserName("��ޱޱ");
		u1.setCall("12345678901");
		u1.setAccount(10000);
		users.put(u1.getCardId(), u1);
		
		User u2 = new User();
		u2.setCardId("12345602");
		u2.setCardPwd("222222");
		u2.setUserName("��ů");
		u2.setCall("12345678902");
		u2.setAccount(20000);
		users.put(u2.getCardId(), u2);
		
		User u3 = new User();
		u3.setCardId("12345603");
		u3.setCardPwd("333333");
		u3.setUserName("ϯ��");
		u3.setCall("12345678903");
		u3.setAccount(30000);
		users.put(u3.getCardId(), u3);
	}
	//����ʽ����ģʽ
	public static DBUtil getInstance(){
		if(instance == null){
			synchronized(DBUtil.class){
				if(instance == null){
					instance = new DBUtil();
				}
			}
		}
		return instance;
	}
	//�������п��Ż�ȡ��Ӧ�����˻�����Ϣ
	public User getUser(String cardId){
		User user = (User) users.get(cardId);
		return user;
	}
	//��ȡ�����˻�����Ϣ
	public HashMap<String, User> getUsers(){
		return users;
	}

}
