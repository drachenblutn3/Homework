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