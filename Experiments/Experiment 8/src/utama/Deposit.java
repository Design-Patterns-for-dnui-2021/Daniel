package utama;

public class Deposit extends Transaction {
	@Override
	protected void doBusiness() {
		System.out.println("Deposit money to the bank account.");
	}
}