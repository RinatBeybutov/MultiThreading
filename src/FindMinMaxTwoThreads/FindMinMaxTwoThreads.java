package FindMinMaxTwoThreads;

public class FindMinMaxTwoThreads {

    public void findMinMax(int[] array) {
        Thread threadMin = new Thread(new Finder(false, true, array));
        Thread threadMax = new Thread(new Finder(true, false, array));

        threadMax.start();
        threadMin.start();

        try {
            threadMax.join();
            threadMin.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
