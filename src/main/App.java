package main;

import threads.A;
import threads.B;
import threads.C;
import threads.D;

public class App {
    public static void main(String[] args) {
        MyPhaser phaser = new MyPhaser(1, 17);
        FizzBuzz fizzBuzz = new FizzBuzz(15, phaser);
        A a = new A(phaser, fizzBuzz);
        B b = new B(phaser, fizzBuzz);
        C c = new C(phaser, fizzBuzz);
        D d = new D(phaser, fizzBuzz);

        while (!phaser.isTerminated()) {
            phaser.arriveAndAwaitAdvance();
        }
    }
}
