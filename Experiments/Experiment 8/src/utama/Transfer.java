package utama;

public class Transfer extends Transaction {
	@Override
	protected void doBusiness() {
		System.out.println("Transfer money to another bank account.");
	}
}