import ShipsConcurrent.PierLoader;
import ShipsConcurrent.ShipGenerator;
import ShipsConcurrent.Starter;
import ShipsConcurrent.Tunnel;
import ShipsConcurrent.ships.types.Type;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) {

        Starter starter = new Starter();
        starter.start();



    }

    public static void startFindMinMaxTwoThread() {
        int [] array = new int[]{1,20,3,-5,1, 5, 0, 12, -24, 17, 12};

        FindMinMaxTwoThreads finder = new FindMinMaxTwoThreads(array);
        finder.findMinMax();
    }
}
