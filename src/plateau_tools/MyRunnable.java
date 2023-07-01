package plateau_tools;
import managers.PlateauManager;

public class MyRunnable implements Runnable {

    //Should be created in another thread
    //Whene create => lunch run 
    //alows to rereturn the cards after 2 sec

    private PlateauManager plateauManager;

    public MyRunnable(PlateauManager plateauManager) {
        this.plateauManager = plateauManager;
    }

   public void run() {
        try {
            Thread.sleep(2000); // 2sec
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.plateauManager.freeSemaphore2();
   }
}
