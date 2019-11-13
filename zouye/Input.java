package zouye;
import java.util.Random;

public class Input implements Runnable{
	private Storage st;
	Random r=new Random();
	Input(Storage st){
		this.st=st;
	}
	public void run() {
		while(true) {
			st.put(r.nextInt(100));
		}
	}

}