
public class Test {

	public static void main(String[] args)
	{
		Person player1 = new Person("John Curtin");
		Person player2 = new Person("Cleopatra");
		Person player3 = new Person("Alexander");
		Person player4 = new Person("Gilgamesh");
		Person player5 = new Person("Ambiorix");
		
		player1.registerObserver(player2);
		player1.registerObserver(player3);
		player1.registerObserver(player4);
		player1.registerObserver(player5);
		
		player2.registerObserver(player1);
		player2.registerObserver(player3);
		player2.registerObserver(player4);
		player2.registerObserver(player5);
		
		player3.registerObserver(player1);
		player3.registerObserver(player2);
		player3.registerObserver(player4);
		player3.registerObserver(player5);
		
		player4.registerObserver(player1);
		player4.registerObserver(player2);
		player4.registerObserver(player3);
		player4.registerObserver(player5);
		
		player5.registerObserver(player1);
		player5.registerObserver(player2);
		player5.registerObserver(player3);
		player5.registerObserver(player4);
		
		player1.beat();
		player2.beat();
		player3.beat();
		player4.beat();
		player5.beat();
		
	}
}
