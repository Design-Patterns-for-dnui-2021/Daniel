package utama;

public class Withdraw extends Transaction {
	@Override
	protected void doBusiness() {
		System.out.println("Withdraw money from the bank account.");
	}
}