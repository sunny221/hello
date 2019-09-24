public abstract class Tv{
	public abstract void play();
}
public class HaierTv extends Tv{
	public void play(){
		System.out.println("This is HaierTv.");
	}
}
public class YejingTv extends Tv{
	public void play(){
		System.out.println("This is YejingTv.");
	}
}
public interface TVFactory{
	public TV produceTV();
}
public class HaierTVFactory implements TVFactory{
	public TV produceTV(){
		return new HaierTV();
	}
}
public class YejingTVFactory implements TVFactory{
	public TV produceTV(){
		return new YejingTV();
	}
}
