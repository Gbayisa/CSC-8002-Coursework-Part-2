package Semaphores;

//This class extends the Thread class and has its own run implementation

public class ThreadW extends Thread{

    private BinarySemaphore semW;
    private BinarySemaphore semX;
    private Semaphore semA;


    public ThreadW(BinarySemaphore w, BinarySemaphore x, Semaphore a){
        semW = w;
        semX = x;
        semA = a;
    }

// run method sleeps from a random amount of time and then starts the W and X Binary semaphore,
// following this is launches the A semaphore.
    @Override
    public void run() {

        while (true) {
            try {

                sleep((long)(Math.random()*1000));
                semW.P();
                System.out.print(" W ");

            } catch (InterruptedException e) {
            }
//           System.out.print(" Hiya 1 ");
            semX.V();
            semA.V();
        }
    }
}

