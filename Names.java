class Sun{
	private static Sun INSTANCE=new Sun();
	private Sun(){
		System.out.println("太阳在发光");
		}
	public static Sun getInstance(){
		return INSTANCE;
	}
	
}
public class Names {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		Sun s1=Sun.getInstance();
		Sun s2=Sun.getInstance();
		System.out.println(s1==s2);

	}

}
