package datastructure.sort;

import java.util.Arrays;

/**
 * @author foanxi
 */
public class InsertSort {
    public static void main(String[] args) {
        int[] array = {1, 6, 2, 3, 5};
        insert(array);
        System.out.println(Arrays.toString(array));
    }

    public static void insert(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int temp = array[i];
            int j = i - 1;
            while (j >= 0) {
                if (temp < array[j]) {
                    array[j + 1] = array[j];
                } else {
                    break;
                }
                j--;
            }
            array[j + 1] = temp;
        }
    }
}
