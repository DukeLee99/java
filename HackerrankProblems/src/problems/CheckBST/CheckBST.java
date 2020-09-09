package problems.CheckBST;

class Node{
	int data;
	Node left;
	Node right;
	
}
public class CheckBST {
		// TODO Auto-generated constructor stub
		boolean checkNode(Node root, int min, int max){
	        if (root == null) return true;
	        if(root.data < min || root.data>max) return false;
	        return checkNode(root.left, min, root.data-1)&&checkNode(root.right, root.data+1, max);
	    }
	    boolean checkBST(Node root) {
	        return checkNode(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	    }
}
