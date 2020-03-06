package theCodingInterview4;

import CtCILibrary.TreeNode;

public class Question5 {
	public static Integer lastPrinted = null;

	public static boolean checkBST(TreeNode node) {
		return checkBST(node, true);
	}

	public static boolean checkBST(TreeNode n, boolean isLeft) {
		if(n == null)	return true;
		
		if(!checkBST(n.left, true))	return false;
		
		if(lastPrinted != null) {
			if(isLeft) {
				if(n.data < lastPrinted) {
					return false;
				}
			} else {
				if(n.data <= lastPrinted) {
					return false;
				}
			}
		}		
		lastPrinted = n.data;
		
		if(!checkBST(n.right, false))	return false;
		
		return true;
	}

	public static void main(String[] args) {
		int[] array = {1, 2, 3, 4};
		TreeNode node = TreeNode.createMinimalBST(array);
		//node.left.data = 5;
		//node.left.right.data = 3;
		System.out.println(checkBST(node));

	}

}
