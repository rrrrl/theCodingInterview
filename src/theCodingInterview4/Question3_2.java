package theCodingInterview4;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

import CtCILibrary.*;

public class Question3_2 {
	public static ArrayList<LinkedList<TreeNode>> createLevelLinkedList(TreeNode node) {
		ArrayList<LinkedList<TreeNode>> lists = new ArrayList<LinkedList<TreeNode>>();
		LinkedList<TreeNode> current = new LinkedList<TreeNode>();
		
		if(node != null) {
			current.add(node);
		}
		
		while(current.size() > 0) {
			lists.add(current);
			LinkedList<TreeNode> parent = current;
			current = new LinkedList<TreeNode>();
			for(TreeNode n : parent) {
				if(n.left != null) {
					current.add(n.left);
				} 
				if(n.right != null) {
					current.add(n.right);
				}
			}
		}
		
		return lists;
		
	}
	
	public static void printResult(ArrayList<LinkedList<TreeNode>> result){
		int depth = 0;
		for(LinkedList<TreeNode> entry : result) {
			Iterator<TreeNode> i = entry.listIterator();
			System.out.print("Link list at depth " + depth + ":");
			while(i.hasNext()){
				System.out.print(" " + ((TreeNode)i.next()).data);
			}
			System.out.println();
			depth++;
		}
	}

	public static void main(String[] args) {
		int[] nodes_flattened = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		TreeNode root = AssortedMethods.createTreeFromArray(nodes_flattened);
		ArrayList<LinkedList<TreeNode>> list = createLevelLinkedList(root);
		printResult(list);
	}
}
