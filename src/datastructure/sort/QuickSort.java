package datastructure.sort;

import java.util.Arrays;

/**
 * @author foanxi
 */
public class QuickSort {
    public static void main(String[] args) {
        // 单边排序方法
        int[] array = {5, 6, 1, 3, 4, 2};
        lomutoSort(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));
        int[] array2 = {5, 6, 1, 3, 4, 2};
        hoareSort(array2, 0, array.length - 1);
        System.out.println(Arrays.toString(array2));
    }

    public static void lomutoSort(int[] array, int l, int r) {
        if (l >= r) {
            return;
        }
        int i = lomutoPartition(array, l, r);
        lomutoSort(array, l, i - 1);
        lomutoSort(array, i + 1, r);
    }

    /**
     * 单边循环快排
     *
     * @param array 需要排序的数组
     * @return 返回当前分区完基准点元素所在的正确索引
     */
    public static int lomutoPartition(int[] array, int l, int r) {
        // 基准点元素
        int pv = array[r];
        int i = l;
        for (int j = l; j < r; j++) {
            if (array[j] < pv) {
                if (i != j) {
                    swap(array, i, j);
                }
                i++;
            }
        }
        if (i != r) {
            swap(array, r, i);
        }
        return i;
    }

    /**
     * 双边循环快排
     *
     * @param array 需要排序的数组
     */
    public static void hoareSort(int[] array, int l, int r) {
        if (l >= r) {
            return;
        }
        int i = hoarePartition(array, l, r);
        hoareSort(array, l, i - 1);
        hoareSort(array, i + 1, r);
    }

    public static int hoarePartition(int[] array, int l, int r) {
        int pv = array[l];
        // 左指针
        int i = l;
        // 右指针
        int j = r;
        while (i < j) {
            while (i < j && array[j] > pv) {
                j--;
            }
            while (i < j && array[i] <= pv) {
                i++;
            }
            swap(array, i, j);
        }
        swap(array, j, l);
        return j;
    }

    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
