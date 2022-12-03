package datastructure;

/**
 * @author foanxi
 */
public class BinarySearch {
    public static void main(String[] args) {
        int[] array = {1, 4, 6, 7, 15, 33, 39, 50, 64, 78, 75, 81, 89, 96};
        System.out.println(binarySearch(array, 81));
    }

    public static int binarySearch(int[] array, int val) {
        int l = 0, r = array.length - 1;
        while (l <= r) {
            int mid = (l + r) >>> 1;
            if (val < array[mid]) {
                r = mid - 1;
            } else if (val > array[mid]) {
                l = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
