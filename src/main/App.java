package main;

import threads.A;
import threads.B;
import threads.C;
import threads.D;

import java.util.concurrent.Phaser;

public class App {
    public static void main(String[] args) {
        int n = 15;
        Phaser phaser = new Phaser(1);
        FizzBuzz fizzBuzz = new FizzBuzz(n, phaser);
        A a = new A(phaser, fizzBuzz);
        B b = new B(phaser, fizzBuzz);
        C c = new C(phaser, fizzBuzz);
        D d = new D(phaser, fizzBuzz);

        for (int i = 1; i < n; i++) {
            phaser.arriveAndAwaitAdvance();
        }
        phaser.arriveAndDeregister();
    }
}
