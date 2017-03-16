abstract class Animal{
	
	private String name;
	private int age;
	private String weigth;
	private String color;
	public String type;
	public int RUN_DISTANCE = -1;
	public float JUMP_DISTANCE = -1;
	public int SWIM_DISTANCE = -1;


	Animal(String name, String color, int age){
    this.name = name;
    this.color = color;
    this.age = age;
    type = "Animal";
	}

    public String run(int distance){
        boolean check = false;
    	if (RUN_DISTANCE >= 0 || distance < RUN_DISTANCE) 
    		check = true;
    		return type +" " +this.name +" try's to run up to " 
    			+distance +" meters.\nResult:\t" +check;
    	 }

    public String jump(int distance){
        boolean check = false;
    	if (JUMP_DISTANCE >= 0 || distance < JUMP_DISTANCE) 
    		check = true;
    		return type +" " +this.name +" try's to run up to " +distance 
    		+" meter(s).\nResult:\t" +check;
   	}

    public String swim(int distance){
        boolean check = false;
    	if (SWIM_DISTANCE >= 0 || distance < SWIM_DISTANCE) 
    		check = true;
    		return type +" " +this.name +" try's to run up to " +distance 
    		    +" meter(s).\nResult:\t" +check;
    }
}
