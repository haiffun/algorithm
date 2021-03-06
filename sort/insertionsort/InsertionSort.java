package sort.insertionsort;

import sort.ArrayGenerator;
import sort.SortingHelper;

import java.util.Arrays;

/**
 * 插入排序法
 *
 * @author haif.
 * @date 2021/3/6 12:11
 */
public class InsertionSort {

    /**
     * 插入排序: arr[0...i)有序; arr[i...n)无序
     *
     * @param array 待排序数组
     * @param <E>   元素类型
     */
    public static <E extends Comparable<E>> void sort(E[] array) {
        for (int i = 1; i < array.length; i++) {
            for (int j = i; j > 0 && array[j].compareTo(array[j - 1]) < 0; j--) {
                SortingHelper.swap(array, j, j - 1);
            }
        }
    }

    /**
     * swap优化
     */
    public static <E extends Comparable<E>> void sort2(E[] array) {
        for (int i = 1; i < array.length; i++) {
            E temp = array[i];
            int j;
            for (j = i; j > 0 && temp.compareTo(array[j - 1]) < 0; j--) {
                array[j] = array[j - 1];
            }
            array[j] = temp;
        }
    }

    public static void main(String[] args) {
        int[] dataSize = {10000, 100000};

        for (int n : dataSize) {
            Integer[] arr = ArrayGenerator.generateRandomArray(n, n);
            Integer[] arr2 = Arrays.copyOf(arr, arr.length);
            SortingHelper.sortTest(InsertionSort.class, "sort", arr);
            SortingHelper.sortTest(InsertionSort.class, "sort2", arr2);
        }
    }
}
