package sort;

import java.lang.reflect.Method;

/**
 * 排序算法工具类
 *
 * @author haif.
 * @date 2021/3/6 10:27
 */
public class SortingHelper {

    private SortingHelper() {

    }

    /**
     * 交换数组元素
     *
     * @param array 数组
     * @param i     元素下标
     * @param j     元素下标
     * @param <E>   元素类型
     */
    public static <E> void swap(E[] array, int i, int j) {
        E temp = array[j];
        array[j] = array[i];
        array[i] = temp;
    }

    /**
     * 数组是否有序
     *
     * @param array 数组
     * @param <E>   元素类型
     * @return 是否有序
     */
    public static <E extends Comparable<E>> boolean isSorted(E[] array) {
        for (int i = 1; i < array.length; i++) {
            if (array[i - 1].compareTo(array[i]) > 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * 排序算法测试
     *
     * @param sortClass      待测试排序类型
     * @param sortMethodName 待测试方法名
     * @param array          待排序数组
     * @param <E>            元素类型
     */
    public static <E extends Comparable<E>> void sortTest(Class<?> sortClass, String sortMethodName, E[] array) {

        try {
            String sortName = sortClass.getSimpleName();
            Object instance = sortClass.newInstance();

            Method sortMethod = sortClass.getMethod(sortMethodName, Comparable[].class);

            long startTime = System.nanoTime();
            sortMethod.invoke(instance, (Object) array);
            long endTime = System.nanoTime();

            if (!SortingHelper.isSorted(array)) {
                throw new RuntimeException(sortName + " failed");
            }

            double time = (endTime - startTime) / 1000000000.0;
            System.out.printf("%s - %s, n = %d, %fs\n", sortName, sortMethodName, array.length, time);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
