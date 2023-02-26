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
     * 对[l,r]内的元素进行双边循环快排
     *
     * @param array 需要排序的数组
     */
    public static void hoareSort(int[] array, int l, int r) {
        if (l >= r) {
            return;
        }
        int mid = hoarePartition(array, l, r);
        // 递归对左半部分进行处理
        hoareSort(array, l, mid - 1);
        // 递归对右半部分进行处理
        hoareSort(array, mid + 1, r);
    }

    public static int hoarePartition(int[] array, int l, int r) {
        int pv = array[l];
        // 左指针
        int i = l;
        // 右指针
        int j = r;
        while (i < j) {
            // 右指针向左移动，直到找到比基准点元素小的位置
            while (i < j && array[j] > pv) {
                j--;
            }
            // 注意此处应该是小于等于，否则可能会陷入死循环
            // 左指针向右移动，直到找到比基准点元素大的位置
            while (i < j && array[i] <= pv) {
                i++;
            }
            // 交换两个位置的元素
            swap(array, i, j);
        }
        // 最后还需要把基准点放回到右指针的位置
        swap(array, j, l);
        // 返回基准点当前的位置
        return j;
    }

    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
