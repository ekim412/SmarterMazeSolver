/**
 * LinkedPriorityQueue class is a linked queue with Priority Queue implementation.
 * Elements stored from lowest to highest priority. Lowest value at the front of the 
 * queue.
 * 
 * @author Edward Kim 
 */
public class LinkedPriorityQueue<T> extends java.lang.Object implements PriorityQueueADT<T> {
	
	private int count;
	private PriorityNode<T> head, tail;
	
	/**
	 * Empty queue.
	 */
	public LinkedPriorityQueue(){
		count = 0;
		head = tail = null;
	}
	
	/**
	 * Do not need to enqueue- just need to enqueue with priority.
	 */
	public void enqueue (T element){
		return;
	}
	
	/**
	 * Add element to the priority queue depending on its priority value.
	 */
	public void enqueue (T element, double x){
		PriorityNode<T>newN = new PriorityNode<T>(element, x);
		//If queue is empty.
		if(isEmpty()){
			head = newN;
			tail = newN;
		}
		//If queue only has 1 item.
		else if(count == 1){
			if(newN.getPriority() > head.getPriority()){
				newN.setNext(head);
				head = newN;
			}
			else{
				head.setNext(newN);
				tail = newN;
			}
		}
		else{
			boolean endQueue = false;		//True if it is end of queue.
			boolean foundPosition = false;	//True if found a position to insert.
			
			PriorityNode<T>currentN = head;
			//Traverse the queue until newN's priority is larger than currentN
			while((!foundPosition) && (!endQueue) && 
					(newN.getPriority() > currentN.getPriority())){
				
				if((currentN.getNext() != null) && 
						(newN.getPriority() <= currentN.getNext().getPriority())){
					currentN = currentN.getNext();
				}
				//If next == null, means end of queue has been reached.
				else if(currentN.getNext() == null){
					endQueue = true;
				}
				else{
					foundPosition = true;
				}
			}
			//Add newN to the queue.
			if(newN.getPriority() > head.getPriority()){
				newN.setNext(head);
				head = newN;
			}
			else if(foundPosition){
				currentN.setNext(newN);
				tail = newN;
			}
			else{
				newN.setNext(currentN.getNext());
				currentN.setNext(newN);
			}
		}
		count++;
	}
	
	/**
	 * Remove element at the front and return a reference to it.
	 * @return element at the front that will be removed.
	 * @throws EmptyCollectionException if collection is empty.
	 */
	public T dequeue() throws EmptyCollectionException{
		if(isEmpty()){
			throw new EmptyCollectionException("queue");
		}
		
		T firstEl = head.getElement();
		head = head.getNext();
		count--;
		
		if(isEmpty()){
			tail = null;
		}
				
		return firstEl;
	}
	
	/**
	 * Return a reference to the first element of the queue.
	 * @return reference to the first element of the queue.
	 * @throws EmptyCollectionException if collection is empty.
	 */
	public T first() throws EmptyCollectionException{
		if(count == 0){
			throw new EmptyCollectionException("queue");
		}
		return head.getElement();
	}
	
	/**
	 * True or false regarding if the queue is empty or not.
	 * @return true if count is 0 or false if queue is not empty.
	 */
	public boolean isEmpty(){
		return count == 0;
	}
	
	/**
	 * Return the number of elements in the queue.
	 * @return integer value of the queue's size.
	 */
	public int size(){
		return count;
	}
	
	/**
	 * Return a string representation of the queue.
	 * @returnthe string representation of the queue.
	 */
	public String toString(){
		String stringQueue = "";
		PriorityNode<String>queueFront = (PriorityNode<String>)head;
		
		for(int i = 0; i < count; i++){
			stringQueue += queueFront.toString() + "\n";
		}
		return stringQueue;
	}
}
