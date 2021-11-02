package utama;

public class WashingMachine implements ThreePhaseSocket {

	@Override
	public void connect() {
		System.out.println("Washing machine has been connected to a power outlet.");
	}

	@Override
	public void disconnect() {
		System.out.println("Washing machine has been disconnected from a power outlet");
	}
}
