package interview;

public class ReverseLinkedList {
	static Node origList;
	static {
		Node four = new Node(4,null);
		Node three = new Node(3,four);
		Node two = new Node(2,three);
		Node one = new Node(1,two);
		origList = new Node(0,one);
	}
	
	public static Node reverseList() {
		Node reversedPart = null;
		Node current =  origList;
		
		while (current != null) {
			Node next = current.next;
			current.next = reversedPart;
			reversedPart = current;
			current = next;
		}
		return reversedPart;
	}
	
	public static void printList(Node list) {
		Node head = list;
		while (head != null) {
			System.out.println(head.data);
			head = head.next;
		}
	}
	
	public static void main(String[] args) {
		ReverseLinkedList.printList(origList);
		System.out.println("done");
		ReverseLinkedList.printList(reverseList());
	}
}

class Node {
	public int data;
	public Node next;
	public Node(int data, Node next) {
		this.data = data;
		this.next = next;
	}
}