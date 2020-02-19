package theCodingInterview2;

import CtCILibrary.*;
import CtCILibrary.LinkedListNode;

public class Question2 {
	
	public static int printKthToLast(LinkedListNode head, int k) {
		if(head == null) 
			return 0;
		int index = printKthToLast(head.next, k) + 1;
		if(index == k) {
			System.out.println(index + " => " + head.data);
		}
		return index;
	}
	
	public static void main(String[] args) {
		int[] array = {0, 1, 2, 3, 4, 5, 6};
		LinkedListNode head = AssortedMethods.createLinkedListFromArray(array);
		//System.out.println(head.printForward());
		
		//for (int i = 1; i <= array.length + 1; i++) {
			printKthToLast(head, 3);
		//}
		
	}
}
