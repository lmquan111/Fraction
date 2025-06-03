package hus.oop.fraction;

import java.util.Arrays;

public class MyArrayDataSet implements MyDataSet {
    private static int DEFAULT_CAPACITY = 16;
    private MyFraction[] fractions;
    private int length;

    public MyArrayDataSet() {
        this.fractions = new MyFraction[DEFAULT_CAPACITY];
        this.length = 0;
    }

    public MyArrayDataSet(MyFraction[] fractions) {
        this.fractions = new MyFraction[Math.max(DEFAULT_CAPACITY, fractions.length * 2)];
        for (MyFraction f : fractions) {
            this.fractions[length] = new MyFraction(f);
            ++length;
        }
    }

    @Override
    public boolean insert(MyFraction fraction, int index) {
        if (!checkBoundaries(index, length)) return false;

        if (length == fractions.length){
            allocateMore();
        }

        for (int i = length; i > index; i--){
            fractions[i] = fractions[i - 1];
        }

        fractions[index] = new MyFraction(fraction);
        length++;

        return true;
    }

    @Override
    public boolean append(MyFraction fraction) {
        if (length == fractions.length){
            allocateMore();
        }

        fractions[length] = new MyFraction(fraction);
        ++length;
        return true;
    }

    @Override
    public MyArrayDataSet toSimplify() {
        for (int i = 0; i < length; i++){

            fractions[i].simplify();

        }
        return this;
    }

    @Override
    public MyArrayDataSet sortIncreasing() {
        Arrays.sort(fractions, 0, length);

        return this;
    }

    @Override
    public MyArrayDataSet sortDecreasing() {
        Arrays.sort(fractions, 0, length, java.util.Collections.reverseOrder());
        return this;
    }

    @Override
    public String myDataSetToString() {
        StringBuilder sb = new StringBuilder("[");

        for (int i = 0; i < length; i++){
            sb.append(fractions[i]);
            if (i < length - 1) sb.append(", ");
        }

        sb.append("]");
        return sb.toString();
    }

    @Override
    public void print() {
        System.out.println(myDataSetToString());
    }

    private void allocateMore() {
        /* TODO */

        int newCapacity = fractions.length * 2;
        MyFraction[] newData = new MyFraction[newCapacity];

        System.arraycopy(fractions, 0, newData, 0, length);

        fractions = newData;

    }

    private boolean checkBoundaries(int index, int upperBound) {
        return index >= 0 && index <= upperBound;
    }
}
