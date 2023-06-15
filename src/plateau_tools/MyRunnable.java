package plateau_tools;
import managers.PlateauManager;

public class MyRunnable implements Runnable {

    private PlateauManager plateauManager;

    public MyRunnable(PlateauManager plateauManager) {
        // store parameter for later user
    }

   public void run() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        this.plateauManager.freeSemaphore2();
   }
}
