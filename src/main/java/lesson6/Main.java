package lesson6;

import java.util.*;

public class Main {

    private static final int NUMBER_FOR_CONVERT = 4;
    private static final int NUMBER_FOR_CHECK_1 = 1;
    private static final int NUMBER_FOR_CHECK_2 = 4;

    public static void main(String[] args) {

        ArrayList<int[]> arrays = new ArrayList<>();
        arrays.add(new int[]{1, 2, 4, 5, 8, 1});
        arrays.add(new int[]{1, 4, 1, 4, 1, 4});
        arrays.add(new int[]{1, 1, 3, 4, 4, 4});
        arrays.add(new int[]{4, 4, 4, 4, 4, 4});
        System.out.println(Arrays.toString(arrays.get(0)));
        System.out.println(Arrays.toString(convertArrayAfter4(arrays.get(0))));
        System.out.println(checkArrayFor1or4(arrays.get(0)));
        System.out.println(checkArrayFor1or4(arrays.get(1)));
        System.out.println(checkArrayFor1or4(arrays.get(2)));
        System.out.println(checkArrayFor1or4(arrays.get(3)));
    }

    public static int[] convertArrayAfter4(int[] original) {
        Integer index = null;
        for (int i = 0; i < original.length; i++) {
            if (original[i] == NUMBER_FOR_CONVERT) index = i + 1;
        }
        if (index == null) {
            throw new RuntimeException("Массив не содержит значение " + NUMBER_FOR_CONVERT);
        }
        int[] convert = new int[original.length - index];
        for (int i = index, j = 0; i < original.length; i++, j++) {
            convert[j] = original[i];
        }
        return convert;
    }

    public static boolean checkArrayFor1or4(int[] original) {
        int count1 = 0, count2 = 0;
        for (int item : original) {
            if (item != NUMBER_FOR_CHECK_1 && item != NUMBER_FOR_CHECK_2) return false;
            if (item == NUMBER_FOR_CHECK_1) count1++;
            else count2++;
        }
        return count1 != 0 && count2 != 0;
    }
}
