/*launching class
*
*/
public class Pettest{

    public static void main(String[] args){
        
        Cat deamonycat = new Cat("Behemoth", "Blach as coal", 5000);
        System.out.println(deamonycat.type);
        System.out.println(deamonycat.run(150));
        System.out.println(deamonycat.jump(1));
        System.out.println(deamonycat.swim(10));

        Dog haidesdog = new Dog("Cerber", "Hellish black", 3000);
        System.out.println(haidesdog.type);
        System.out.println(haidesdog.run(150));
        System.out.println(haidesdog.jump(1));
        System.out.println(haidesdog.swim(10));
    }
}