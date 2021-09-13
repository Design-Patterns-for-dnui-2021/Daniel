import java.util.ArrayList;

public class Stocks implements Subject {
	private ArrayList<Shareholder> shareholders = new ArrayList<Shareholder>();
	private double price = 100;
	private String name = "";
	
	Stocks(String name, double price){
		this.name = name;
		this.price = price;
	}

	@Override
	public void registerObserver(Shareholder holder) {
		shareholders.add(holder);
	}

	@Override
	public void deleteObserver(Shareholder holder) {
		shareholders.remove(holder);
	}

	@Override
	public void notifyObserver() {
		for(var holder:shareholders) {
			holder.update(price, name);
		}
	}

	public void setPrice(double price) {
		double temp = this.price;
		this.price = price;
		double calc = Math.abs((price-temp) / temp) *100;
		
		if(calc >= 5) notifyObserver();
	}
	
	public static void main(String[] args){
		Shareholder sh1 = new ShareholderA();
		Shareholder sh2 = new ShareholderB();
		
		Stocks mihoyo = new Stocks("Mihoyo", 100);
		mihoyo.registerObserver(sh2);
		
		Stocks ystar = new Stocks("Yostar", 100);
		ystar.registerObserver(sh1);
		ystar.registerObserver(sh2);
		
		mihoyo.setPrice(76);
		mihoyo.setPrice(66);
		ystar.setPrice(120);
		ystar.setPrice(150);
	}

}
