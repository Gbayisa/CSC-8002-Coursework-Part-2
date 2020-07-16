package Semaphores;

//This class extends the Thread class and has its own run implementation

public class ThreadY extends Thread {

    private BinarySemaphore semY;
    private BinarySemaphore semZ;
    private Semaphore semA;


    public ThreadY(BinarySemaphore y, BinarySemaphore z, Semaphore a){
        this.semY = y;
        this.semZ = z;
        this.semA = a;
    }

    // run method sleeps from a random amount of time and then starts the Y and A semaphore,
    // following this is launches/wakes the Z semaphore.
    @Override
    public void run() {

        while (true) {
            try {

                sleep((long)(Math.random()*1000));
                semY.P();
                semA.P();
                System.out.print("Y");

            } catch (InterruptedException e) {

 //               System.out.print(" Hiya 3 ");

            }
            semZ.V();
        }
    }
}
