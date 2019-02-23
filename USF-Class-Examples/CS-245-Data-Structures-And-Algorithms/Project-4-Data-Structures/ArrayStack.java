/* File:	ArrayStack
 * Purpose:	Implement a Stack using an array with methods push, pop, peek, and empty
 */
public class ArrayStack implements Stack {

	private int length = 100;
	private Object[] stack = new Object[length];
	
	@Override
	/* Method:	push(Object item)
	 * Purpose:	place an Object item at the end of the stack, resize if necessary
	 * 
	 * Args:	Object item:	item to place on stack
	 */
	public void push(Object item) {
		for (int i = 0; i < stack.length; i++) {
			if (stack[i] == null) {
				stack[i] = item;
				return;
			}
		}
		
		length *= 2;
		Object[] newStack = new Object[length];
		for (int i = 0; i < stack.length; i++) {
			newStack[i] = stack[i];
		}
		stack = newStack;
	} /*	push	*/

	@Override
	/* Method: 	pop()
	 * Purpose:	remove last item on stack to process
	 * 
	 * Args:	none
	 */
	public Object pop() {
		for (int i = stack.length - 1; i >= 0; i--) {
			if (stack[i] != null) {
				Object item = stack[i];
				stack[i] = null;
				return item;
			}
		}
		return null;
	} /*	pop		*/

	@Override
	public Object peek() {
		return stack[0];
	}

	@Override
	/* Method:	empty()
	 * Purpose:	Check if stack array is empty
	 * 
	 * Args: 	none
	 */
	public boolean empty() {
		if (stack[0] == null) {
			return true;
		}
		return false;
	} /*	empty	*/

}
