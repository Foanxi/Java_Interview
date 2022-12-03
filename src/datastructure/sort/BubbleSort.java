package datastructure.sort;

import java.util.Arrays;

/**
 * @author foanxi
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] array = {1, 6, 2, 3, 5};
        bubble(array);
        System.out.println(Arrays.toString(array));
    }

    public static void bubble(int[] array) {
        int last = array.length - 1;
        while (true) {
            int index = 0;
            boolean swapped = false;
            for (int i = 0; i < last; i++) {
                if (array[i] > array[i + 1]) {
                    swap(array, i, i + 1);
                    swapped = true;
                    index = i;
                }
            }
            last = index;
            if (!swapped || index == 0) {
                break;
            }
        }
    }

    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
