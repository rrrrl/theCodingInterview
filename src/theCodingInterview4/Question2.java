package theCodingInterview4;

import CtCILibrary.*;

public class Question2 {
	
	public static TreeNode createMinimalBST(int[] arr, int start, int end) {
		if(end < start) return null;
		int mid = (start + end) / 2;
		TreeNode tn = new TreeNode(arr[mid]);
		tn.left = createMinimalBST(arr, start, mid-1);
		tn.right = createMinimalBST(arr, mid+1, end);
		return tn;
	}
	
	public static TreeNode createMinimalBST(int[] array) {
		return createMinimalBST(array, 0, array.length-1);
	}
	
	public static void main(String[] args) {
		int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

		TreeNode root = createMinimalBST(array);
		System.out.println("Root? " + root.data);
		System.out.println("Created BST? " + root.isBST());
		System.out.println("Height: " + root.height());
	}

}
