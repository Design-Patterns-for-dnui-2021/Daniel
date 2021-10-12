
public class Chicken implements Waitress {
	private Chef chef;
	
	Chicken(Chef chef){
		this.chef = chef;
	}
	
	public void order(){
		chef.chicken();
	}
}
