package lab4;

import java.util.Arrays;

/**
 * use a  array to do a PQ
 * @author Luo Zeting ID:16938158
 *
 */
public class PriorityQueueUsingArray {

	Nodes[] array;//array use for do the queue

	// set up the array
	PriorityQueueUsingArray(int size) {
		this.array = new Nodes[size + 1];
	}

	/**
	 * public user interface insert
	 * @param key Priority
	 * @param value value
	 * @return is insert finish?
	 */
	public boolean insert(int key, int value) {
		/*
		 * check is the queue full
		 * if yes, display error
		 * if not, insert 
		 */
		return this.checkFull() ? this.queueFullError() : this.doInsert(key, value);
	}

	/**
	 * do dequeue
	 * @return return the value for highest Priority node
	 */
	public int dequeue() {
		int lowPowerNodeValue = Integer.MIN_VALUE;
		try {
			lowPowerNodeValue = doDequeue(0);
		} catch (NullPointerException e) {
			System.out.print("Queue is empty, dequeue false return Integer.MIN_VALUE : ");
		}
		return lowPowerNodeValue;
	}
	
	/**
	 * do queue
	 * @param index the index of highest Priority node
	 * @return value of the node
	 * @throws NullPointerException if we can get this node
	 */
	private int doDequeue(int index) throws NullPointerException {
		int temp = this.getNodeValue(0);
		this.moveNodesForward();
		this.removeLast();
		return temp;
	}

	/**
	 * display error to the console
	 * @return false to enqueue
	 */
	private boolean queueFullError() {
		System.out.println("Queue Full!!!");
		return false;
	}

	/**
	 * find the last not null element
	 * @return the last not null index 
	 */
	public int findLast() {
		int result = 0;
		while (!checkHaveThisNode(result))
			result++;

		return result;
	}

	/**
	 * do insert
	 * @param key Priority of the node
	 * @param value of the node
	 * @return true, insert is done
	 */
	private boolean doInsert(int key, int value) {
		this.array[this.lastNotNull()] = new Nodes(key, value);
		Arrays.sort(this.array, 0, this.lastNotNull());
		return true;
	}

	/**
	 * return the last not null index
	 * @return 0 if we do not have this node , else the last index of not null
	 */
	private int lastNotNull() {
		return (!this.checkEmpty()) ? findLast() : 0;
	}

	/**
	 * check the array is full
	 * @return the array is full?
	 */
	private boolean checkFull() {
		return this.array.length - 1 == this.lastNotNull();
	}
	

	/**
	 * check the array is empty
	 * @return
	 */
	private boolean checkEmpty() {
		return this.array[0] == null;
	}
	
	/**
	 * check a index is null or not
	 * @param index to check
	 * @return is null or not
	 */
	private boolean checkHaveThisNode(int index) {
		return this.array[index] == null;
	}

	
	private int getNodeValue(int index) {
		return this.array[index].value;
	}

	private void removeLast() {
		this.array[this.lastNotNull()] = null;
	}

	private void moveNodesForward() {
		for (int n = 1; n != this.array.length; n++)
			this.array[n - 1] = this.array[n];
	}

	public String toString() {
		return Arrays.toString(this.array);
	}
}
