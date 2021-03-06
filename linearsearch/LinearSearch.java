package linearsearch;

import sort.ArrayGenerator;

/**
 * 线性查找法
 * @author haif.
 * @date 2021/3/4 22:21
 */
public class LinearSearch {

	public static <E> int search(E[] data, E target) {
		for (int i = 0; i < data.length; i++) {
			if (data[i].equals(target)) {
				return i;
			}
		}
		return -1;
	}

	/**
	 * 数据规模扩大十倍 -> 时间损耗扩大十倍 -> 线性关系
	 * n: 1000000, 100 runs: 0.159666499s
	 * n: 10000000, 100 runs: 1.398736001s
	 */
	public static void main(String[] args) {

		Student[] students = {new Student("张三"),
				new Student("李四"),
				new Student("王五")};

		int index = search(students, new Student("李四"));
		System.out.println(index);
		index = search(students, new Student("张二"));
		System.out.println(index);

		int[] dataSize = {1000000, 10000000};
		for(int n : dataSize) {
			Integer[] data = ArrayGenerator.generateOrderedArray(n);

			long startTime = System.nanoTime();
			for(int k = 0; k < 100; k++) {
				search(data, n);
			}
			long endTime = System.nanoTime();

			double time = (endTime - startTime) / 1000000000.0;
			System.out.println("n: " + n + ", 100 runs: " + time + "s");
		}
	}
}
