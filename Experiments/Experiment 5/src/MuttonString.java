
public class MuttonString implements Waitress {
	private Chef chef;
	
	MuttonString(Chef chef){
		this.chef = chef;
	}
	
	public void order(){
		chef.mutton();
	}
}
