public abstract class Tv{
	public abstract void play();
}
public class HaierTv extends Tv{
	public void play(){
		system.out.println("This is HaierTv.");
	}
}
public class YejingTv extendsTv{
	public void play(){
		System.out.println("This is Yejing.");
	}
}
public class TvFactory{
	public static Tv produceTTv(String brand){
		if(brand.equals("YejingTv"))
			return new YejingTv();
		if(brand.equals("HaierTv"))
			return new HaierTv();
		return null;
	}
}
