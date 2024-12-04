package ThreadStates;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        ShowStatesOfThreads starter = new ShowStatesOfThreads();
        starter.startThread();
    }
}
