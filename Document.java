package xian;

public class Document {

	public static void main(String[] args) {
		DocWindows dw=new DocWindows();
		new Thread(dw,"线程1").start();
		new Thread(dw,"线程2").start();
		new Thread(dw,"线程3").start();
		new Thread(dw,"线程4").start();
	}

}
class DocWindows implements Runnable{
	private int document[]=new int[8];
	public void run() {
		while(true) {
			for(int i=0;i<document.length;i++) {
				Thread th=Thread.currentThread();
				String th_name=th.getName();
				
				System.out.println(th_name+"正在下载第"+i+"段文件");
			}
		}
	}
	
}
