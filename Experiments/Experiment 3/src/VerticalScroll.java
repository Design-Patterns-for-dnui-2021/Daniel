public class VerticalScroll extends ScrollingWindow {

	public  VerticalScroll(WindowSystem windowSystem) {
		super(windowSystem);
	}
	
	@Override
	public int scrolloc() {
		return this.windowSystem.scrolloc() + 1;
	}
	
	@Override
	public void info() {
		this.windowSystem.info();
		System.out.println("This window is scrolling vertically.");
	}

}
