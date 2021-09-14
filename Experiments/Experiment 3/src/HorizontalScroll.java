public final class HorizontalScroll extends ScrollingWindow {

	public HorizontalScroll(WindowSystem windowSystem) {
		super(windowSystem);
	}

	public int scrolloc() {
		return this.windowSystem.scrolloc() + 1;
	}
	@Override
	public void info() {
		this.windowSystem.info();
		System.out.println("This window is scrolling horizontally.");
	}

}
