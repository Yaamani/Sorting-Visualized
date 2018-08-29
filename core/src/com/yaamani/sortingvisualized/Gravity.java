package com.yaamani.sortingvisualized;


import static com.yaamani.sortingvisualized.MyUtils.*;

public class Gravity {

    public static final String TAG = Gravity.class.getSimpleName();

    public static int[] gravity(int[] array) {
        int rows = array.length;
        int poles = max(array);
        byte[][] RP /*= new byte[rows][poles]*/; // RP = Rows Poles

        // Assign values to RP's elements
        RP = initializeRP(array, rows, poles);

        // Gravity simulation.
        RP = simulateGravity(RP, rows, poles);

        return finalStepIsToSortUsingRP(RP, rows, poles);
    }

    private static int[] finalStepIsToSortUsingRP(byte[][] RP, int rows, int poles) {
        int[] sorted = new int[rows];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < poles; j++) {
                if (RP[i][j] == 0) break;
                else sorted[i]++;
            }
        }
        return sorted;
    }


    private static byte[][] simulateGravity(byte[][] RP, int rows, int poles) {
        for (int i = poles-1; i >= 0; i--) {
            int alreadyOneIndex = rows;
            for (int c = rows-1; c >= 0; c--) {
                if (RP[c][i] == 1) {
                    alreadyOneIndex--;
                } else break;
            }
            if (alreadyOneIndex == 0) break;
            for (int j = 0; j < alreadyOneIndex; j++) {
                if (RP[j][i] == 1) {
                    RP[j][i] = 0;
                    RP[alreadyOneIndex -1][i] = 1;
                    alreadyOneIndex--;
                }
            }
        }
        return RP;
    }

    public static byte[][] initializeRP (int[] array) {
        int rows = array.length;
        int poles = max(array);
        byte[][] RP = new byte[rows][poles];

        // Assign values to RP's elements
        RP = initializeRP(array, rows, poles);

        return RP;
    }

    public static byte[][] initializeRP(int[] array, int rows, int poles) {
        byte[][] RP = new byte[rows][poles];

        // Assign values to RP's elements
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < array[i]; j++)
                RP[i][j] = 1;
        return RP;
    }

    //-------------------------------------------------

    public static byte[][] testInitializeRP (boolean print) {
        int[] toBeSorted = {2, 4, 1, 3, 3};
        byte[][] array = initializeRP(toBeSorted);
        if (print) print2DArray(array);
        return array;
    }

    public static byte[][] testSimulateGravity(boolean print) {
        byte[][] RP = testInitializeRP(false);
        RP = simulateGravity(RP, RP.length, RP[0].length);
        if (print) print2DArray(RP);
        return RP;
    }


}
