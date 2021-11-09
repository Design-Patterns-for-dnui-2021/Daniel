package utama;

public abstract class Transaction {
	final void performTransaction() {
		getNumber();
		doBusiness();
	}

	protected abstract void doBusiness();

	private void getNumber() {
		System.out.println("Get number and queue with other clients");
	}

}
