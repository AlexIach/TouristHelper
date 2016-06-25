package model;

/**
 * Created by Alex Iachimov on 6/24/2016.
 */
public class Banknotes {
    int denomination;
    int count;

    public Banknotes(int denomination, int count) {
        this.denomination = denomination;
        this.count = count;
    }

    public int getDenomination() {
        return denomination;
    }

    public int getCount() {
        return count;
    }

    public void setDenomination(int denomination) {
        this.denomination = denomination;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
