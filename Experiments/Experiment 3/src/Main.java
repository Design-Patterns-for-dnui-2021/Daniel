
public class Main {
	
	public static void main(String[] args) {

		WindowSystem window1 = new Window();
		window1 = new VerticalScroll(window1);
		window1 = new HorizontalScroll(window1);
		window1 = new HorizontalScroll(window1);
		window1.info();
		System.out.println("Scroll location: " + window1.scrolloc());
	}

}
