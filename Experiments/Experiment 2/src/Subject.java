public interface Subject {

	public abstract void registerObserver(Shareholder holder);
	public abstract void deleteObserver(Shareholder holder);
	public abstract void notifyObserver();

}
