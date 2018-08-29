package com.yaamani.sortingvisualized;

import com.badlogic.gdx.Gdx;

public class Quick {

    public static final String TAG = Quick.class.getSimpleName();


    private int array[];
    private int length;

    public void sort(int[] inputArr) {

        if (inputArr == null || inputArr.length == 0) {
            return;
        }
        this.array = inputArr;
        length = inputArr.length;
        quickSort(0, length - 1);
    }

    private void quickSort(int lowerIndex, int higherIndex) {

        int i = lowerIndex;
        int j = higherIndex;
        // calculate pivot number, I am taking pivot as middle index number
        //int pivot = array[lowerIndex+(higherIndex-lowerIndex)/2];
        int pivot = choosePivot(array[lowerIndex], array[(lowerIndex+higherIndex)/2], array[higherIndex]);
        // Divide into two arrays
        while (i <= j) {
            /**
             * In each iteration, we will identify a number from left side which
             * is greater then the pivot value, and also we will identify a number
             * from right side which is less then the pivot value. Once the search
             * is done, then we exchange both numbers.
             */
            while (array[i] < pivot) {
                i++;
            }
            while (array[j] > pivot) {
                j--;
            }
            if (i <= j) {
                exchangeNumbers(i, j);
                //move index to next position on both sides
                i++;
                j--;
            }
        }
        // call quickSort() method recursively
        if (lowerIndex < j)
            quickSort(lowerIndex, j);
        if (i < higherIndex)
            quickSort(i, higherIndex);
    }

    private void exchangeNumbers(int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public int[] getArray() {
        return array;
    }

    public static int choosePivot (int val0, int val1, int val2) { // It chooses the median value. And if there are 2 duplicate values, it favours the duplicate.
        int biggest;
        int smallest;

        if (val1 > val0) {
            biggest = val1;
            smallest = val0;
        } else {
            biggest = val0;
            smallest = val1;
        }

        if (val2 > biggest) return biggest;
        else if (val2 < smallest) return smallest;
        else return val2;
    }

    //--------------------------------------------

    public static void testChoosePivot() {
        // No duplicates.
        Gdx.app.log(TAG, "Expected = 2, result = " + choosePivot(1, 2, 3));
        Gdx.app.log(TAG, "Expected = 2, result = " + choosePivot(1, 3, 2));
        Gdx.app.log(TAG, "Expected = 2, result = " + choosePivot(3, 1, 2));
        Gdx.app.log(TAG, "Expected = 2, result = " + choosePivot(3, 2, 1));
        Gdx.app.log(TAG, "Expected = 2, result = " + choosePivot(2, 3, 1));
        Gdx.app.log(TAG, "Expected = 2, result = " + choosePivot(2, 1, 3));
        // Bigger duplicates.
        Gdx.app.log(TAG, "Bigger duplicates -----------------------------------------");
        Gdx.app.log(TAG, "Expected = 3, result = " + choosePivot(2, 3, 3));
        Gdx.app.log(TAG, "Expected = 3, result = " + choosePivot(3, 2, 3));
        Gdx.app.log(TAG, "Expected = 3, result = " + choosePivot(3, 2, 3));
        // Smaller duplicates.
        Gdx.app.log(TAG, "Smaller duplicates -----------------------------------------");
        Gdx.app.log(TAG, "Expected = 1, result = " + choosePivot(2, 1, 1));
        Gdx.app.log(TAG, "Expected = 1, result = " + choosePivot(1, 2, 1));
        Gdx.app.log(TAG, "Expected = 1, result = " + choosePivot(1, 1, 1));
    }
}
