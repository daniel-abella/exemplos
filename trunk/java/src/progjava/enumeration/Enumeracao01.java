package progjava.enumeration;

enum Animals {
	DOG("woof"), CAT("meow"), FISH("burble");
	private String sound;
	public String getSound() { return sound; }
	public void setSound(final String sound) { this.sound = sound; }
	Animals(final String sound) { this.sound = sound; }
}

public class Enumeracao01 {
	static private Animals animal;
	public static void main(final String[] args) {
		System.out.println(animal);
		System.out.println(Animals.DOG.getSound() + " " + Animals.FISH.getSound());
		Animals.DOG.setSound("teste");
		System.out.println(Animals.DOG.getSound() + " " + Animals.FISH.getSound());
	}
}
