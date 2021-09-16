
public class Person extends Subject implements Observer, Member {
	private String name;
	
	Person(String name)
	{
		this.name = name;
	}
	
	@Override
	public void action()
	{
		System.out.println(this.name + " avenges the attacked teammate!");
	}
	
	@Override
	public void update()
	{
		this.action();
	}
	
	public void beat()
	{
		System.out.println(this.name + " got attacked!");
		this.notifyObserver();
		System.out.println("");
	}
}
