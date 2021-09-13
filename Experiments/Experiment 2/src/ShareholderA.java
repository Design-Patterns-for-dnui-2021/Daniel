public class ShareholderA implements Shareholder {

	@Override
	public void update(double price, String name) {
		System.out.println(name + " stock price fluctuated by 5% or more!!");
		System.out.println("Price: " + price);
		System.out.println("Shareholder A make a decision.");
	}

}
