package Tim;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
class TelcomUser {
	private String phoneNumber;
	private String callTo;
	private ArrayList communicationRecords;
	public TelcomUser(String phoneNumber) {
		this.phoneNumber = phoneNumber;
		this.communicationRecords = new ArrayList();
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
		int arrayListSize=this.communicationRecords.size();
		for(int i = 0; i < arrayListSize-1; i++) {
			System.out.println("---------通话记录分割线---------");
			String [] recordField = ((String)this.communicationRecords.get(i)).split(",");
			System.out.println("主叫：" + recordField[0]);
			System.out.println("被叫：" + recordField[3]);
			Date timeStart = new Date(Long.parseLong(recordField[1]));
			Date timeEnd = new Date(Long.parseLong(recordField[2]));
			DateFormat mediumFormat = DateFormat.getDateTimeInstance(DateFormat.MEDIUM, DateFormat.MEDIUM);
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日 hh时mm分ss秒");
			//DateFormat
			/*
			System.out.println("通话开始时间：" + mediumFormat.format(timeStart));
			System.out.println("通话结束时间：" + mediumFormat.format(timeEnd));
			*/
			
			//SimpleDateFormat			
			System.out.println("通话开始时间：" + mediumFormat.format(timeStart));
			System.out.println("通话结束时间：" + mediumFormat.format(timeEnd));
			
			System.out.println("计费：" 
					+ accountFee(Long.parseLong(recordField[1]), Long.parseLong(recordField[2]))
					+ " 元。");
		}
	}
}