/**	
 * Occurs when a push method is called on a full stack
 * 
 * @author Justin Hixson
 */
public class StackUnderflowException extends Exception {

	public StackUnderflowException() {
		super("Stack Underflow");
	}
}
