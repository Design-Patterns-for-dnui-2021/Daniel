public abstract class ScrollingWindow implements WindowSystem {
	protected WindowSystem windowSystem;

	public ScrollingWindow(WindowSystem windowSystem) {
		this.windowSystem = windowSystem;
	}
	
	@Override
	public abstract int scrolloc();

	@Override
	public abstract void info();
}
