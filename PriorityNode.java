/**
 * Priority node class creates a node with priority attribute.
 * 
 * @author Edward Kim
 */
public class PriorityNode<E> extends java.lang.Object {
	
	private PriorityNode<E>next;
	private E element;
	private double priority;
	
	/**
	 * Creates a new node with just an element.
	 * @param elem the element.
	 */
	public PriorityNode(E elem){
		next = null;
		element = elem;
	}
	
	/**
	 * Create node that stores priority to the element.
	 * @param elem the element.
	 * @param p the priority value.
	 */
	public PriorityNode(E elem, double p){
		next = null;
		element = elem;
		priority = p;
	}
	
	/**
	 * Return the next node.
	 * @return the next node.
	 */
	public PriorityNode<E> getNext(){
		return next;
	}
	
	/**
	 * Set node after the current one.
	 * @param node the node that will be after the current one.
	 */
	public void setNext(PriorityNode<E> node){
		next = node;
	}
	
	/**
	 * Return the element of the node.
	 * @return the element of the node.
	 */
	public E getElement(){
		return element;
	}
	
	/**
	 * Set the element of the node.
	 * @param elem the element to be stored to this node.
	 */
	public void setElement(E elem){
		element = elem;
	}
	
	/**
	 * Return the priority of the node.
	 * @return the priority value stored for the node.
	 */
	public double getPriority(){
		return priority;
	}
	
	/**
	 * Set the priority stored for the node.
	 * @param setPNode the priority value to be stored for the node.
	 */
	public void setPriority(double setPNode){
		priority = setPNode;
	}
	
	/**
	 * Returns the string version of the node.
	 */
	public String toString(){
		String stringNode = "" + element.toString() + " (Priority:" + priority + ")";
		return stringNode;
	}
}
