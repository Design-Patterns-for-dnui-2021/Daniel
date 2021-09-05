public class Helicopter extends Aircraft {
	@Override
	
	public void displaystat() {
		System.out.println("Helicopter:");
		this.ExecuteTakeoff();
		this.ExecuteFly();
		System.out.println("\n");
	}
	 
}
 
