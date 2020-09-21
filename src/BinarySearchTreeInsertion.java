/*
 * You are given a pointer to the root of a binary search tree and values to be inserted into the tree. 
 * Insert the values into their appropriate position in the binary search tree and return the root of 
 * the updated binary tree. You just have to complete the function.
 */

class Node {
	private int data;
	private Node right;
	private Node left;
	
	Node(int data) {
		this.data = data;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public Node getRight() {
		return right;
	}

	public void setRight(Node right) {
		this.right = right;
	}

	public Node getLeft() {
		return left;
	}

	public void setLeft(Node left) {
		this.left = left;
	}
	
}

public class BinarySearchTreeInsertion {
	
	public static void main(String[] args) {
		Node root = new Node(4);
		root.setLeft(new Node(2));
		root.getLeft().setLeft(new Node(1));
		root.getLeft().setRight(new Node(3));
		root.setRight(new Node(7));
		insert(root, 6);
		
	}
	
	public static Node insert(Node root,int data) {
		
		if (root == null)
			return new Node(data);
        
		if (data > root.getData())
			root.setRight(insert(root.getRight(), data));
		else
			root.setLeft(insert(root.getLeft(), data));

        return root;
    }

}
