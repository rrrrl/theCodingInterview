package theCodingInterview4;

import CtCILibrary.TreeNode;

public class Question6 {
	public static TreeNode inorderSucc(TreeNode n) {
		if(n == null)	return null;
		
		if(n.right != null) {
			return leftMostChild(n.right);
		} else {
			TreeNode node = n;
			TreeNode parent = n.parent;
			
			while(parent != null && parent.left != node) {
				node = parent;
				parent = node.parent;
			}
			
			return parent;
		}
		
	}
	
	public static TreeNode leftMostChild(TreeNode n) {
		if(n == null)	return null;
		while(n.left != null) {
			n = n.left;
		}
		return n;
	}
	
	public static void main(String[] args) {
		int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		TreeNode root = TreeNode.createMinimalBST(array);
		for (int i = 0; i < array.length; i++) {
			TreeNode node = root.find(array[i]);
			TreeNode next = inorderSucc(node);
			if (next != null) {
				System.out.println(node.data + "->" + next.data);
			} else {
				System.out.println(node.data + "->" + null);
			}
		}
	}
}
