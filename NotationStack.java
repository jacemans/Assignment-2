import java.util.ArrayList;
/**
 * Stack data structure
 * Implements StackInterface
 * 
 * @author Justin Hixson
 * 
 * @param <T> data type
 */
public class NotationStack<T> implements StackInterface<T> {

	private int size;
	private ArrayList<T> stack;
	/**
	 * takes an int as the size of the queue
	 * @param size the size of the queue
	 */
	public NotationStack(int size) {
		stack = new ArrayList<>(size);
		this.size = size;
	}
	/**
	 * default constructor - uses a default as the size of the queue
	 */
	public NotationStack() {
		stack = new ArrayList<>(5);
		size = 5;
	}
	/**
	 * Determines if Stack is empty
	 * @return true if Stack is empty, false if not
	 */
	@Override
	public boolean isEmpty() {
		return stack.isEmpty();
	}
	/**
	 * Determines if Stack is full
	 * @return true if Stack is full, false if not
	 */
	@Override
	public boolean isFull() {
		return stack.size() == size;
	}
	/**
	 * Deletes and returns the element at the top of the Stack
	 * @return the element at the top of the Stack
	 * @throws StackUnderflowException if stack is empty
	 */
	@Override
	public T pop() throws StackUnderflowException {
		if (isEmpty()) {
			throw new StackUnderflowException();
		}		
		return stack.remove(stack.size() - 1);
	}
	/**
	 * Returns the element at the top of the Stack, does not pop it off the Stack
	 * @return the element at the top of the Stack
	 * @throws StackUnderflowException if stack is empty
	 */
	@Override
	public T top() throws StackUnderflowException {
		if (isEmpty()) {
			throw new StackUnderflowException();
		}		
		return stack.get(stack.size() - 1);
	}
	/**
	 * Number of elements in the Stack
	 * @return the number of elements in the Stack
	 */
	@Override
	public int size() {
		return stack.size();
	}
	/**
	 * Adds an element to the top of the Stack
	 * @param e the element to add to the top of the Stack
	 * @return true if the add was successful, false if not
	 * @throws StackOverflowException if stack is full
	 */
	@Override
	public boolean push(T e) throws StackOverflowException {
		if (isFull()) {
			throw new StackOverflowException();
		}
		return stack.add(e);
	}
	/**
	 * Returns the elements of the Stack in a string from bottom to top, the beginning 
	 * of the String is the bottom of the stack
	 * @return an string which represent the Objects in the Stack from bottom to top
	 */
	@Override
	public String toString() {
		String string = "";

		for (T e: stack) {
			string += e;
		}
		return string;
	}
	/**
	 * Returns the string representation of the elements in the Stack, the beginning of the 
	 * string is the bottom of the stack
	 * Place the delimiter between all elements of the Stack
	 * @return string representation of the Stack from bottom to top with elements 
	 * separated with the delimiter
	 */
	@Override
	public String toString(String delimiter) {
		String string = "";

		for(T e : stack) {
			string += e.toString() + delimiter;
		}
		return string.substring(0, string.length() - 1);
	}
	/**
	  * Fills the Stack with the elements of the ArrayList, First element in the ArrayList
	  * is the first bottom element of the Stack
	  * YOU MUST MAKE A COPY OF LIST AND ADD THOSE ELEMENTS TO THE STACK, if you use the
	  * list reference within your Stack, you will be allowing direct access to the data of
	  * your Stack causing a possible security breech.
	  * @param list elements to be added to the Stack from bottom to top
	  */
	@Override
	public void fill(ArrayList<T> list) {
		stack.clear();

		for(T e : list) {
			stack.add(e);
		}
	}
}
