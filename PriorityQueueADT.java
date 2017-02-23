/**
 * QueueADT defines the interface to a queue collection.
 *
 */

public interface PriorityQueueADT<T>
{

   /**  
    * Adds one element to the rear of this queue. 
    * 
    * @param element  the element to be added to the rear of this queue  
    */
   public void enqueue (T element);

   /**
    * Adds the specified element to the priority queue in the proper location based on priority.
    *
    * @param element  the element to be added to the rear of this queue
    */
   public void enqueue (T element, double p);
   
   /**  
    * Removes and returns the element at the front of this queue.
    * 
    * @return  the element at the front of this queue
    */
   public T dequeue();

   /**  
    * Returns without removing the element at the front of this queue.
    *
    * @return  the first element in this queue
    */
   public T first();
   
   /**  
    * Returns true if this queue contains no elements.
    * 
    * @return  true if this queue is empty
    */
   public boolean isEmpty();

   /**  
    * Returns the number of elements in this queue. 
    * 
    * @return  the integer representation of the size of this queue
    */
   public int size();

   /**  
    * Returns a string representation of this queue. Should include the priority and some bit of information about the element.
	* Use this method to make sure the queue is always ordered by priority!
    *
    * @return  the string representation of this queue
    */
   public String toString();
}
