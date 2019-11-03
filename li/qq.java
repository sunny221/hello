package li;
public class qq{
	public static void main(String[] args){
		q myThread=new q();
		myThread.start();
		while(true){
			System.out.println("main()方法在运行");
		}
	}
}
class q extends Thread{
	public void run(){
		while(true){
			System.out.println("MyThread类的run()方法在运行");
		}
	}
}
