package main;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Phaser;
import java.util.concurrent.atomic.AtomicInteger;

public class FizzBuzz {
    private static ArrayBlockingQueue<Integer> array;
    Phaser p;
    AtomicInteger ai = new AtomicInteger(0);

    public FizzBuzz(int n, Phaser p) {
        this.p = p;
        array = new ArrayBlockingQueue<>(n);
        for (int i = 1; i <= n; i++) {
            array.add(i);
        }
        getNumber();
    }

    //3
    public void fizz() {
        if ((ai.get() % 3 == 0) && (ai.get() % 5 != 0)) {
            System.out.print("fizz,");
            if (array.size() != 0) {
                getNumber();
                p.arrive();
            } else {
                p.arriveAndDeregister();
            }
        }
    }
    //2
    public void buzz() {
        if ((ai.get() % 5 == 0) && (ai.get() % 3 !=0)) {
            System.out.print("buzz,");
            if (array.size() != 0) {
                getNumber();
                p.arrive();
            } else {
                p.arriveAndDeregister();
            }
        }
    }
    //1
    public void fizzbuzz() {
        if ((ai.get() % 3 == 0) && (ai.get() % 5 == 0)) {
            System.out.print("fizzbuzz,");
            if (array.size() != 0) {
                getNumber();
                p.arrive();
            } else {
                p.arriveAndDeregister();
            }
        }
    }
    //4
    public void number() {
        if (!(ai.get() % 3 == 0) && !(ai.get() % 5 == 0)) {
            System.out.print(ai.get() + ",");
            if (array.size() != 0) {
                getNumber();
                p.arrive();
            } else {
                p.arriveAndDeregister();
            }
        }
    }

    private synchronized void getNumber() {
        ai.getAndSet(array.poll());
    }
}
