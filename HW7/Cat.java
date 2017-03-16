/*
Java. Level 1. Lesson 7. ООП + Swing
 * @Cat class
 * @author Nikolay Gritskevich
 * @version dated 07 Mar 2017
*/

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