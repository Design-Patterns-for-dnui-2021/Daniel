import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		PetFactory factory = new PetFactory();
		
		System.out.println("Please call a creature!\n"
				+ "type \"meow\" to call a cat.\n"
				+ "type \"woof\" to call a dog.\n"
				+ "type \"chirp\" to call a bird.\n");
		
		String call = scan.nextLine();

		Pets pet = factory.createPet(call);
		pet.action();
	}
}
