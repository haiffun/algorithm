package sort.selectionsort;

import sort.ArrayGenerator;
import sort.SortingHelper;

import java.util.Arrays;

/**
 * 选择排序法
 * @author haif.
 * @date 2021/3/4 23:34
 */
public class SelectionSort {

	/**
	 * 从小到大排序
	 * @param array 待排序数组
	 * @param <E> 元素类型
	 */
	public static <E extends Comparable<E>> void sort(E[] array) {

		int length = array.length;

		// arr[0...i)有序; arr[i...n)无序
		for (int i = 0; i < length; i++) {

			// 选择array[i...n)中的最小值
			int minIndex = i;
			for (int j = i; j < length; j++) {
				if (array[j].compareTo(array[minIndex]) < 0) {
					minIndex = j;
				}
			}

			SortingHelper.swap(array, i, minIndex);
		}
	}

	/**
	 * 反向排序
	 * @param array 待排序数组
	 * @param <E> 元素类型
	 */
	public static <E extends Comparable<E>> void reverseSort(E[] array) {

		int length = array.length - 1;

		// arr[0...i)无序; arr[i...n)有序
		for(int i = length; i >= 0; i--) {
			int maxIndex = i;
			for(int j = i - 1; j >= 0; j--) {
				if (array[j].compareTo(array[maxIndex]) > 0) {
					maxIndex = j;
				}
			}

			SortingHelper.swap(array, i, maxIndex);
		}
	}

	public static void main(String[] args) {

		int[] dataSize = {10000, 100000};

		for (int n : dataSize) {
			Integer[] arr = ArrayGenerator.generateRandomArray(n, n);
			Integer[] arr2 = Arrays.copyOf(arr, arr.length);
			SortingHelper.sortTest(SelectionSort.class, "sort", arr);
			SortingHelper.sortTest(SelectionSort.class, "reverseSort", arr2);
		}
	}
}
