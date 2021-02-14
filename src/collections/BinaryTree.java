package collections;

public class BinaryTree {
    public int maxDepth(Zode node) {    
        if ( node == null )
            return 0;
            
        return Math.max(maxDepth( node.lNode ), maxDepth(node.rNode)) + 1;
    }

    class Zode {
    	Zode lNode;
    	Zode rNode;
    }

    public static void main(String[] args) {
    	
    }
}


/*
  A
  |\ 
  B C
    |
    D
     
     
     
     
*/