package theCodingInterview2;

public class Question6_3 {
	public static class Result {
		public LinkedListNode node;
		public boolean result;
		public Result(LinkedListNode n, boolean res) {
			node = n;
			result = res;
		}
	}
	
	public static boolean isPalindrome(LinkedListNode head) {
		int length = lengthOfList(head);
		
		Result res = isPalindromeRecurse(head, length);
		
		return res.result;
	}
	
	public static int lengthOfList(LinkedListNode n) {
		int leng = 0;
		while(n != null) {
			leng++;
			n = n.next;
		}
		return leng;
	}
	
	public static Result isPalindromeRecurse(LinkedListNode head, int length) {
		if(head == null || length <= 0) {
			return new Result(head, true);
		} else if(length == 1) {
			return new Result(head.next, true);
		}
		
		Result res = isPalindromeRecurse(head.next, length-2);
		
		if(!res.result || res.node == null) {
			return res;
		}
		
		if(res.node.data == head.data) {
			res.result = true;
		} else {
			res.result = false;
		}
		
		res.node = res.node.next;
		
		return res;
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
