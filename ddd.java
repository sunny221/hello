public class ddd {
	public static void main(String[] args){
		MyThread myThread=new MyThread();
		myThread.run();
		while (true) {
			System.out.println("Main����������");
		}
	}
}
class MyThread{
	public void run(){
		while (true){
			System.out.println("MyThread���run()����������");
		}
	}
}
