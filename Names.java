class Sun{
	private static Sun INSTANCE=new Sun();
	private Sun(){
		System.out.println("̫���ڷ���");
		}
	public static Sun getInstance(){
		return INSTANCE;
	}
	
}
public class Names {

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		Sun s1=Sun.getInstance();
		Sun s2=Sun.getInstance();
		System.out.println(s1==s2);

	}

}
