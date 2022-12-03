package datastructure.sort;

import java.util.Arrays;

/**
 * @author foanxi
 */
public class ShellSort {
    public static void main(String[] args) {
        int[] array = {1, 6, 2, 3, 5};
        shellSort(array);
        System.out.println(Arrays.toString(array));
    }

    public static void shellSort(int[] arrays) {
        for (int delta = arrays.length / 2; delta > 0; delta /= 2) {
            for (int i = delta; i < arrays.length; i++) {
                int num = arrays[i], j;
                for (j = i - delta; j >= 0 && num < arrays[j]; j -= delta) {
                    arrays[j + delta] = arrays[j];
                }
                arrays[j + delta] = num;
            }
        }
    }
}
