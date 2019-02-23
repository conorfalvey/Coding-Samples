/* File:	ArrayQueue.java
 * Purpose:	Implement a Queue using an array with dequeue, enqueue, and empty functions
 */
public class ArrayQueue implements Queue {

	private int length = 100;
	private Object[] queue = new Object[length];
	
	@Override
	/* Method:	dequeue()
	 * Purpose:	Remoe first Object from queue
	 * 
	 * Args:	none
	 */
	public Object dequeue() {
		Object item = queue[0];
		
		for (int i = 1; i < queue.length; i++) {
				queue[i-1] = queue[i];
		}
		
		return item;
	} /*	dequeue		*/

	@Override
	/* Method:	enqueue(Object item)
	 * Purpose	Place Object item in queue at end, resize array if necessary
	 * 
	 * Args:	Object item:	item to place in queue
	 */
	public void enqueue(Object item) {
		for (int i = 0; i < queue.length; i++) {
			if (queue[i] == null) {
				queue[i] = item;
				return;
			}
		}
		
		length *= 2;
		Object[] newQueue = new Object[length];
		for (int i = 0; i < queue.length; i++) {
			newQueue[i] = queue[i];
		}
		queue = newQueue;

	} /*	enqueue		*/

	@Override
	/* Method:	empty()
	 * Purpose:	check if queue is empty
	 * 
	 * Args:	none
	 */
	public boolean empty() {
		if (queue[0] == null) {
			return true;
		}
		return false;
	} /*	empty	*/

}
