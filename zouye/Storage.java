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
		System.out.println("当前系统在线人数为"+count+";   "+cells[inPos]+"----用户登录");
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
		System.out.println("当前系统在线人数为"+count+";   "+cells[outPos]+"----退出登录");
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
