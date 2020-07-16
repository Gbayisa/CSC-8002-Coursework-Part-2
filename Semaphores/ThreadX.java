package Semaphores;

//This class extends the Thread class and has its own run implementation

public class ThreadX extends Thread{

    private BinarySemaphore semW;
    private BinarySemaphore semX;


    public ThreadX(BinarySemaphore x, BinarySemaphore w) {
        this.semX = x;
        this.semW = w;
    }

    // run method sleeps from a random amount of time and then starts the X Binary semaphore,
   // following this is launches/wakes W binary semaphore.
    @Override
    public void run() {

        while (true){
            try {
                sleep((long)(Math.random()*1000));
                semX.P();
                System.out.print(" X ");

            } catch (InterruptedException e) {
            }
 //           System.out.print(" Hiya 2 ");
        semW.V();
        }
    }
}
