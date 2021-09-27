
public class Main {
	public static void main(String[] args) {
		TVFactory factory = new TVFactory();
		
		TV haier = factory.produceTV("haier");
		haier.play();
		
		TV hisense = factory.produceTV("hisense");
		hisense.play();
	}
}
