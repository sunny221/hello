package Tim;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
class TelcomUser {
	private String phoneNumber;
	private String callTo;
	//private StringBuffer communicationRecords;
	
	private ArrayList communicationRecords;
	//private LinkedList communicationRecords;
	private TreeMap singleRecord;
	//private TreeSet communicationRecords;
	
	public TelcomUser(String phoneNumber) {
		this.phoneNumber = phoneNumber;
		//this.communicationRecords = new StringBuffer();
		this.communicationRecords = new ArrayList();
		//this.communicationRecords = new LinkedList();
		//this.communicationRecords = new HashSet();
		//this.communicationRecords = new TreeSet();
	}
	
	//ģ��ͨ����¼������
	void generateCommunicateRecord() {
		//�������ͨ����¼��Ŀ
		int recordNum = new Random().nextInt(10);
		for(int i = 0; i <= recordNum; i++) {
			//������ɵ�i��ͨ����¼
			//��ʼʱ�䣬��ǰʱ��֮ǰ��ĳ�����ʱ��
			
			// ��System.currentTimeMillis()��ȷ������
			long timeStart = System.currentTimeMillis() - new Random().nextInt(36000000);
			//����ʱ�俪ʼ���ʮ�����������һ��ʱ�䣬����һ����
			long timeEnd = timeStart + 60000 + new Random().nextInt(600000);
			
			//��Calendar��ȡ��ǰʱ��
			Calendar cal = Calendar.getInstance();
			//�����ȥ����Сʱ��10Сʱ���ڣ�
			cal.add(Calendar.HOUR, - new Random().nextInt(10));
			//��ö�Ӧ����
			this.singleRecord = new TreeMap();
			this.singleRecord.put("����",this.phoneNumber);
			this.singleRecord.put("��ʼʱ��",new Date(timeStart));
			this.singleRecord.put("����ʱ��",new Date(timeEnd));
			this.singleRecord.put("���к���", this.getCallToPhoneNumber());
			this.singleRecord.put("�Ʒ�",this.accountFee(timeStart, timeEnd));
			this.communicationRecords.add(this.singleRecord);
			
		}
	}
	
	//������ɱ��к��루����λ�����������
	private String getCallToPhoneNumber() {
		return "1380372" + String.valueOf(new Random().nextInt(10))
			 + String.valueOf(new Random().nextInt(10))
			 + String.valueOf(new Random().nextInt(10))
			 + String.valueOf(new Random().nextInt(10));
	}
	
	//ģ��ƷѰ취�����ַ�������ʽ���ر���4λС���ļƷѽ��
	private String accountFee(long timeStart, long timeEnd) {
		//ÿ�����շ�*Ԫ
		double feePerMinute = 0.2;
		//ͨ���������������������
		int minutes = Math.round((timeEnd - timeStart)/60000);
		double feeTotal = feePerMinute * minutes;
		return String.format("%.4f", feeTotal);
	}
	
	//��ӡͨ����¼
	void printDetails() {
		//��ȡȫ��ͨ����¼
		//String allRecords = this.communicationRecords.toString();
		//�ָ�ͨ����¼
		//String [] recordArray = allRecords.split(";");
		//ѭ���ָ��¼�ڵ�ÿһ����
		Iterator itRecords = this.communicationRecords.iterator(); 
		while(itRecords.hasNext()) {
			System.out.println("---------ͨ����¼�ָ���---------");
			this.singleRecord=((TreeMap)itRecords.next());
			Set entrySet=this.singleRecord.entrySet();
			Iterator itEntry=entrySet.iterator();
			while(itEntry.hasNext()){
				Map.Entry entry=(Map.Entry)itEntry.next();
				Object key=entry.getKey();
				Object value=entry.getValue();
				System.out.println(key+":"+value);
			}
			
		}
	}
}

