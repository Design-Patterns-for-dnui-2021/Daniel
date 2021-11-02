package utama;

public class TV implements TwoPhaseSocket {

	@Override
	public void connect() {
		System.out.println("TV has been connected to a power outlet.");
	}

	@Override
	public void disconnect() {
		System.out.println("TV has been disconnected from a power outlet.");
	}
}
