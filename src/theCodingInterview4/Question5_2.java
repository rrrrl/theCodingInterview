package theCodingInterview4;

import CtCILibrary.TreeNode;

public class Question5_2 {
	public static boolean checkBST(TreeNode node) {
		return checkBST(node, null, null);
	}
	
	public static boolean checkBST(TreeNode n, Integer min, Integer max) {
		if(n == null) return true;
		
		if((min!=null && n.data<=min) || (max!=null && n.data>max)) {
			return false;
		}
		
		if(!checkBST(n.left, min, n.data) || !checkBST(n.right, n.data, max)) {
			return false;
		}
		
		return true;
	}
	
	public static void main(String[] args) {
		int[] array = {Integer.MIN_VALUE, 3, 5, 6, 10, 13, 15, Integer.MAX_VALUE};
		TreeNode node = TreeNode.createMinimalBST(array);
		//node.left.data = 7;
		node.print();
		boolean isBst = checkBST(node);
		System.out.println(isBst);
		
	}
}
