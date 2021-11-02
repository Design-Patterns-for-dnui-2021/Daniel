package utama;

public class Adaptor implements ThreePhaseSocket {
	TwoPhaseSocket TwoPhaseSocket;

	public Adaptor(TwoPhaseSocket TwoPhaseSocket) {
		this.TwoPhaseSocket = TwoPhaseSocket;
	}
	
	@Override
	public void connect() {
		TwoPhaseSocket.connect();
	}

	@Override
	public void disconnect() {
		TwoPhaseSocket.disconnect();
	}
}
