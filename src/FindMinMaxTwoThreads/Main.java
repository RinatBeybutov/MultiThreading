package FindMinMaxTwoThreads;

public class Main {
    public static void main(String[] args) {
        int[] array = new int[]{1, 20, 3, -5, 1, 5, 0, 12, -24, 17, 12};

        FindMinMaxTwoThreads finder = new FindMinMaxTwoThreads();
        finder.findMinMax(array);
    }
}
