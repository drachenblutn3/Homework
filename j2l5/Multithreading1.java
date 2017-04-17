/**
 * @see Java 2. Lesson 5 homework. Multithreading.
 * 
 * @author Nikolay Gritskevich
 * @version 10.04.2017
 */


public class Multithreading1 implements Runnable {

	static int size = 10000000;
	float[] arr = new float[size];
	float[] arr1 = new float[(size/2)];
	float[] arr2 = new float[(size/2)];

	public static void main (String[] args) {
		Multithreading1 atempt1 = new Multithreading1();
		atempt1.classic();
		atempt1.withThreads();
		}

		void classic(){
			for (int i = 0; i < ( size - 1 ) ; i++) arr[i] = 1 ;
			long t1 = System.currentTimeMillis();
			for (int i = 0 ; i < size ; i++) {
					arr[i] = (float) (arr[i] * Math.sin(0.2d + i/5 ) * Math.cos(0.2d + i / 5 ) * Math.cos(0.4d + i/2 ));
				}
				System.out.println("\tChecking threadless calculation time  -  " +(System.currentTimeMillis() - t1));
}

		void withThreads() {
        for (int i = 0; i < ( size - 1 ) ; i++) arr[i] = 1 ;
        long t2 = System.currentTimeMillis();
        System.arraycopy(arr, 0, arr1, 0, ( size / 2 ));
        System.arraycopy(arr, ( size / 2 ), arr2, 0, ( size / 2 ));
        Multithreading1 atempt1 = new Multithreading1();
        Thread first = new Thread(atempt1);
        Thread second  = new Thread(atempt1);
        first.setName("first");
        second.setName("second");
        first.start();
        second.start();
        try {
            first.join();
            second.join();
        } catch (InterruptedException ex) { System.out.println("Waiting");}
        System.arraycopy(arr1, 0, arr, 0, ( size / 2 ));
        System.arraycopy(arr2, 0, arr, ( size / 2 ), ( size / 2 ));
        System.out.println("\tChecking calculation using threads time  -  " + (System.currentTimeMillis() - t2));
    }

public void run() {
        for (int i = 0; i < ( size/2 ); i++) {
            if (Thread.currentThread().getName() == "first") {
                arr1[i] = (float) (arr[i] * Math.sin(0.2d + i/5 ) * Math.cos(0.2d + i / 5 ) * Math.cos(0.4d + i/2 ));
            } else {
                arr2[i] = (float) (arr[i] * Math.sin(0.2d + i/5 ) * Math.cos(0.2d + i / 5 ) * Math.cos(0.4d + i/2 ));
            }
        }
    }
}

