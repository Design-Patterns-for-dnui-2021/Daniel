
public class PetFactory {
	public Pets createPet(String sound) {
		if(sound.equals("chirp")) return new Bird();
		if(sound.equals("woof")) return new Dog();
		if(sound.equals("meow")) return new Cat();
		throw new Error("There is no creature that respond to your call!");
	}
}
