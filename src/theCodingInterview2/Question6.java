package theCodingInterview2;

public class Question6 {
	
	public static boolean isPalindrome(LinkedListNode head) {
		LinkedListNode result = reverseAndClone(head);
		return isEqual(head, result);
	}
	
	public static LinkedListNode reverseAndClone(LinkedListNode node) {
		LinkedListNode head = null;
		while(node != null) {
			LinkedListNode n = new LinkedListNode(node.data);
			n.next = head;
			head = n;
			node = node.next;
		}
		return head;
	}
	
	public static boolean isEqual(LinkedListNode one, LinkedListNode two) {
		if(one == null && two == null) {
			return false;
		}
		while(one != null && two != null) {
			if(one.data != two.data) {
				return false;
			}
			one = one.next;
			two = two.next;
		}
		return true;
	}
	
	public static void main(String[] args) {
		int length = 9;
		LinkedListNode[] nodes = new LinkedListNode[length];
		for (int i = 0; i < length; i++) {
			nodes[i] = new LinkedListNode(i >= length / 2 ? length - i - 1 : i, null, null);
		}
		
		for (int i = 0; i < length; i++) {
			if (i < length - 1) {
				nodes[i].setNext(nodes[i + 1]);
			}
			if (i > 0) {
				nodes[i].setPrevious(nodes[i - 1]);
			}
		}
		nodes[length - 2].data = 9; // Uncomment to ruin palindrome
		
		LinkedListNode head = nodes[0];
		System.out.println(head.printForward());
		System.out.println(isPalindrome(head));
	}
}
