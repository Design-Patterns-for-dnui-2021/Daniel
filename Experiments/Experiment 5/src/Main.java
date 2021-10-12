
public class Main {
	
	public static void main(String[] args) {
		Chef chef = new Chef();
		Chicken chicken = new Chicken(chef);
		MuttonString mutton = new MuttonString(chef);
		Customer Daniel = new Customer(chicken, mutton);
		
		Daniel.chicken();
		Daniel.mutton();
	}
}
