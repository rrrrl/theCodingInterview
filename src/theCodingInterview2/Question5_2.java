package theCodingInterview2;

public class Question5_2 {
	
	public static class PartialSum {
		public LinkedListNode sum = null;
		public int carry = 0;
	}
		
	private static int leng(LinkedListNode li) {
		int len = 1;
		
		if(li.next != null) {
			len = 1 + leng(li.next);
		}
		return len;
	}
	
	private static LinkedListNode addLists(LinkedListNode li1, LinkedListNode li2) {
		int len1 = leng(li1);
		int len2 = leng(li2);
		
		if(len1 < len2) {
			li1 = padList(li1, len2 - len1);
		} else {
			li2 = padList(li2, len1 - len2);
		}
		
		PartialSum sum = addListsHelper(li1, li2);
		
		return sum.sum;
	}
	
	private static PartialSum addListsHelper(LinkedListNode l1, LinkedListNode l2) {
		if(l1 == null && l2 == null) {
			PartialSum sum = new PartialSum();
			return sum;
		}
		
		PartialSum sum = addListsHelper(l1.next, l2.next);
		
		int value = 0;
		value = sum.carry + l1.data + l2.data;
		
		LinkedListNode node = insertBefore(sum.sum, value%10);
		sum.carry = value / 10;
		sum.sum = node;
		return sum;
	}
	
	private static LinkedListNode padList(LinkedListNode li, int padding) {
		LinkedListNode head = li;
		for(int i=0 ; i<padding ; i++) {
			head = insertBefore(head, 0);
		}
		return head;
	}
	
	private static LinkedListNode insertBefore(LinkedListNode li, int data) {
		LinkedListNode node = new LinkedListNode(data, null, null);
		node.next = li;
		return node;
	}
	
	public static int linkedListToInt(LinkedListNode li) {
		int value = 0;
		LinkedListNode node = li;
		while(node != null) {
			value = value * 10 + node.data;
			node = node.next;
		}
		return value;
	}
	
	public static void main(String[] args) {
		LinkedListNode lA1 = new LinkedListNode(1, null, null);
		LinkedListNode lA2 = new LinkedListNode(2, null, lA1);
		LinkedListNode lA3 = new LinkedListNode(3, null, lA2);
		LinkedListNode lA4 = new LinkedListNode(4, null, lA3);
		
		LinkedListNode lB1 = new LinkedListNode(5, null, null);
		LinkedListNode lB2 = new LinkedListNode(6, null, lB1);
		LinkedListNode lB3 = new LinkedListNode(7, null, lB2);	
		
		LinkedListNode list3 = addLists(lA1, lB1);
		
		System.out.println("  " + lA1.printForward());		
		System.out.println("+ " + lB1.printForward());			
		System.out.println("= " + list3.printForward());	
		
		int l1 = linkedListToInt(lA1);
		int l2 = linkedListToInt(lB1);
		int l3 = linkedListToInt(list3);
		
		System.out.print(l1 + " + " + l2 + " = " + l3 + "\n");
		System.out.print(l1 + " + " + l2 + " = " + (l1 + l2));		
	}
}
