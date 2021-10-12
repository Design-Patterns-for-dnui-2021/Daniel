
public class Customer {
	private Waitress MuttonString, Chicken;
	
	Customer(Waitress MuttonString, Waitress Chicken) {
		this.MuttonString = MuttonString;
		this.Chicken = Chicken;
	}
	
	public void mutton() {
		MuttonString.order();
	}
	
	public void chicken() {
		Chicken.order();
	}
}
