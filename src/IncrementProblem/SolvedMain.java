package IncrementProblem;

import java.util.concurrent.atomic.AtomicInteger;

public class SolvedMain {
    public static void main(String[] args) throws InterruptedException {

        CorrectCounter correctCounter = new CorrectCounter();

        CorrectAction thread1 = new CorrectAction(correctCounter);
        CorrectAction thread2 = new CorrectAction(correctCounter);

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        // Всегда будет 20_000
        System.out.println(correctCounter.getValue());
    }
}

class CorrectAction extends Thread {

    private final CorrectCounter correctCounter;

    CorrectAction(CorrectCounter correctCounter) {
        this.correctCounter = correctCounter;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            correctCounter.increment();
        }
    }
}

class CorrectCounter {
    private AtomicInteger counter = new AtomicInteger(0);

    public void increment() {
        counter.incrementAndGet();
    }

    public int getValue() {
        return counter.intValue();
    }
}
