package collections;

public class LinkedList {

	static Node head;
	
	static class Node {
		int data;
		boolean visited;
		Node next;
		
		Node(int d) {
			data = d;
			next = null;
			visited = false;			
		}
	}
	
	static public void push(int data) {
		Node node = new Node(data);
		
		node.next = head;
		
		head = node;
	}
	
	static public boolean detectLoop(Node h) {
		while ( h != null ) {
			if ( h.visited == true )
				return true;
			
			h.visited = true;
			
			h = h.next;
		}
		return false;
	}
	
	public static void main(String[] args) {
		LinkedList llist = new LinkedList();
		
		llist.push(20);
		llist.push(40);
		llist.push(15);
		llist.push(35);
		
//		llist.head.next.next.next.next = llist.head;
		
		System.out.println( detectLoop( llist.head ) );
	}
	
}
