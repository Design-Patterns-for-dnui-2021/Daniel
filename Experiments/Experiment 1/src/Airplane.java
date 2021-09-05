public class Airplane extends Aircraft {
	@Override
	
	public void displaystat() {
		System.out.println("Airplane:");
		this.ExecuteTakeoff();
		this.ExecuteFly();
		System.out.println("\n");
	}
	 
}
 
