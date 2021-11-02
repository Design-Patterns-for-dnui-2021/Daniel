package utama;

public class Client {
	public static void main(String[] args) {
		TV tv = new TV();
		WashingMachine wm = new WashingMachine();
		ThreePhaseSocket adaptor = new Adaptor(tv);
		
		System.out.println("Testing the washing machine.");
		wm.connect();
		wm.disconnect();
		
		System.out.println("\nTesting the TV.");
		tv.connect();
		tv.disconnect();;
		
		System.out.println("\nTesting the adaptor.");
		adaptor.connect();
		adaptor.disconnect();
	}
}
