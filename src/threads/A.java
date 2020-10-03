package threads;

import main.FizzBuzz;

import java.util.concurrent.Phaser;

public class A implements Runnable {

    Phaser phaser;
    FizzBuzz fizzBuzz;

    public A(Phaser phaser, FizzBuzz fizzBuzz) {
        this.phaser = phaser;
        this.fizzBuzz = fizzBuzz;
        this.phaser.register();
        new Thread(this).start();
    }

    @Override
    public void run() {
        while (!phaser.isTerminated()) {
            fizzBuzz.fizz();
        }
    }
}
