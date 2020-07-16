package Semaphores;

public class Main extends Thread {

    public static void main(String[] args) throws InterruptedException {

        BinarySemaphore allowW = new BinarySemaphore(1);
        BinarySemaphore allowX = new BinarySemaphore(0);
        BinarySemaphore allowY = new BinarySemaphore(1);
        BinarySemaphore allowZ = new BinarySemaphore(0);

        Semaphore sempahoreA = new Semaphore();

        ThreadW threadW = new ThreadW(allowW, allowX, sempahoreA);
        ThreadX threadX = new ThreadX(allowX, allowW);
        ThreadY threadY = new ThreadY(allowY, allowZ, sempahoreA);
        ThreadZ threadZ = new ThreadZ(allowZ, allowY, sempahoreA);


        threadW.start();
        threadX.start();
        threadY.start();
        threadZ.start();


        Thread.sleep(4000);
        System.exit(0);
    }
}
