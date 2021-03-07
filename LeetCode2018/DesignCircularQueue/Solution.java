import java.util.*;
public class Solution{
    public static void main(String args[]){
        Solution sol = new Solution();
    }
}
class MyCircularQueue {
	int[] array;
	int size;
	int count;
	int head;
	int tail;

	/** Initialize your data structure here. Set the size of the queue to be k. */
	public MyCircularQueue(int k) {
		this.array = new int[k];
		this.size = k;
		this.count = 0;
		this.head = 0;
		this.tail = -1;
	}

	/**
	 * Insert an element into the circular queue. Return true if the operation is
	 * successful.
	 */
	public boolean enQueue(int value) {
		if (isFull()) {
			return false;
		}

		tail = (tail + 1) % size;
		array[tail] = value;
		count++;
		return true;
	}

	/**
	 * Delete an element from the circular queue. Return true if the operation is
	 * successful.
	 */
	public boolean deQueue() {
		if (isEmpty())
			return false;
		head = (head + 1) % size;
		count--;
		return true;

	}

	/** Get the front item from the queue. */
	public int Front() {
		return count > 0 ? array[head] : -1;
	}

	/** Get the last item from the queue. */
	public int Rear() {
		return count > 0 ? array[tail] : -1;
	}

	/** Checks whether the circular queue is empty or not. */
	public boolean isEmpty() {
		return count == 0;
	}

	/** Checks whether the circular queue is full or not. */
	public boolean isFull() {
		return size == count;
	}

	public static void main(String[] args) {
		MyCircularQueue q = new MyCircularQueue(3);
		System.out.println(q.enQueue(1));
		System.out.println(q.enQueue(2));
		System.out.println(q.enQueue(3));
		System.out.println(q.enQueue(4));
		System.out.println(q.Rear());
		System.out.println(q.isFull());
		System.out.println(q.deQueue());
		System.out.println(q.enQueue(4));
		System.out.println(q.Rear());
//    	System.out.println(q.enQueue(6));
//    	System.out.println(q.Rear());
//    	System.out.println(q.Rear());
//    	System.out.println(q.deQueue());
	}
}

