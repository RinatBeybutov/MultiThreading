package CountDownLatchExample;

import java.util.concurrent.CountDownLatch;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        int countThreads = 5;
        CountDownLatch doneSignal = new CountDownLatch(countThreads);
        CountDownLatch startSignal = new CountDownLatch(1);

        for (int i = 0; i < countThreads; i++) {
            new Thread(new Task(startSignal, doneSignal)).start();
        }

        System.out.println(" Действия еще не начались!");
        startSignal.countDown();
        System.out.println("А вот теперь действия начались!");

        doneSignal.await();
        System.out.println("Все задачи завершены, продолжение основного потока");
    }
}
