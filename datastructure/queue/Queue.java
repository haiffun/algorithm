package datastructure.queue;

/**
 * 队列
 *
 * @author haif.
 * @date 2021/3/6 22:16
 */
public interface Queue<E> {

    /**
     * 入队
     *
     * @param e 元素
     */
    void enqueue(E e);

    /**
     * 出队
     *
     * @return 元素
     */
    E dequeue();

    /**
     * 查看队首元素
     *
     * @return 元素
     */
    E getFront();

    /**
     * 获取队列元素个数
     *
     * @return 队列元素个数
     */
    int getSize();

    /**
     * 判断队列是否为空
     *
     * @return 队列是否为空
     */
    boolean isEmpty();
}
