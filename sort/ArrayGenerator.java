package sort;

import java.util.Random;

/**
 * @author haif.
 * @date 2021/3/4 23:08
 */
public class ArrayGenerator {

    private ArrayGenerator() {

    }

    public static Integer[] generateOrderedArray(int n) {

        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i;
        }
        return arr;
    }

    /**
     * 生成一个随机数组
     *
     * @param n     数组长度
     * @param bound 数字范围[0, bound)
     * @return 随机数组
     */
    public static Integer[] generateRandomArray(int n, int bound) {

        Integer[] arr = new Integer[n];
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            arr[i] = random.nextInt(bound);
        }
        return arr;
    }
}
