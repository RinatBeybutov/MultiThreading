package IncrementProblem;

public class ProblemMain {
    public static void main(String[] args) throws InterruptedException {

        Counter counter = new Counter();

        ProblemAction thread1 = new ProblemAction(counter);
        ProblemAction thread2 = new ProblemAction(counter);

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        // Ожидается 20_000, а в реальности будет 10_000 .. 14_000
        System.out.println(counter.getValue());
    }
}

class ProblemAction extends Thread {

    private final Counter counter;

    ProblemAction(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            counter.increment();
        }
    }
}

class Counter {
    private int counter = 0;

    public void increment() {
        counter++;
    }

    public int getValue() {
        return counter;
    }
}