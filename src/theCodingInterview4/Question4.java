package theCodingInterview4;

import CtCILibrary.*;

public class Question4 {
	public static int checkHeight(TreeNode root) {
		if(root == null)	return -1;
		
		int left = checkHeight(root.left);
		if(left == Integer.MIN_VALUE)	return Integer.MIN_VALUE;
		
		int right = checkHeight(root.right);
		if(right == Integer.MIN_VALUE)	return Integer.MIN_VALUE;
		
		int height = left - right;
		if(Math.abs(height) > 1) {
			return Integer.MIN_VALUE;
		} else {
			return Math.max(left, right) + 1;
		}
	}
	
	public static boolean isBalanced(TreeNode root) {
		return checkHeight(root) != Integer.MIN_VALUE;
	}
	
	public static void main(String[] args) {
		// Create balanced tree
		int[] array = {0, 1, 2, 3, 5, 6, 7, 8, 9, 10};
		TreeNode root = TreeNode.createMinimalBST(array);

		
		System.out.println("Is balanced? " + isBalanced(root));
		
		root.insertInOrder(4); // Add 4 to make it unbalanced

		System.out.println("Is balanced? " + isBalanced(root));
	}
}
