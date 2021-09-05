public class Fighter extends Aircraft {
	@Override
	
	public void displaystat() {
		System.out.println("Fighter:");
		this.ExecuteTakeoff();
		this.ExecuteFly();
		System.out.println("\n");
	}
	 
}
 
