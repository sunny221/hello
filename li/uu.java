package li;
class u implements Runnable {
	static Object chopsticks = new Object();   
	static Object knifeAndFork = new Object(); 
	private boolean flag; 
	void DeadLockThread(boolean flag) {
		this.flag = flag;
	}
	public void run() {
		if (flag) {
			while (true) {
				synchronized (chopsticks) { 
					System.out.println(Thread.currentThread().getName()
							+ "---if---chopsticks"); 
					synchronized (knifeAndFork) { 
						System.out.println(Thread.currentThread().getName()
								+ "---if---knifeAndFork"); 
					}
				}
			}
		} else {
			while (true) {
				synchronized (knifeAndFork) {
					System.out.println(Thread.currentThread().getName()
							+ "---else---knifeAndFork"); 
					synchronized (chopsticks) { 
						System.out.println(Thread.currentThread().getName()
								+ "---else---chopsticks"); 
					}
				}
			}
		}
	}
}
public class uu {
	public static void main(String[] args) {
		DeadLockThread d1 = new DeadLockThread(true);
		DeadLockThread d2 = new DeadLockThread(false);
		new Thread(d1, "Chinese").start();   
		new Thread(d2, "American").start(); 
	}
}
