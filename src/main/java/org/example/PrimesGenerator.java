package org.example;

import java.util.ArrayList;
import java.util.Random;

public class PrimesGenerator {
    ArrayList<Integer> digits = new ArrayList<>();

    public void setDigits(ArrayList<Integer> digits) {
        this.digits = digits;
    }
    public PrimesGenerator(int count) {
        Random random = new Random();
        ArrayList<Integer> digits = new ArrayList<>();
        for (int turn = 0; turn < count; ++turn) {
            digits.add(random.nextInt(0, 100));
        }
        setDigits(digits);
    }
}
