package datastructure.array;

/**
 * 动态数组
 * @author haif.
 * @date 2021/3/6 19:15
 */
@SuppressWarnings("unchecked")
public class Array<E> {

	/**
	 * 内部数组
	 */
	private E[] data;

	/**
	 * 元素数
	 */
	private int size;

	public Array(int capacity) {
		data = (E[]) new Object[capacity];
		size = 0;
	}

	public Array() {
		this(10);
	}

	/**
	 * 获取数组中元素个数
	 * @return 元素个数
	 */
	public int getSize() {
		return size;
	}

	/**
	 * 获取数组容量
	 * @return 数组容量
	 */
	public int getCapacity() {
		return data.length;
	}

	/**
	 * 判断数组是否为空
	 * @return 是否为空
	 */
	public boolean isEmpty() {
		return size == 0;
	}

	/**
	 * 向所有元素后插入一个新元素
	 * @param e 元素
	 */
	public void addLast(E e) {
		add(size, e);
	}

	/**
	 * 向所有元素前插入一个元素
	 * @param e 元素
	 */
	public void addFirst(E e) {
		add(0, e);
	}

	/**
	 * 向指定位置插入新元素
	 * @param index 索引
	 * @param e 元素
	 */
	public void add(int index, E e) {

		if (index < 0 || index > size) {
			throw new IllegalArgumentException("Add failed. Index is illegal.");
		}

		if (size == data.length) {
			resize(2 * data.length);
		}

		for (int i = size - 1; i >= index; i--) {
			data[i + 1] = data[i];
		}

		data[index] = e;
		size++;
	}

	/**
	 * 获取指定位置元素
	 * @param index 索引值
	 * @return 元素
	 */
	public E get(int index) {
		if (index < 0 || index >= size) {
			throw new IllegalArgumentException("Get failed. Index is illegal.");
		}
		return data[index];
	}

	/**
	 * 获取第一个元素
	 * @return 元素
	 */
	public E getFirst() {
		return get(0);
	}

	/**
	 * 获取最后一个元素
	 * @return 元素
	 */
	public E getLast() {
		return get(size - 1);
	}

	/**
	 * 设置指定位置元素值
	 * @param index 索引
	 * @param e 元素
	 */
	public void set(int index, E e) {
		if (index < 0 || index >= size) {
			throw new IllegalArgumentException("Get failed. Index is illegal.");
		}
		data[index] = e;
	}

	/**
	 * 是否包含指定元素
	 * @param e 元素值
	 * @return 是否包含
	 */
	public boolean contains(E e) {
		for (int i = 0; i < size; i++) {
			if (data[i].equals(e)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * 删除指定位置元素
	 * @return 元素值
	 */
	public E remove(int index) {
		if (index < 0 || index >= size) {
			throw new IllegalArgumentException("Get failed. Index is illegal.");
		}

		E ret = data[index];

		for (int i = index + 1; i < size; i++) {
			data[i - 1] = data[i];
		}

		size--;
		data[size] = null;

		if (size == data.length / 4 && data.length / 2 != 0) {
			resize(data.length / 2);
		}
		return ret;
	}

	/**
	 * 删除第一个元素
	 * @return 元素值
	 */
	public E removeFirst() {
		return remove(0);
	}

	/**
	 * 删除最后一个元素
	 * @return 元素值
	 */
	public E removeLast() {
		return remove(size - 1);
	}

	/**
	 * 删除指定元素（第一个值）
	 * @param e 元素值
	 */
	public void removeElement(E e) {
		int index = find(e);
		if (index != -1) {
			remove(index);
		}
	}

	/**
	 * 查找元素
	 * @param e 元素
	 * @return 索引值
	 */
	public int find(E e) {
		for (int i = 0; i < size; i++) {
			if (data[i].equals(e)) {
				return i;
			}
		}
		return -1;
	}

	/**
	 * 扩缩容
	 * @param newCapacity 新容量
	 */
	private void resize(int newCapacity) {
		E[] newData = (E[])new Object[newCapacity];

		for (int i = 0; i < size; i++) {
			newData[i] = data[i];
		}

		data = newData;
	}

	@Override
	public String toString() {
		StringBuilder res = new StringBuilder();
		res.append(String.format("Array: size = %d, capacity = %d\n", size, data.length));
		res.append("[");
		for (int i = 0; i < size; i++) {
			res.append(data[i]);
			if (i != size -1) {
				res.append(", ");
			}
		}
		res.append("]");
		return res.toString();
	}

	public static void main(String[] args) {
		Array<Integer> array = new Array<>(10);
		for (int i = 0; i < 10; i++) {
			array.addLast(i);
		}
		System.out.println(array.toString());

		array.add(1, 100);
		System.out.println(array.toString());

		array.addFirst(-1);
		System.out.println(array.toString());

		array.remove(2);
		System.out.println(array.toString());

		array.removeElement(4);
		System.out.println(array.toString());

		array.removeFirst();
		System.out.println(array.toString());
	}
}
