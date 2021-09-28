/**
 * Notation class has a method infixToPostfix to convert infix notation to postfix notation that will take in a string and return a string,
 * a method postfixToInfix to convert postfix notation to infix notation that will take in a string and return a string,
 * and a method to evaluatePostfix to evaluate the postfix expression
 * 
 * @author Justin Hixson
 */
public class Notation {

	private Notation() {
	}
	/**
	 * Convert an infix expression into a postfix expression
	 * @param infix the infix expression in string format
	 * @return the postfix expression in string format
	 * @throws InvalidNotationFormatException if the infix expression format is invalid
	 */
	public static String convertInfixToPostfix(String infix) throws InvalidNotationFormatException {
		NotationQueue<Character> queue = new NotationQueue<>(infix.length());
		NotationStack<Character> stack = new NotationStack<>(infix.length());

		char[] string = infix.toCharArray();

		try {
			for (char character : string) {
				if (Character.isDigit(character)) {
					queue.enqueue(character);
				}
				if (character == '(') {
					stack.push(character);
				}
				if (character == '*' || character == '/' || character == '+' || character == '-') {
					if (!queue.isEmpty()) {
						char top = stack.top();
						if (top == '*' || top == '/' || character == '-' && top == '-' || 
								character == '-' && top == '+' || character == '+' && top == '-' || character == '+' && top == '+') {
							queue.enqueue(stack.pop());
						}
					}
					stack.push(character);
					continue;
				}
				if (character == ')') {
					while (stack.top() != '(') {
						queue.enqueue(stack.pop());
						if (stack.top() == null) {
							throw new InvalidNotationFormatException();
						}
					}
					stack.pop();
				}
			}
		} catch (QueueOverflowException | StackOverflowException | StackUnderflowException e) {
			throw new InvalidNotationFormatException();
		}
		return queue.toString();
	}
	/**
	 * Convert the Postfix expression to the Infix expression
	 * @param postfix the postfix expression in string format
	 * @return the infix expression in string format
	 * @throws InvalidNotationFormatException if the postfix expression format is invalid
	 */
	public static String convertPostfixToInfix(String postfix) throws InvalidNotationFormatException {
		NotationStack<String> stack = new NotationStack<>(postfix.length());

		try {
			for (int i = 0; i < postfix.length(); i++) {
				char current = postfix.charAt(i);

				if (Character.isDigit(current)) {
					stack.push(Character.toString(current));
				}
				if (current == '*' || current == '/' || current == '+' || current == '-') {
					if (stack.size() < 2) {
						throw new InvalidNotationFormatException();
					}
					String first = stack.pop();
					String second = stack.pop();
					String s = "(" + second + current + first + ")";
					stack.push(s);
				}
			}

		} catch (StackUnderflowException | StackOverflowException e) {
			throw new InvalidNotationFormatException();
		}
		if (stack.size() > 1) {
			throw new InvalidNotationFormatException();
		}
		return stack.toString();
	}
	/**
	 * Evaluates a postfix expression from a string to a double
	 * @param postfixExpr the postfix expression in String format
	 * @return the evaluation of the postfix expression as a double
	 * @throws InvalidNotationFormatException if the postfix expression format is invalid
	 */
	public static double evaluatePostfixExpression(String postfixExpr) throws InvalidNotationFormatException {
		NotationStack<Double> stack = new NotationStack<>(postfixExpr.length());
		char[] string = postfixExpr.toCharArray();

		try {
			for (char character : string) {
				if (Character.isDigit(character) || character == '(') {
					stack.push(Double.parseDouble(Character.toString(character)));
				}
				if (character == '*' || character == '/' || character == '+' || character == '-') {
					if (stack.size() < 2) {
						throw new InvalidNotationFormatException();
					}
					double right = stack.pop();
					double left = stack.pop();

					switch (character) {
					case '*':
						stack.push(left * right);
						break;
					case '/':
						stack.push(left / right);
						break;
					case '+':
						stack.push(left + right);
						break;
					case '-':
						stack.push(left - right);
						break;
					}
				}
			}
		} catch (StackOverflowException | StackUnderflowException e) {
			throw new InvalidNotationFormatException();
		}
		if (stack.size() > 1) {
			throw new InvalidNotationFormatException();
		}
		return Double.parseDouble(stack.toString());
	}
}
