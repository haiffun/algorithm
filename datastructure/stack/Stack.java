package datastructure.stack;

/**
 * 栈
 * @author haif.
 * @date 2021/3/6 21:14
 */
public interface Stack<E> {

	/**
	 * 入栈
	 * @param e 元素
	 */
	void push(E e);

	/**
	 * 出栈
	 * @return 元素
	 */
	E pop();

	/**
	 * 查看栈顶元素
	 * @return 栈顶元素
	 */
	E peek();

	/**
	 * 栈中元素个数
	 */
	int getSize();

	/**
	 * 栈是否为空
	 * @return 是否为空
	 */
	boolean isEmpty();
}
