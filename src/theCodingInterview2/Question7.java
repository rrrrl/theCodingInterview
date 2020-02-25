package theCodingInterview2;

import CtCILibrary.*;
import CtCILibrary.LinkedListNode;

public class Question7 {
	
	public static class Result {
		public LinkedListNode last;
		public int length;
		public Result(LinkedListNode node, int leng) {
			last = node;
			length = leng;
		}
	}
	
	public static Result getTailAndSize(LinkedListNode list) {
		LinkedListNode node = list;
		int leng = 1;
		while(node.next != null) {
			leng++;
			node = node.next;
		}
		return new Result(node, leng);
	}
	
	public static LinkedListNode getKthNode(LinkedListNode head, int k) {
		for(int i=0 ; i<k ; i++) {
			head = head.next;
		}
		return head;
	}
	
	public static LinkedListNode findIntersection(LinkedListNode list1, LinkedListNode list2) {
		Result res1 = getTailAndSize(list1);
		Result res2 = getTailAndSize(list2);
		
		LinkedListNode shorter = res1.length > res2.length ? list2 : list1;
		LinkedListNode longer = res1.length > res2.length ? list1 : list2;
		
		if(res1.last != res2.last) {
			return null;
		}
		
		longer = getKthNode(longer, Math.abs(res1.length - res2.length));
		
		while(longer != shorter) {
			longer = longer.next;
			shorter = shorter.next;
		}
		
		return longer;
		
	}
	
	public static void main(String[] args) {
		/* Create linked list */
		int[] vals = {3, 1, 5, 9, 7, 2, 1};
		LinkedListNode list1 = AssortedMethods.createLinkedListFromArray(vals);
		
		int[] vals2 = {4, 6};
		LinkedListNode list2 = AssortedMethods.createLinkedListFromArray(vals2);
		
		list2.next = list1.next.next.next.next;
		
		System.out.println(list1.printForward());
		System.out.println(list2.printForward());
		
		
		LinkedListNode intersection = findIntersection(list1, list2);
		
		System.out.println(intersection.printForward());
	}
}
