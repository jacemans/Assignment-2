/**
 * Occurs when a enqueue method is called on a full queue
 * 
 * @author Justin Hixson
 */
public class QueueUnderflowException extends Exception {

	public QueueUnderflowException() {
		super("Queue Underflow");
	}
}
