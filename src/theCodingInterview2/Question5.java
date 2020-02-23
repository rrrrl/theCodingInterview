package theCodingInterview2;

public class Question5 {
	public static LinkedListNode addLists(LinkedListNode lA1, LinkedListNode lB1) {
		return addLists(lA1, lB1, 0);
	}
	
	public static LinkedListNode addLists(LinkedListNode l1, LinkedListNode l2, int carry) {
		if(l1 == null && l2 == null && carry == 0) {
			return null;
		}
		int value = carry;
		LinkedListNode result = new LinkedListNode();
		
		if(l1 != null) {
			value += l1.data;
		}
		if(l2 != null) {
			value += l2.data;
		}
		
		result.data = value % 10;
		
		if(l1 != null || l2 != null) {
			result.next = addLists(l1==null?null:l1.next, l2==null?null:l2.next, value<10?0:1);
		}
		
		return result;
		
	}
	
	public static int linkedListToInt(LinkedListNode li) {
		int value = 0;
		if(li.next != null) {
			value = 10 * linkedListToInt(li.next);
		}
		return value + li.data;
	}
	
	public static void main(String[] args) {
		LinkedListNode lA1 = new LinkedListNode(7, null, null);
		LinkedListNode lA2 = new LinkedListNode(1, null, lA1);
		LinkedListNode lA3 = new LinkedListNode(6, null, lA2);
		
		LinkedListNode lB1 = new LinkedListNode(5, null, null);
		LinkedListNode lB2 = new LinkedListNode(9, null, lB1);
		LinkedListNode lB3 = new LinkedListNode(2, null, lB2);	
		
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
