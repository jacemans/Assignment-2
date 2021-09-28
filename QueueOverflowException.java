/**
 * Occurs when a dequeue method is called on an empty queue
 * 
 * @author Justin Hixson
 */
public class QueueOverflowException extends Exception {

	public QueueOverflowException() {
		super("Queue Overflow");
	}
}
