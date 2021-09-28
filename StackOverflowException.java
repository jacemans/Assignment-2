/**
 * Occurs when a top or pop method is called on an empty stack
 * 
 * @author Justin Hixson
 */
public class StackOverflowException extends Exception {

	public StackOverflowException() {
		super("Stack Overflow");
	}
}
