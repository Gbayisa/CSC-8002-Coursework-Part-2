package Semaphores;

//This class extends the Thread class and has its own run implementation

public class ThreadZ extends Thread{

    private BinarySemaphore semY;
    private BinarySemaphore semZ;
    private Semaphore semA;

    public ThreadZ(BinarySemaphore z, BinarySemaphore y,  Semaphore a){
        this.semZ = z;
        this.semY = y;
        this.semA = a;
    }

    // run method sleeps from a random amount of time and then starts the Z and A semaphore,
    // following this is launches/wakes the Y semaphore.
    @Override
    public void run() {

        while (true){
            try {

                sleep((long)(Math.random()*1000));
                semZ.P();
                semA.P();
                System.out.print("Z");
            } catch (InterruptedException e) {
            }
//            System.out.print(" Hiya 4 ");
            semY.V();

        }
    }
}
