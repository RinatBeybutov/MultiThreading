package ThreadStates;

import java.lang.Thread.State;

public class ShowStatesOfThreads {

  private Object lock = new Object();

  Runnable r = new Runnable() {
    @Override
    public void run() {

      printState();

      synchronized (lock) {
        try {
          lock.notifyAll();
          lock.wait(3000);
        } catch (InterruptedException e) {
          throw new RuntimeException(e);
        }

      }
    }
  };

  Thread thread = new Thread(r);

  private void printState() {
    String name = thread.getName();
    State state = thread.getState();
    System.out.println("Thread " + name + " is " + state.toString());
  }
  public ShowStatesOfThreads() {
    thread.setName("Max");
    printState();
  }

  public void startThread() throws InterruptedException {

    synchronized (lock) {
      thread.start();
      lock.wait();
      printState();
      lock.notifyAll();
      printState();

      /*
      thread.join();
      System.out.println("Blocked!");

      If print here join with state Blocked, program will stuck here

       */


    }

  }



}
