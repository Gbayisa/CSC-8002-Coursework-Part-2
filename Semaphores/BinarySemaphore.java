package Semaphores;

/*
Binary Semaphore class that is extended from the Semaphore class
 */

public class BinarySemaphore extends Semaphore{

    //Constructor is called from the semaphore class as it is extended from it and int Value is protected.

    private BinarySemaphore(){
        super();
    }

    // A check for values 0 and 1

    public BinarySemaphore(int value){
        super(value > 0 ? 1 : 0);
    }

// Overrides the method from the Semaphore class, and wakes up the next thread if the value is greater than 1.
    @Override
    public synchronized void V() {

        value++;

        while (value>1){
            value=1;
        }
        notify();
    }
}
