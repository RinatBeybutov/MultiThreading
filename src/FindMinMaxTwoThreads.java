

public class FindMinMaxTwoThreads {

    private int [] array;

    private int max;
    private int min;

    class Finder implements Runnable{

        private boolean searchMax;
        private boolean searchMin;

        public Finder(boolean searchMax, boolean searchMin) {
            this.searchMax = searchMax;
            this.searchMin = searchMin;
        }

        @Override
        public void run() {
            max = array[0];
            min = array[0];

            for (int i = 0; i < array.length; i++) {

                System.out.println(Thread.currentThread().getName() + " || i = " + i);

                if(searchMax && array[i] > max) {
                    max = array[i];
                }
                if(searchMin && array[i] < min) {
                    min = array[i];
                }
            }
        }
    }

    public FindMinMaxTwoThreads(int[] array) {
        this.array = array;
    }

    public void findMinMax() {
        Thread threadMin = new Thread(new Finder(false, true));
        Thread threadMax = new Thread(new Finder(true, false));

        threadMax.start();
        threadMin.start();

        try {
            threadMax.join();
            threadMin.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Max = " + max);
        System.out.println("Min = " + min);
    }
}
