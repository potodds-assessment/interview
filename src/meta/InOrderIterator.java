package meta;

import java.util.Stack;

public class InOrderIterator {
    Stack<Node> stk = new Stack<>();

    public InOrderIterator(Node node) {
        leftInorder(node);
    }

    public void leftInorder(Node node) {
        if (node == null)
            return;

        stk.push(node);
        if (node.left != null)
            leftInorder(node.left);
        else   
            return;
    }

    public int next() {
        if (stk.isEmpty())
            return -1;

        Node n = stk.pop();
        leftInorder(n.right);

        return n.value;
    }

    public boolean hasNext() {
        if (stk.isEmpty())
            return false;
        else
            return true;
    }

    public void inorder(Node node) {
        if (node == null)
            return;

        if (node.left != null) inorder(node.left);
        System.out.print(node.value + " ");
        if (node.right != null) inorder(node.right);
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(6);       

        InOrderIterator app = new InOrderIterator(root);
        while (app.hasNext()) {
            System.out.print(app.next() + " ");
        }
        System.out.println();
        
        // app.inorder(root);
        // System.out.println();
    }    
}

class Node {
    int value;
    Node left;
    Node right;

    Node(int value) {
        this.value = value;
    }

    Node(int value, Node left, Node right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }
}