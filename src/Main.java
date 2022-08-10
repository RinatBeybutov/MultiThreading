
import ShipsConcurrent.Starter;
import java.util.stream.Collectors;


public class Main {

  public static void main(String[] args) throws InterruptedException {


  }

  public static void startFindMinMaxTwoThread() {
    int[] array = new int[]{1, 20, 3, -5, 1, 5, 0, 12, -24, 17, 12};

    FindMinMaxTwoThreads finder = new FindMinMaxTwoThreads(array);
    finder.findMinMax();
  }

  public static void startShipsConcurrent() {
    Starter starter = new Starter();
    starter.start();
  }

  public static void printStates() throws InterruptedException {
    ShowStatesOfThreads starter = new ShowStatesOfThreads();
    starter.startThread();
  }

}
