package datastructure.queue;

/**
 * 双端队列
 *
 * @author haif.
 * @date 2021/3/15 20:49
 */
public class Deque<E> implements Queue<E> {

    private E[] data;

    private int front, tail;

    private int size;

    public Deque(int capacity) {
        data = (E[])new Object[capacity];

        front = 0;
        tail = 0;
        size = 0;
    }

    public Deque() {
        this(10);
    }

    @Override
    public void enqueue(E e) {
        if (size == getCapacity()) {
            resize(getCapacity() * 2);
        }

        data[tail] = e;
        tail = (tail + 1) % data.length;
        size++;
    }

    @Override
    public E dequeue() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Cannot dequeue from empty queue.");
        }

        E ret = data[front];
        data[front] = null;
        front = (front + 1) % data.length;
        size--;

        if (size == getCapacity() / 4 && getCapacity() / 2 != 0) {
            resize(getCapacity() / 2);
        }

        return ret;
    }

    @Override
    public E getFront() {
        return null;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    public int getCapacity() {
        return data.length;
    }

    public void addFront(E e) {
        if (size == getCapacity()) {
            resize(getCapacity() * 2);
        }

        data[(front - 1 + data.length) % data.length] = e;
        front = (front - 1 + data.length) % data.length;
        size++;
    }

    public E removeFront() {
        return dequeue();
    }

    public void addLast(E e) {
        enqueue(e);
    }

    public E removeLast() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Cannot removeLast from empty queue.");
        }

        E ret = data[tail];
        data[tail] = null;
        tail = (tail - 1 + data.length) % data.length;
        size--;

        if (size == getCapacity() / 4 && getCapacity() / 2 != 0) {
            resize(getCapacity() / 2);
        }

        return ret;
    }

    private void resize(int capacity) {
        E[] newData = (E[]) new Object[capacity];
        for (int i = 0; i < size; i++) {
            newData[i] = data[(i + front) % data.length];
        }

        data = newData;
        front = 0;
        tail = size;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("Deque: size = %d, capacity = %d\n", size, getCapacity()));
        res.append("front [");
        for (int i = 0; i < size; i++) {
            res.append(data[(i + front) % data.length]);
            if ((i + front + 1) % data.length != tail) {
                res.append(", ");
            }
        }
        res.append("] tail");
        return res.toString();
    }

    public static void main(String[] args) {
        Deque<Integer> queue = new Deque<>();
        for (int i = 0; i < 10; i++) {
            queue.enqueue(i);
            System.out.println(queue);

            if (i % 3 == 2) {
                queue.dequeue();
                System.out.println(queue);
            }
        }

        queue.addFront(10);
        System.out.println(queue);
        queue.addLast(11);
        System.out.println(queue);
        queue.removeLast();
        System.out.println(queue);
        queue.removeFront();
        System.out.println(queue);
    }
}
