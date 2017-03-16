/*
* class Cat
*/
class Cat extends Animal {
  
	

	Cat(String name, String color, int age){
        super(name, color, age);
        type = "Cat";
        RUN_DISTANCE = 200;
	    JUMP_DISTANCE = 500f;
	    SWIM_DISTANCE = -1;
    
	}

}