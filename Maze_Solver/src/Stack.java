
public class Stack<T> {

	private class Node<T>{
		public T data;
		public Node<T>next=null;
		public Node() {}
		public Node(T d) {data=d;}
	}
	
	
	private Node<T> top=null;
	public boolean isEmpty() {
		return top==null;
	}
	public boolean isFull() {return false;}
	
	public T pop() {
		if(isEmpty()) {
			System.exit(-1);
		}
		T e=top.data;
		top=top.next;
		return e;
	}
	public void push(T e) {
		Node<T> newNode=new Node<T>(e);
		newNode.next=top;
		top=newNode;
	}
	
	public T peek() {
		if(isEmpty())
			System.exit(-1);
		return top.data;
	}
	@Override
	public String toString() {
		String str="top\n";
		Node<T> w=top;
		while(w!=null) {
			str+=w.data+"\n";
			w=w.next;
		}
		return str;
	}
	
}
