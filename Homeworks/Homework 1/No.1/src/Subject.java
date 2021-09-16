import java.util.ArrayList;

public abstract class Subject {
	private ArrayList<Observer> observers = new ArrayList<Observer>();
	
	public void registerObserver(Observer observer)
	{
		this.observers.add(observer);
	}
	
	public void deleteObserver(Observer observer)
	{
		this.observers.remove(observer);
	}
	
	public void notifyObserver()
	{
		for (var observer:observers)
		{
			observer.update();
		}
	}
}
