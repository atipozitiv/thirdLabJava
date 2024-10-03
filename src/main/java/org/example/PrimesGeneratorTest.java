package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.function.Consumer;

public class PrimesGeneratorTest implements Iterator {
    ArrayList<Integer> digits;
    int turn = 0;

    public void setDigits(ArrayList<Integer> digits) {
        this.digits = digits;
    }

    public PrimesGeneratorTest(PrimesGenerator primesGenerator) {
        setDigits(primesGenerator.digits);
    }

    @Override
    public boolean hasNext() {
        if (turn == digits.size()) {
            return false;
        }
        return true;
    }

    @Override
    public Object next() {
        turn += 1;
        return digits.get(turn);
    }

    public void showArray() {
        System.out.println(digits);
    }

    public void showReverseArray() {
        Collections.reverse(digits);
        System.out.println(digits);
    }
}
