package org.example.pyramid.brick;

public class Brick {

    /**
     * Min prime number is 2 in Math. 0 and 1 are not prime number.
     */
    private static final int MIN_PRIME_NUMBER = 2;

    private final Index index;

    private final int number;

    private final boolean prime;

    private boolean out = false;

    private Brick(Index index, int number) {
        this.index = index;
        this.number = number;
        prime = calculatePrimeness();
    }

    private boolean calculatePrimeness() {

        if (number < MIN_PRIME_NUMBER) return false;

        if (number % 2 == 0) return false;

        int mod = number / 2;
        while (MIN_PRIME_NUMBER < mod--) {
            if (number % mod == 0)
                return false;
        }
        return true;
    }

    public static Brick create(Index index, int number) {
        return new Brick(index, number);
    }

    public Index getIndex() {
        return index;
    }

    public int getNumber() {
        return number;
    }

    public void out() {
        out = true;
    }

    public boolean isOut() {
        return out;
    }

    public boolean isPrime() {
        return prime;
    }

    @Override
    public String toString() {
        return "Index: " + "(" + index.getI() + "," + index.getJ() + ") " + "Number: " + number;
    }
}
