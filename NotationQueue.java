import java.util.ArrayList;
/**
 * Queue data structure
 * Implements StackInterface
 * 
 * @author Justin Hixson
 * 
 * @param <T> data type
 */
public class NotationQueue<T> implements QueueInterface<T> {

	private int size;
	private ArrayList<T> queue;
	/**
	 * Takes an int as the size of the queue
	 * @param size the size of the queue
	 */
	public NotationQueue(int size) {
		queue = new ArrayList<>(size);
		this.size = size;
	}
	/**
	 * Default constructor - uses a default as the size of the queue
	 */
	public NotationQueue() {
		queue = new ArrayList<>(5);
		size = 5;
	}
	/**
	 * Determines if Queue is empty
	 * @return true if Queue is empty, false if not
	 */
	@Override
	public boolean isEmpty() {
		return queue.isEmpty();
	}
	/**
	 * Determines of the Queue is full
	 * @return true if Queue is full, false if not
	 */
	@Override
	public boolean isFull() {
		return queue.size() == size;
	}
	/**
	 * Deletes and returns the element at the front of the Queue
	 * @return the element at the front of the Queue
	 * @throws QueueUnderflowException if queue is empty
	 */
	@Override
	public T dequeue() throws QueueUnderflowException {
		if(isEmpty()) {
			throw new QueueUnderflowException();
		}
		return queue.remove(0);
	}
	/**
	 * Number of elements in the Queue
	 * @return the number of elements in the Queue
	 */
	@Override
	public int size() {
		return queue.size();
	}
	/**
	 * Adds an element to the end of the Queue
	 * @param e the element to add to the end of the Queue
	 * @return true if the add was successful, false if not
	 * @throws QueueOverflowException if queue is full
	 */
	@Override
	public boolean enqueue(T e) throws QueueOverflowException {
		if(isFull()) {
			throw new QueueOverflowException();
		}
		return queue.add(e);
	}
	/**
	 * Returns the string representation of the elements in the Queue, 
	 * the beginning of the string is the front of the queue
	 * @return string representation of the Queue with elements
	 */
	@Override
	public String toString() {
		String string = "";

		for (T e: queue) {
			string += e;
		}
		return string;
	}
	/**
	 * Returns the string representation of the elements in the Queue, the beginning of the string is the front of the queue
	 * Place the delimiter between all elements of the Queue
	 * @return string representation of the Queue with elements separated with the delimiter
	 */
	@Override
	public String toString(String delimiter) {
		String string = "";

		for(T e : queue) {
			string += e.toString() + delimiter;
		}
		return string.substring(0, string.length() - 1);
	}
	/**
	 * Fills the Queue with the elements of the ArrayList, First element in the ArrayList
	 * is the first element in the Queue
	 * YOU MUST MAKE A COPY OF LIST AND ADD THOSE ELEMENTS TO THE QUEUE, if you use the
	 * list reference within your Queue, you will be allowing direct access to the data of
	 * your Queue causing a possible security breech.
	 * @param list elements to be added to the Queue
	 */
	@Override
	public void fill(ArrayList<T> list) {
		queue.clear();

		for(T e : list) {
			queue.add(e);
		}
	}
}
