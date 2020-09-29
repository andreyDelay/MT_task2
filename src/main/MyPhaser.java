package main;

import java.util.concurrent.Phaser;

public class MyPhaser extends Phaser {
    int numberOfPhases;

    MyPhaser(int parties, int phases) {
        super(parties);
        numberOfPhases = phases - 1;
    }

    @Override
    protected boolean onAdvance(int phase, int registeredParties) {
//        System.out.print(" Закончилась фаза " + phase);
//        System.out.print(",");
        if (phase == numberOfPhases || registeredParties == 0) {
            return true;
        }
        return false;
    }
}
