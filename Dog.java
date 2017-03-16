class Dog extends Animal{
	

	Dog(String name, String color, int age){
	    super(name, color, age);
        type = "Dog";
        RUN_DISTANCE = 500;
	    JUMP_DISTANCE = 0.5f;
	    SWIM_DISTANCE = 10;
	}


}