package com.yaamani.sortingvisualized;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.TimeUtils;

import static com.yaamani.sortingvisualized.Gravity.gravity;

public class MyUtils {

    public static final String TAG = MyUtils.class.getSimpleName();

    public static int max (int [] array) {
        int max = array[0];
        for (int i = 0; i < array.length; i++)
            if (array[i] > max) max = array[i];
        return max;
    }
    //------
    public static void printArray (int arr[]) {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i]+" ");
        System.out.println();
    }

    public static void printArray (byte arr[])
    {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i]+" ");
        System.out.println();
    }
    //------
    public static void print2DArray (byte[][] array) {
        for (int i = 0; i < array.length; i++) {
            printArray(array[i]);
        }
    }

    public static void print2DArray (int[][] array) {
        for (int i = 0; i < array.length; i++) {
            printArray(array[i]);
        }
    }
    //------
    public static int[] generateRandomArray (int length, int rangeFirstVal, int rangeLastVal) {
        int[] randomArr = new int[length];
        int range = rangeLastVal - rangeFirstVal;
        for (int i = 0; i < length; i++)
            randomArr[i] = rangeFirstVal + MathUtils.random(range);
        return randomArr;
    }

    public static int[] generateRandomArray (int length, int range) {
        return generateRandomArray(length, 0, range);
    }

    public static int[] generateRandomArray (int length) {
        return generateRandomArray(length, 0, Integer.MAX_VALUE);
    }
    //------
    public static long nanosSince(long startTime) {
        return TimeUtils.nanoTime() - startTime;
    }
    //------
    public static void compareGravityQuick () {
        int[] randomArr = generateRandomArray(10000, 10000);
        Quick quickSort = new Quick();

        long quickStartTime = TimeUtils.nanoTime();
        quickSort.sort(randomArr);
        printArray(quickSort.getArray());
        long quickTime = nanosSince(quickStartTime);

        long gravityStartTime = TimeUtils.nanoTime();
        int[] gravitySorted = gravity(randomArr);
        printArray(gravitySorted);
        long gravityTime = nanosSince(gravityStartTime);

        Gdx.app.log(TAG, "BATTLE .... gravityTime/quickTime = " + (gravityTime/quickTime));
    }
}
