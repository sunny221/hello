package zouye;
import java.io.*;
import java.util.Random;

public class Storage {
	private String [] cells=new String[10];
	private int inPos,outPos;
	private int count;
	public synchronized void put(int rt) {
		try {
			while(count==cells.length) {
				this.wait();
			}
                               Thread.sleep(new Random().nextInt(100));
		cells[inPos]=String.valueOf(rt);
		System.out.println("��ǰϵͳ��������Ϊ"+count+";   "+cells[inPos]+"----�û���¼");
		inPos++;
		if(inPos==cells.length)
			inPos=0;
		count++;
		this.notify();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public synchronized void get() {
		try {
			while(count==0){
				this.wait();
				}
                                 Thread.sleep(new Random().nextInt(100));
		System.out.println("��ǰϵͳ��������Ϊ"+count+";   "+cells[outPos]+"----�˳���¼");
		outPos++;
		if(outPos==cells.length)
			outPos=0;
		count--;
		this.notify();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
