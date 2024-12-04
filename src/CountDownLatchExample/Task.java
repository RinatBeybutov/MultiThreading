package CountDownLatchExample;

import java.util.concurrent.CountDownLatch;

public class Task implements Runnable {

    private final CountDownLatch endSignal;
    private final CountDownLatch startSignal;

    public Task(CountDownLatch startSignal, CountDownLatch endSignal) {
        this.startSignal = startSignal;
        this.endSignal = endSignal;
    }

    @Override
    public void run() {
        try {
            // Ждем стартового сигнала
            startSignal.await();
            // Симуляция бизнес-логики
            Thread.sleep((long) (Math.random() * 1000));
            System.out.println("Задача выполнена " + Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            // Уменьшение счетчика сигналов, сигнал об окончании текущего треда
            endSignal.countDown();
        }
    }
}
