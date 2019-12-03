package Tim;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
class TelcomUser {
	private String phoneNumber;
	private String callTo;
	private HashSet communicationRecords;
	public TelcomUser(String phoneNumber) {
		this.phoneNumber = phoneNumber;
		this.communicationRecords = new HashSet();
	}
	void generateCommunicateRecord() {
		int recordNum = new Random().nextInt(10);
		for(int i = 0; i <= recordNum; i++) {
			Calendar cal = Calendar.getInstance();
			cal.add(Calendar.HOUR, - new Random().nextInt(10));
			long timeStart = cal.getTimeInMillis();
			long timeEnd = timeStart + 60000 + new Random().nextInt(600000);
			this.callTo = getCallToPhoneNumber();
			this.communicationRecords.add(this.phoneNumber + 
					"," + timeStart + 
					"," + timeEnd + 
					"," + this.callTo);
		}
	}
	private String getCallToPhoneNumber() {
		return "1380372" + String.valueOf(new Random().nextInt(10))
			 + String.valueOf(new Random().nextInt(10))
			 + String.valueOf(new Random().nextInt(10))
			 + String.valueOf(new Random().nextInt(10));
	}
	private String accountFee(long timeStart, long timeEnd) {
		double feePerMinute = 0.2;
		int minutes = Math.round((timeEnd - timeStart)/60000);
		double feeTotal = feePerMinute * minutes;
		return String.format("%.4f", feeTotal);
	}
	void printDetails() {
		Iterator it = this.communicationRecords.iterator();
		while (it.hasNext()){
			System.out.println("---------ͨ����¼�ָ���---------");
			String [] recordField = ((String)it.next()).split(",");
			System.out.println("���У�" + recordField[0]);
			System.out.println("���У�" + recordField[3]);
			Date timeStart = new Date(Long.parseLong(recordField[1]));
			Date timeEnd = new Date(Long.parseLong(recordField[2]));
			DateFormat mediumFormat = DateFormat.getDateTimeInstance(DateFormat.MEDIUM, DateFormat.MEDIUM);
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy��MM��dd�� hhʱmm��ss��");
			//DateFormat
			/*
			System.out.println("ͨ����ʼʱ�䣺" + mediumFormat.format(timeStart));
			System.out.println("ͨ������ʱ�䣺" + mediumFormat.format(timeEnd));
			*/
			
			//SimpleDateFormat			
			System.out.println("ͨ����ʼʱ�䣺" + mediumFormat.format(timeStart));
			System.out.println("ͨ������ʱ�䣺" + mediumFormat.format(timeEnd));
			
			System.out.println("�Ʒѣ�" 
					+ accountFee(Long.parseLong(recordField[1]), Long.parseLong(recordField[2]))
					+ " Ԫ��");
		}
	}
}