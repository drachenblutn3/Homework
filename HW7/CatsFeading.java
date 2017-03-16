/**
 * Java. Level 1. Lesson 7. ООП + Swing
 *
 * @author Nikolay Gritskevich
 * @version dated 07 Mar 2017
 */

public class CatsFeading {
	
	public static void main(String[] args){
	Cat[] cats = new Cat[3];
	cats[0] = new Cat("Karamelka", 20);
	cats[1] = new Cat("Korjik", 40);
	cats[2] = new Cat("Kompot", 60);

	Plate plate = new Plate(100);

	for (Cat an : cats) {
            System.out.println(an);
            an.feed(plate);
        }
        plate.fillPlate(100);
    }
}

class Cat {
    private String name; // Cat's name.
    private int volume; // Capacity
    private int hunger; // glutteny
    private boolean satiety = false; // satiety


    Cat(String name, int volume) {
        this.name = name;
        this.volume = volume;
        this.satiety = false; 

    }

    void feed(Plate plate) {
        if (plate.food >= this.volume){
        plate.decreaseFood(volume);
        satiety = true;
        System.out.println("satiety " +satiety +"  Meow! (Cat " +name +" is full now.)\n");
    }
    else System.out.println("satiety " +satiety +"  Need more gold!"); //Сообщение что коту нужно положить еды
    }

    @Override
    public String toString() {
        return "  Cat: " + name + " volume: \t" + volume +" satiety " +satiety;
    }

}

class Plate {
    protected int food;

    Plate(int food) {
        this.food = food;
    }

    void decreaseFood(int portion) {
        if (food >= portion)
        food -= portion;
    else System.out.println("Not enough food!");
    }

    @Override
    public String toString() {
        return "plate: " + food;
    }

    public void fillPlate(int portion){
        food += portion;
        System.out.println("\nPlate is refilled! Plait contains " +food +" !");
    }
}