package FindMinMaxTwoThreads;

public class Finder implements Runnable {
    
    private boolean isNeedSearchMax;
    private boolean isNeedSearchMin;
    
    private int[] array;
    
    private int min;
    private int max;

    public Finder(boolean isNeedSearchMax, boolean isNeedSearchMin, int[] array) {
        this.isNeedSearchMax = isNeedSearchMax;
        this.isNeedSearchMin = isNeedSearchMin;
        this.array = array;
    }

    @Override
    public void run() {
        max = array[0];
        min = array[0];

        for (int i = 0; i < array.length; i++) {

            System.out.println(Thread.currentThread().getName() + " || i = " + i);

            if(isNeedSearchMax && array[i] > max) {
                max = array[i];
            }
            if(isNeedSearchMin && array[i] < min) {
                min = array[i];
            }
        }

        if(isNeedSearchMax) {
            System.out.println("max = " + max);
        }

        if(isNeedSearchMin) {
            System.out.println("min = " + min);
        }
    }
}
